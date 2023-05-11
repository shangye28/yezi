<template>
  <div>
    <el-form :inline="true" :model="state.pages" class="demo-form-inline">
      <el-form-item label="部门名称">
        <el-input v-model="state.pages.deptName" placeholder="请输入部门名称" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSearch">查询</el-button>
        <el-button @click="onReset">重置</el-button>
      </el-form-item>
    </el-form>

    <div class="table-btn">
      <el-button type="primary" icon="Plus" @click="BtnAddDept">新增</el-button>
    </div>

    <el-table
      :data="state.tableData"
      :header-cell-style="{ background: exCss.primaryColor, color: '#fff' }"
      style="width: 100%"
      row-key="deptId"
      :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
    >
      <el-table-column prop="deptName" label="部门名称" />
      <el-table-column prop="orderNum" label="排序" />
      <el-table-column prop="status" label="状态">
        <template #default="scope">
          <el-tag v-if="scope.row.status === '1'" class="ml-2" type="danger">
            停用
          </el-tag>
          <el-tag v-if="scope.row.status === '0'" class="ml-2" type="success">
            正常
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间" />
      <el-table-column label="操作" align="center" width="260">
        <template #default="scope">
          <el-button
            text
            type="primary"
            icon="Plus"
            style="width: 50px"
            @click="rowAddDept(scope.row)"
          >
            添加
          </el-button>
          <el-button
            text
            type="primary"
            icon="Edit"
            style="width: 50px"
            @click="rowUpdateDept(scope.row)"
          >
            修改
          </el-button>
          <el-button
            text
            type="primary"
            icon="Delete"
            style="width: 50px"
            @click="rowRemoveDept(scope.row)"
            v-if="scope.row.deptId !== 100"
          >
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <dept-dialog
      ref="deptEl"
      :dialog-visible="state.isShow"
      :title="state.isAdd ? '新增部门' : '修改部门'"
      :is-add="state.isAdd"
      @close="close"
    />
  </div>
</template>
<script setup>
import exCss from '@/style/module/primary.module.scss'
import { nextTick, onMounted, reactive, ref } from 'vue'
import { delDept, listDept } from '@/api/dept/index.ts'
import DeptDialog from '@/view/system/component/DeptDialog.vue'
import { ElMessageBox } from 'element-plus'
import { zxLoading } from '@/utils/loading'

const deptEl = ref()
const state = reactive({
  pages: {
    deptName: '',
  },
  isAdd: false,
  isShow: false,
  tableData: [],
})

onMounted(() => {
  onSearch()
})
// 查询
const onSearch = () => {
  getData()
}
// 重置
const onReset = () => {
  state.pages.deptName = ''
  onSearch()
}
// 公用的查询方法
const getData = () => {
  zxLoading.show()
  listDept(state.pages)
    .then((res) => {
      state.tableData = handTree(res.data)
    })
    .finally(() => {
      zxLoading.hidden()
    })
}
// 单独按钮添加
const BtnAddDept = () => {
  state.isAdd = true
  state.isShow = true
  nextTick(() => {
    deptEl.value.setFormData(null)
  })
}
// 行添加
const rowAddDept = (row) => {
  state.isAdd = true
  state.isShow = true
  nextTick(() => {
    deptEl.value.setFormData(row.deptId)
  })
}
// 行修改
const rowUpdateDept = (row) => {
  state.isAdd = false
  state.isShow = true
  nextTick(() => {
    deptEl.value.setFormData(row)
  })
}
// 行删除
const rowRemoveDept = (row) => {
  ElMessageBox.confirm(`确认删除【${row.deptName}】吗`, '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning',
  }).then(() => {
    delDept(row.deptId).then((res) => {
      ElMessage({
        type: 'success',
        message: '删除成功',
      })
      onSearch()
    })
  })
}
// 关闭弹框
const close = (type) => {
  if (type) {
    onSearch()
  }
  state.isShow = false
}
// 构造树形结构
const handTree = (list) => {
  if (state.pages.deptName) {
    return list
  }
  return list.reduce((prev, curr, i, arr) => {
    curr.children = arr.filter((item) => item.parentId === curr.deptId)
    if (curr.parentId === 0) {
      prev.push(curr)
    }
    return prev
  }, [])
}
</script>

<style scoped lang="scss">
.pagination-block {
  margin-top: 10px;
  float: right;
}

.table-btn {
  margin-bottom: 10px;
}
</style>

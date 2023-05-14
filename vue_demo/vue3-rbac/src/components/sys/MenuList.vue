<template>
  <div>
    <!--查询表单-->
    <el-form :inline="true" :model="state.formInline" class="demo-form-inline">
      <el-form-item label="菜单名称">
        <el-input
          v-model="state.formInline.menuName"
          placeholder="请输入菜单名称"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
        <el-button @click="reset">重置</el-button>
      </el-form-item>
    </el-form>
    <!--增加按钮-->
    <el-button type="primary" style="margin-bottom: 10px" @click="addMenu()">
      新增菜单
    </el-button>
    <!--列表组件-->
    <el-table
      :header-cell-style="{ background: exCss.primaryColor, color: '#fff' }"
      :data="state.tableData"
      stripe
      style="width: 100%"
      row-key="menuId"
      :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
      v-loading="state.loading"
    >
      <el-table-column prop="menuName" label="菜单名称" />
      <el-table-column label="菜单类型">
        <template #default="scope">
          <el-tag v-if="scope.row.menuType === 'M'" class="ml-2" type="warning">
            目录
          </el-tag>
          <el-tag v-if="scope.row.menuType === 'C'" class="ml-2" type="success">
            菜单
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="orderNum" label="排序" />
      <el-table-column prop="perms" label="权限标识" />
      <el-table-column prop="component" label="组件路径" />
      <el-table-column prop="path" label="路由地址" />
      <el-table-column label="状态" >
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
            @click="rowShowDialog(scope.row, 'add')"
          >
            添加
          </el-button>
          <el-button
            text
            type="primary"
            icon="Edit"
            style="width: 50px"
            @click="rowShowDialog(scope.row, 'update')"
          >
            修改
          </el-button>
          <el-button
            text
            type="primary"
            icon="Delete"
            style="width: 50px"
            @click="removeMenu(scope.row)"
          >
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--新增和编辑菜单弹框-->
    <add-menu-dialog
      ref="addEl"
      :dialog-visible="state.isShow"
      :title="state.isAdd ? '新增菜单' : '编辑菜单'"
      :is-add="state.isAdd"
      @close="close"
    />
  </div>
</template>

<script setup>
// 使用scss变量，动态改变表头颜色
import exCss from '@/style/module/primary.module.scss'
import { onMounted, reactive, nextTick, ref } from 'vue'
import { delMenuFun, menuListFun } from '@/api/menu/index'
import AddMenuDialog from '@/view/system/component/AddMenuDialog.vue'
import { ElMessageBox } from 'element-plus'

const addEl = ref()
// 普通数据
const state = reactive({
  tableData: [],
  formInline: {},
  isShow: false,
  isAdd: false,
  rowVal: null,
  loading: false,
})
onMounted(() => {
  getMenuList()
})
// 关闭弹框方法
const close = (isUpdate) => {
  state.isShow = false
  if (isUpdate) {
    getMenuList()
  }
}
// 查询方法
const onSubmit = () => {
  getMenuList()
}
// 重置方法
const reset = () => {
  state.formInline = {}
  getMenuList()
}
// 查询菜单列表
const getMenuList = () => {
  state.loading = true
  menuListFun(state.formInline.menuName)
    .then((res) => {
      if (state.formInline.menuName) {
        state.tableData = res.data
      } else {
        state.tableData = nestingMenu(res.data)
      }
    })
    .finally(() => {
      state.loading = false
    })
}
// 将一维菜单转成树形结构
const nestingMenu = (list) => {
  if (Array.isArray(list)) {
    return list.reduce((prev, curr, i, arr) => {
      curr.children = arr.filter((item) => item.parentId === curr.menuId)
      // 判断如果是根菜单就push
      if (curr.parentId === 0) {
        prev.push(curr)
      }
      return prev
    }, [])
  }
}
// 添加菜单
const addMenu = () => {
  state.isAdd = true
  state.isShow = true
  nextTick(() => {
    addEl.value.resetForm()
  })
}
// 行内点击按钮
const rowShowDialog = (row, type) => {
  state.isAdd = type === 'add'
  state.isShow = true
  nextTick(() => {
    addEl.value.resetForm(row)
  })
}
// 删除菜单
const removeMenu = ({ menuId, menuName }) => {
  ElMessageBox.confirm(`确认删除【${menuName}】菜单吗`, '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning',
  }).then(() => {
    delMenuFun(menuId).then((res) => {
      ElMessage({
        type: 'success',
        message: '删除成功',
      })
      getMenuList()
    })
  })
}
</script>

<template>
  <div class="app-container">
    <div class="search">
      <el-form ref="queryFormRef" :model="queryParams" :inline="true">
        <el-form-item label="关键字" prop="keywords">
          <el-input
            v-model="queryParams.keywords"
            placeholder="菜单名称"
            clearable
            @keyup.enter="handleQuery"
          />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleQuery"
            ><template #icon><i-ep-search /></template>搜索</el-button
          >
          <el-button @click="resetQuery">
            <template #icon><i-ep-refresh /></template>
            重置</el-button
          >
        </el-form-item>
      </el-form>
    </div>

    <!-- <el-card shadow="never">
      <template #header>
        <el-button type="success" @click="openDialog(0)">
          <template #icon><i-ep-plus /></template>
          新增</el-button
        >
      </template>

      <el-table
        v-loading="loading"
        :data="menuList"
        highlight-current-row
        :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
        @row-click="onRowClick"
        row-key="id"
        default-expand-all
        border
      >
        <el-table-column label="菜单名称" min-width="200">
          <template #default="scope">
            <svg-icon
              :icon-class="
                scope.row.type === MenuTypeEnum.BUTTON
                  ? 'button'
                  : scope.row.icon
              "
            />
            {{ scope.row.name }}
          </template>
        </el-table-column>

        <el-table-column label="菜单类型" align="center" width="150">
          <template #default="scope">
            <el-tag
              v-if="scope.row.type === MenuTypeEnum.CATALOG"
              type="warning"
              >目录</el-tag
            >
            <el-tag v-if="scope.row.type === MenuTypeEnum.MENU" type="success"
              >菜单</el-tag
            >
            <el-tag v-if="scope.row.type === MenuTypeEnum.BUTTON" type="danger"
              >按钮</el-tag
            >
            <el-tag v-if="scope.row.type === MenuTypeEnum.EXTLINK" type="info"
              >外链</el-tag
            >
          </template>
        </el-table-column>
        <el-table-column
          label="权限标识"
          align="center"
          width="200"
          prop="perm"
        />

        <el-table-column label="状态" align="center" width="150">
          <template #default="scope">
            <el-tag v-if="scope.row.visible === 1" type="success">显示</el-tag>
            <el-tag v-else type="info">隐藏</el-tag>
          </template>
        </el-table-column>

        <el-table-column label="排序" align="center" width="100" prop="sort" />

        <el-table-column fixed="right" align="center" label="操作" width="220">
          <template #default="scope">
            <el-button
              type="primary"
              link
              size="small"
              @click.stop="openDialog(scope.row.id)"
              v-if="scope.row.type == 'CATALOG' || scope.row.type == 'MENU'"
            >
              <i-ep-plus />新增
            </el-button>

            <el-button
              type="primary"
              link
              size="small"
              @click.stop="openDialog(undefined, scope.row.id)"
            >
              <i-ep-edit />编辑
            </el-button>
            <el-button
              type="primary"
              link
              size="small"
              @click.stop="handleDelete(scope.row.id)"
              ><i-ep-delete />
              删除
            </el-button>
          </template>
        </el-table-column>
      </el-table> -->
    <!-- </el-card> -->

    <!-- <el-dialog
      :title="dialog.title"
      v-model="dialog.visible"
      @close="closeDialog"
      destroy-on-close
      appendToBody
      width="750px"
    >
      <el-form
        ref="menuFormRef"
        :model="formData"
        :rules="rules"
        label-width="100px"
      >
        <el-form-item label="父级菜单" prop="parentId">
          <el-tree-select
            v-model="formData.parentId"
            placeholder="选择上级菜单"
            :data="menuOptions"
            filterable
            check-strictly
            :render-after-expand="false"
          />
        </el-form-item> -->

        <!-- <el-form-item label="菜单名称" prop="name">
          <el-input v-model="formData.name" placeholder="请输入菜单名称" />
        </el-form-item>

        <el-form-item label="菜单类型" prop="type">
          <el-radio-group v-model="formData.type" @change="onMenuTypeChange">
            <el-radio label="CATALOG">目录</el-radio>
            <el-radio label="MENU">菜单</el-radio>
            <el-radio label="BUTTON">按钮</el-radio>
            <el-radio label="EXTLINK">外链</el-radio>
          </el-radio-group>
        </el-form-item> -->

        <!-- <el-form-item
          v-if="formData.type == 'EXTLINK'"
          label="外链地址"
          prop="path"
        >
          <el-input v-model="formData.path" placeholder="请输入外链完整路径" />
        </el-form-item>

        <el-form-item
          label="路由路径"
          prop="path"
          v-if="formData.type == 'CATALOG' || formData.type == 'MENU'"
        >
          <el-input
            v-if="formData.type == 'CATALOG'"
            v-model="formData.path"
            placeholder="/system  (目录以/开头)"
          />
          <el-input v-else v-model="formData.path" placeholder="user" />
        </el-form-item> -->

        <!-- 组件页面完整路径 -->
        <!-- <el-form-item
          v-if="formData.type == MenuTypeEnum.MENU"
          label="页面路径"
          prop="component"
        >
          <el-input
            v-model="formData.component"
            placeholder="system/user/index"
            style="width: 95%"
          >
            <template v-if="formData.parentId != 0" #prepend
              >src/views/</template
            >
            <template v-if="formData.parentId != 0" #append>.vue</template>
          </el-input>
        </el-form-item> -->

        <!-- 权限标识 -->
        <!-- <el-form-item
          v-if="formData.type == 'BUTTON'"
          label="权限标识"
          prop="perm"
        >
          <el-input v-model="formData.perm" placeholder="sys:user:add" />
        </el-form-item> -->

        <!-- <el-form-item
          label="图标"
          prop="icon"
          v-if="formData.type !== 'BUTTON'"
        > -->
          <!-- 图标选择器 -->
          <!-- <icon-select v-model="formData.icon" />
        </el-form-item>

        <el-form-item
          label="跳转路由"
          v-if="formData.type == MenuTypeEnum.CATALOG"
        >
          <el-input v-model="formData.redirect" placeholder="跳转路由" />
        </el-form-item> -->

        <!-- <el-form-item label="状态" v-if="formData.type !== 'BUTTON'">
          <el-radio-group v-model="formData.visible">
            <el-radio :label="1">显示</el-radio>
            <el-radio :label="0">隐藏</el-radio>
          </el-radio-group>
        </el-form-item> -->

        <!-- <el-form-item label="排序" prop="sort">
          <el-input-number
            v-model="formData.sort"
            style="width: 100px"
            controls-position="right"
            :min="0"
          />
        </el-form-item> -->
      <!-- </el-form> -->

      <!-- <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="closeDialog">取 消</el-button>
        </div>
      </template> -->
    <!-- </el-dialog> -->
  </div>
</template>

<script>
import { menuAll } from "@/api/api.js";

export default {
  data() {
    return {
      queryParams: {
        keywords: "",
      },
    };
  },
  created() {
    this.getData();
  },
  methods: {
    getData() {
      menuAll().then((res) => {
        console.log(res);
      });
    },
    /**
     * 查询
     */
    handleQuery() {
      // 重置父组件
      loading.value = true;
      findMenu(queryParams)
        .then(({ data }) => {
          menuList.value = data;
        })
        .then(() => {
          loading.value = false;
        });
    },
    /**
     * 查询重置
     */
    resetQuery() {
      queryFormRef.value.resetFields();
      handleQuery();
    },
  },
};
</script>

<template>
  <div class="roleList">
    <!-- 查询数据、重置 -->
    <el-form
      :inline="true"
      :model="formInline"
      class="demo-form-inline"
      size="small"
    >
      <el-form-item label="角色名">
        <el-input v-model="formInline.roleName" placeholder="请输入"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="find()">查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="reset()">重置</el-button>
      </el-form-item>
    </el-form>

    <el-table :data="compData" style="width: 100%">
      <el-table-column prop="roleName" label="角色名" align="center" width="240" >
      </el-table-column>
      <el-table-column prop="roleKey" label="角色值" align="center" width="240" >
      </el-table-column>
      <el-table-column prop="roleSort" label="排序" align="center" width="120" >
      </el-table-column>
      <el-table-column prop="status_text" label="状态" align="center"  width="240">
      </el-table-column>
      <el-table-column prop="remake" label="备注" align="center" width="300">
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="200">
        <template #default="scope">
          <el-button link type="primary" size="small">Edit</el-button>
          <el-button link type="primary" size="small" @click="del(scope.row)"
            >Delete</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[5, 10, 20, 30, 50]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
    >
    </el-pagination>
  </div>
</template>

<script>
import { roleAll, findByRoleName, roleDel } from "@/api/api.js";

export default {
  data() {
    return {
      tableData: [],
      currentPage: 1, //当前页数
      pageSize: 10, //每页显示条数
      total: 0, //总条数
      formInline: {
        roleName: "",
      },
      row: {
        roleName: "",
      },
    };
  },
  created() {
    this.getData();
  },
  computed: {
    compData() {
      return this.tableData.slice(
        (this.currentPage - 1) * this.pageSize,
        this.currentPage * this.pageSize
      );
    },
  },
  methods: {
    find() {
      console.log(this.formInline);
      findByRoleName(this.formInline).then((res) => {
        console.log(res);
        if (res.data.statusCode === 200) {
          this.tableData = res.data.data.list;
          this.total = res.data.data.total;
        }
      });
    },
    reset() {
      console.log(this.formInline);
      this.formInline = {};
      this.getData(this.formInline);
    },
    handleSizeChange(val) {
      this.pageSize = val;
      this.currentPage = 1;
    },
    handleCurrentChange(val) {
      this.currentPage = val;
    },
    getData() {
      roleAll().then((res) => {
        console.log(res);
        if (res.data.statusCode === 200) {
          this.tableData = res.data.data.list;
          this.total = res.data.data.total;
          this.tableData.forEach((item) => {
            item.state === "0"
              ? (item.status_text = "停用")
              : (item.status_text = "正常");
          });
        }
      });
    },
    del(row) {
      console.log(row);
      studentDel(row).then((res) => {
        console.log(res);
        if (res.data.status === 200) {
          this.$message({ message: "删除成功", type: "success" });
          this.getData();
        }
      });
    },
  },
};
</script>

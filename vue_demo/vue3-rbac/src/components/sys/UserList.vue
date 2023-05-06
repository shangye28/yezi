<template>
  <div class="userList">
    <!-- 查询数据、重置 -->
    <el-form
      :inline="true"
      :model="formInline"
      class="demo-form-inline"
      size="primary"
    >
      <el-form-item label="用户名">
        <el-input v-model="formInline.username" placeholder="请输入"></el-input>
      </el-form-item>

      <el-form-item label="昵称">
        <el-input v-model="formInline.nickname" placeholder="请输入"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="find()">查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="reset()">重置</el-button>
      </el-form-item>
    </el-form>

    <el-button type="primary" text @click="dialogFormVisible = true"> 新增 </el-button>
    <el-dialog v-model="dialogFormVisible" title="添加用户信息" width="500px">
      <el-form :model="form" :rules="rules" ref="form">
        <el-form-item
          label="用户名"
          prop="username"
          :label-width="formLabelWidth"
        >
          <el-input v-model="form.username" autocomplete="off" />
        </el-form-item>
        <el-form-item
          label="昵称"
          prop="nickname"
          :label-width="formLabelWidth"
        >
          <el-input v-model="form.nickname" autocomplete="off" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email" :label-width="formLabelWidth">
          <el-input v-model="form.email" autocomplete="off" />
        </el-form-item>
        <el-form-item label="性别" prop="sex" :label-width="formLabelWidth">
          <el-radio v-model="form.sex" label="1">男</el-radio>
          <el-radio v-model="form.sex" label="2">女</el-radio>
        </el-form-item>
        <el-form-item label="电话" prop="phone" :label-width="formLabelWidth">
          <el-input v-model="form.phone" autocomplete="off" />
        </el-form-item>
        <el-form-item label="备注" prop="remake" :label-width="formLabelWidth">
          <el-input v-model="form.remake" autocomplete="off" />
        </el-form-item>
    <el-form-item>
        <el-select v-model="form.deptId" placeholder="部门">
          <el-option label="研发部" value="15" />
          <el-option label="市场部" value="16" />
        </el-select>
    </el-form-item>
<el-form-item>
        <el-select v-model="form.role" placeholder="角色">
          <el-option label="超级管理员" value="1" />
          <el-option label="管理员" value="2" />
          <el-option label="普通用户" value="3" />
        </el-select>
    </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取消</el-button>
          <el-button type="primary" @click="sure('form')">
            确定
          </el-button>
        </span>
      </template>
    </el-dialog>

    <!-- 表单数据 -->
    <!-- <el-table :data="tableData.slice((currentPage-1) * pageSize, currentPage * pageSize)" style="width: 100%"> -->

    <el-table :data="compData" style="width: 100%">
      <el-table-column type="index" label="序号" align="center" width="80">
        <template #default="scope">
          <span v-html="scope.$index + (currentPage - 1) * pageSize + 1"></span>
        </template>
      </el-table-column>
      <el-table-column
        prop="username"
        label="用户名"
        align="center"
        width="120"
      >
      </el-table-column>
      <el-table-column prop="nickname" label="昵称" align="center" width="120">
      </el-table-column>
      <el-table-column prop="email" label="邮箱" align="center" width="200">
      </el-table-column>
      <el-table-column prop="phone" label="电话" align="center" width="150">
      </el-table-column>
      <el-table-column
        prop="createTime_text"
        label="创建时间"
        align="center"
        width="110"
      >
      </el-table-column>
      <el-table-column prop="role" label="角色" align="center" width="120">
      </el-table-column>
      <el-table-column prop="remake" label="备注" align="center" width="240">
      </el-table-column>

      <el-table-column fixed="right" label="操作" align="center" width="200">
        <template #default="scope">
          <!-- <el-button
            type="primary"
            size="small"
            text
            @click="dialogPasswordVisible = true"
            >重置密码</el-button
          >

          <el-dialog v-model="dialogPasswordVisible" title="修改密码" width="500px">
      <el-form :model="password" :rules="rules" ref="password">
        <el-form-item
          label="密码"
          prop="password"
          :label-width="formLabelWidth"
        >
          <el-input v-model="password.password" autocomplete="off" />
        </el-form-item>
        
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogPasswordVisible = false">取消</el-button>
          <el-button type="primary" @click="sure()">
            确定
          </el-button>
        </span>
      </template>
    </el-dialog> -->

          <el-button link type="primary" size="small" @click="update(scope.row)"
            >编辑</el-button
          >

          <el-button
          link
          type="primary"
          size="small"
          @click.prevent="deleteRow(scope.row)"
        >
          删除
        </el-button>
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
import { userAll, findByName, deleteUser, userAdd } from "@/api/api.js";
import { nameRule, emailRule } from '../../utils/vaildate.js'
export default {
  data() {
    return {
      // roleData: [],
      tableData: [],
      currentPage: 1, //当前页数
      pageSize: 10, //每页显示条数
      total: 0, //总条数
      formInline: {
        username: "",
        nickname: "",
      },
      dialogFormVisible: false,
      password: {
        password: "",
      },
      form: {
        username: "",
        nickname: "",
        email: "",
        sex: "1",
        phone: "",
        remake: "",
        deptId: "",
        role: ""
      },
      formLabelWidth: "80px",
      rules: {
        username: [{validator: nameRule, trigger: 'blur'}], 
        nickname: [{required: true, message: '请输入昵称'}],
        email: [{validator: emailRule, trigger: 'blur'}],
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
      findByName(this.formInline).then((res) => {
        console.log(res);
        if (res.data.statusCode === 200) {
          this.tableData = res.data.data.list;
          this.total = res.data.data.total;
          this.tableData.forEach((item) => {
            console.log(item.roles);
            if(item.roles.length != 0){
                item.role = item.roles[0].roleName;
            }  
            if(item.createTime != null){
                item.createTime_text = item.createTime
              .replace(/T/g, " ")
              .replace(/\.[\d]{3}Z/, "");
            }
          });
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
      userAll().then((res) => {
        console.log(res);
        if (res.data.statusCode === 200) {
          this.tableData = res.data.data.list;
          this.total = res.data.data.total;
          this.tableData.forEach((item) => {
            if(item.roles.length != 0){
                item.role = item.roles[0].roleName;
            }  
            item.createTime_text = item.createTime
              .replace(/T/g, " ")
              .replace(/\.[\d]{3}Z/, "");
          });
          // this.total = res.data.total     //总数据个数
          //性别、状态的转换
          // this.tableData.forEach(item => {
          //     item.sex === '0'
          //         ? item.sex_text = '男'
          //         : item.sex === '1'
          //             ? item.sex_text = '女'
          //             : item.sex_text = '未知'
          //     item.state === '0'
          //         ? (item.status_text = '停用')
          //         : (item.status_text = '正常')
          // });
        }
      });
    },
    deleteRow(row) {
        let data = {"username": row.username}
      console.log(row.username);
      deleteUser(data).then((res) => {
        if (res.data.status === 200) {
          this.$message({ message: "删除成功", type: "success" });
          this.getData();
        }
      });
    },

    update(row) {
      console.log(row);
      studentDel(row.id).then((res) => {
        console.log(res);
        if (res.data.status === 200) {
          this.$message({ message: "删除成功", type: "success" });
          this.getData();
        }
      });
    },

    sure(form) {
      this.$refs[form].validate(valid => {
        if(valid) {
            console.log(form, this.form)
            userAdd(this.form).then(res => {
                if (res.data.status === 200) {
          this.$message({ message: "操作成功", type: "success" });
          this.dialogFormVisible = false;
          this.getData();

        }
            })
        }
      })
    },
  },
};
</script>

<style lang="scss">
.userList {
  .demo-form-inline,
  .el-form-item {
    text-align: left;
  }

  .el-pangination {
    text-align: left;
    margin-top: 20px;
  }
}
</style>

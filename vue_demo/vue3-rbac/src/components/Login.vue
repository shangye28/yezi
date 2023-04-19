<template>
  <div class="login-body">
    <el-card class="box-card">
      <div class="clearfix">
        <span>RBAC后台管理系统</span>
      </div>
      <el-form label-width="80px" :model="form" ref="form" :rules="rules">
        <el-form-item label="用户名" prop="username">
          <el-input
            placeholder="请输入用户名"
            v-model="form.username"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
            placeholder="请输入密码"
            type="password"
            v-model="form.password"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login('form')">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { nameRule, passRule } from '../utils/vaildate.js'
import { setToken } from '../utils/setToken.js'
import { login } from '../api/api.js'
export default {
    data() {
        return {
            form: {
                username: '',
                password: ''
            },
            rules: {
                username: [{ validator: nameRule, trigger: 'blur' }],
                password: [{ validator: passRule, trigger: 'blur' }]
            }
        }

    },
    methods: {
        login(form) {
            this.$refs[form].validate((valid) => {
                if (valid) {
                    console.log(this.form);
                    // this.service.post('/login', this.form)
                    // .then(res => {
                    //     if(res.data.status === 200) {
                    //         setToken('username', res.data.username)
                    //         setToken('token', res.data.token)
                    //         this.$message({message: res.data.message, type: 'success'})
                    //         this.$router.push('home')
                    //     }
                    //     console.log(res)
                    // })

                    login(this.form).then(res => {
                        if (res.data.statusCode === 200) {
                            setToken('username', res.data.data.username)
                            setToken('token', res.data.data.userToken)
                            this.$message({ message: res.data.statusMessage, type: 'success' })
                            this.$router.push('home')
                        }
                        console.log(res)
                    })
                    // login(this.form).then(res => {
                    //     if (res.data.data.statusCode === 200) {
                    //         setToken('username', res.data.data.username)
                    //         setToken('token', res.data.data.userToken)
                    //         this.$message({ message: res.data.statusMessage, type: 'success' })
                    //         this.$router.push('home')
                    //     }
                    //     console.log(res)
                    // })
                } else {
                    console.error(this.form)
                }
            });
        }
    }
};
</script>

<style lang="scss">
.login-body {
  width: 100%;
  height: 100%;
  position: absolute;
  background-size: cover;
  background-image: url(../assets/11.jpg);

  .el-card {
    background: #65768557;
  }

  .box-card {
    width: 450px;
    margin: 200px auto;
    color: #fff;

    .el-button .el-form-item__label {
      color: #fff;
    }

    .clearfix {
      font-size: 34px;
    }

    .el-button {
      width: 100%;
    }
  }
}
</style>

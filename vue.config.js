const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave:false,
  devServer:{
    open:true,
    host:'localhost',
    proxy: {
      '/api': {
        // target: 'http://1.116.64.64:5004/api2/',
        target: 'http://localhost:8090/sshTest/user/',
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
})

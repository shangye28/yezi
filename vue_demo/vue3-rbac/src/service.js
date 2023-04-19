import axios from "axios";
import { getToken } from './utils/setToken.js'
import {  ElMessage } from "element-plus";

const service = axios.create({
    baseURL: '/api', //baseURL会自动加在请求地址上
    timeout: 3000
})

//添加请求拦截器
service.interceptors.request.use((config) => {
    //获取并设置token
    config.headers['token'] = getToken('token')
    return config
}, (error) => {
    return Promise.reject(error)
})

//添加响应拦截器
service.interceptors.response.use((response) => {
    let {statusCode, statusMessage} = response.data
    if(statusCode != 200) {
        ElMessage({message: statusMessage || 'error', type: 'warning'})
    }
    return response
}, (error) => {
    return Promise.reject(error)
})

export default service
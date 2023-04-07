import service from "../service.js";

//登录接口
export function login(data) {
    return service({
        method: 'post',
        url: '/login',
        data
    })
}

//学生列表接口
export function userAll(params) {
    return service({
        method: 'get',
        url: '/userAll',    
        params
    })
}

//学生列表删除接口
export function studentDel(id) {
    return service({
        method: 'delete',
        url: '/students/${id}'
    })
}
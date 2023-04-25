import service from "../service.js";

//登录接口
export function login(data) {
    return service({
        method: 'post',
        url: '/login',
        data
    })
}

//用户列表接口
export function userAll() {
    return service({
        method: 'get',
        url: '/user/view',    
    })
}

//用户查询接口
export function findByUsername(params) {
    return service({
        method: 'get',
        url: '/user/findByUsername',
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



//角色列表接口
export function roleAll() {
    return service({
        method: 'get',
        url: '/role/view'    
    })
}
//部门列表接口
export function deptAll() {
    return service({
        method: 'get',
        url: '/dept/view'    
    })
}
//菜单列表接口
export function menuAll() {
    return service({
        method: 'get',
        url: '/menu/view'    
    })
}
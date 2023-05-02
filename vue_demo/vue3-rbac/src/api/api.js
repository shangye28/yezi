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
export function findByName(params) {
    return service({
        method: 'get',
        url: '/user/findByName',
        params    
    })
}

//用户列表删除接口
export function deleteUser(params) {
    return service({
        method: 'delete',
        url: '/user/delete',
        params
    })
}

//用户列表新增接口
export function userAdd(data) {
    return service({
        method: 'post',
        url: '/user/save',
        data
    })
}




//角色列表接口
export function roleAll() {
    return service({
        method: 'get',
        url: '/role/view'    
    })
}

//角色查询接口
export function findByRoleName(params) {
    return service({
        method: 'get',
        url: '/role/findByRoleName',
        params    
    })
}

//角色列表删除接口
export function roleDel(name) {
    return service({
        method: 'delete',
        url: '/role/delete',
        name
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
//用户名匹配
export function nameRule(rule, value, callback) {
    let reg = /(^[a-zA-Z0-9]{4,10}$)/;
            if(value === "") {
                callback(new Error('请输入用户名'));
            } else if (!reg.test(value)) {
                callback(new Error('请输入4-10位用户名'));
            } else {
                callback();
            }
}
//密码匹配
export function passRule(rule, value, callback) {
    let pass = /(^[a-zA-Z0-9]{6,12}$)/;
    if(value === "") {
        callback(new Error('请输入密码'));
    } else if (!pass.test(value)) {
        callback(new Error('请输入6-12位密码'));
    } else {
        callback();
    }
}
//邮箱格式
export function emailRule(rule, value, callback) {
    let reg = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            if(value === "") {
                callback(new Error('请输入邮箱'));
            } else if (!reg.test(value)) {
                callback(new Error('邮箱格式不正确'));
            } else {
                callback();
            }
}
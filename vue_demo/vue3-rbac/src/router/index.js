import Vue from 'vue'
import Router from 'vue-router'
//import Home from '../components/Home.vue'

Vue.use(Router)

export default new Router({
    routes:[
        {
            path: '/',
            redirect: '/login',
            hidden: true,
            //component: Home
            //component: () => import('@/components/Login')
            //component: resolve => require(['@/components/Home'], resolve)
        },
        {
            path: '/login',
            name: 'Login',
            hidden: true,
            component: () => import('@/components/Login')
        },
        {
            path: '*',
            name: 'NotFound',
            hidden: true,
            component: () => import('@/components/NotFound')
        },
        {
            path: '/home',
            name: 'Dashboard',
            iconClass: 'fa fa-bar-chart',
            redirect: '/home/analysisi',
            component: () => import('@/components/Home'),
            children: [
                {
                    path: '/home/analysisi',
                    name: '分析页',
                    component: () => import('@/components/dashboard/Analysis')
                },
                {
                    path: '/home/workbench',
                    name: '工作台',
                    component: () => import('@/components/dashboard/Workbench')
                }
            ]
        },
        {
            path: '/home',
            name: '系统管理',
            iconClass: 'fa fa-assistive-listening-systems',
            component: () => import('@/components/Home'),
            children: [
                {
                    path: '/home/user',
                    name: '账号管理',
                    component: () => import('@/components/sys/UserList')
                },
                {
                    path: '/home/role',
                    name: '角色管理',
                    component: () => import('@/components/sys/RoleList')
                },
                {
                    path: '/home/menu',
                    name: '菜单管理',
                    component: () => import('@/components/sys/MenuList')
                },
                {
                    path: '/home/dept',
                    name: '部门管理',
                    component: () => import('@/components/sys/DeptList')
                },
            ]
        },
    ],
    mode: 'history'
})

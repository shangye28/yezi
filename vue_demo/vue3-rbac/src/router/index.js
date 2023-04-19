import { createRouter, createWebHistory } from 'vue-router'
const routes = [
    {
        name: 'Login',
        path: '/login',
        component: () => import('@/components/Login.vue'),
    },
    {
        path: '/:pathMatch(.*)',
        name: 'NotFound',
        hidden: true,
        component: () => import('@/components/NotFound.vue')
    },
    {
        path: '/home',
        name: 'Dashboard',
        redirect: '/home/analysisi',
        component: () => import('@/components/Home.vue'),
        children: [
            {
                path: '/home/analysisi',
                name: '分析页',
                component: () => import('@/components/dashboard/Analysis.vue')
            },
            {
                path: '/home/workbench',
                name: '工作台',
                component: () => import('@/components/dashboard/Workbench.vue')
            }
        ]
    },
    {
        path: '/home',
        name: '系统管理',
        iconClass: 'fa fa-assistive-listening-systems',
        component: () => import('@/components/Home.vue'),
        children: [
            {
                path: '/home/user',
                name: '账号管理',
                component: () => import('@/components/sys/UserList.vue')
            },
            {
                path: '/home/role',
                name: '角色管理',
                component: () => import('@/components/sys/RoleList.vue')
            },
            {
                path: '/home/menu',
                name: '菜单管理',
                component: () => import('@/components/sys/MenuList.vue')
            },
            {
                path: '/home/dept',
                name: '部门管理',
                component: () => import('@/components/sys/DeptList.vue')
            },
        ]
    },
];

//这里不是通过new来创建，通过createRouter 方法创建，使用的模式不是通过mode来定义
const router = createRouter({
    routes,
    history: createWebHistory(),
})

export default router
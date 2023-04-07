<template>
    <div>
        <el-card>
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item v-for="(item, index) in this.$route.matched" :key="index"><a href="/">{{ item.name }}</a></el-breadcrumb-item>
            </el-breadcrumb>
        </el-card>
    </div>
</template>
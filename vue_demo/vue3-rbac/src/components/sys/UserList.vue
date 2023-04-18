<template>
    <div class="userList">
        <!-- 查询数据、重置 -->
        <el-form :inline="true" :model="formInline" class="demo-form-inline" size="small">
            <el-form-item label="姓名">
                <el-input v-model="formInline.name" placeholder="请输入"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="find()">查询</el-button>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="reset()">重置</el-button>
            </el-form-item>
        </el-form>
        <!-- 表单数据 -->
        <!-- <el-table :data="tableData.slice((currentPage-1) * pageSize, currentPage * pageSize)" style="width: 100%"> -->
        <el-table :data="compData" style="width: 100%">
            <el-table-column prop="userId" label="userId" align="center">
            </el-table-column>
            <el-table-column prop="username" label="姓名" align="center">
            </el-table-column>
            <el-table-column prop="nickname" label="昵称" align="center">
            </el-table-column>
            <el-table-column prop="email" label="邮箱" align="center">
            </el-table-column>
            <el-table-column prop="createTime" label="创建时间" align="center">
            </el-table-column>
            <el-table-column prop="sex_text" label="性别" align="center">
            </el-table-column>
            <el-table-column prop="status_text" label="状态" align="center">
            </el-table-column>
            <el-table-column prop="phone" label="电话" align="center">
            </el-table-column>
            <el-table-column label="操作" align="center">
                <template v-slot:scope>
                    <el-button type="danger" size="mini" icon="el-icon-delete" @click="del(scope.row)"></el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage"
            :page-sizes="[5, 10, 20, 30, 50]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper"
            :total="total">
        </el-pagination>
    </div>
</template>

<script>
import { userAll, studentDel } from '@/api/api.js'
export default {
    data() {
        return {
            tableData: [],
            currentPage: 1, //当前页数
            pageSize: 10,   //每页显示条数
            total: 0,   //总条数
            formInline: {
                name: ''
            }
        }
    },
    created() {
        this.getData()
    },
    computed: {
        compData() {
            return this.tableData.slice((this.currentPage - 1) * this.pageSize, this.currentPage * this.pageSize)
        }
    },
    methods: {
        find() {
            console.log(this.formInline);
            this.getData(this.formInline)
        },
        reset() {
            console.log(this.formInline);
            this.formInline = {}
            this.getData(this.formInline)
        },
        handleSizeChange(val) {
            this.pageSize = val
            this.currentPage = 1
        },
        handleCurrentChange(val) {
            this.currentPage = val
        },
        getData(parmas) {
            userAll(parmas)
                .then(res => {
                    console.log(res)
                    if (res.data.statusCode === 200) {
                        this.tableData = res.data.data
                        // this.total = res.data.total     //总数据个数
                        //性别、状态的转换
                        this.tableData.forEach(item => {
                            item.sex === '0'
                                ? item.sex_text = '男' 
                                : item.sex === '1'
                                    ? item.sex_text = '女'
                                    : item.sex_text = '未知'
                            item.state === '0'
                                ? (item.status_text = '停用')
                                : (item.status_text = '正常')
                        });
                    }
                });
        },
        del(row) {
            console.log(row)
            studentDel(row.id).then(res => {
                console.log(res)
                if (res.data.status === 200) {
                    this.$message({ message: '删除成功', type: 'success' })
                    this.getData()
                }
            })
        }
    },
};
</script>

<style lang="scss">
.userList {

    .demo-form-inline,
    .el-form-item {
        text-align: left;
    }

    .el-pangination {
        text-align: left;
        margin-top: 20px;
    }
}</style>
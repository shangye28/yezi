<template>
  <div class="grid-content bg-purple">
    <el-tree
      :data="compData"
      show-checkbox
      node-key="deptId"
      :default-expanded-keys="[2, 3]"
      :default-checked-keys="[5]"
    >
    </el-tree>
  </div>
</template>
<script>
import { deptAll } from "@/api/api.js";
export default {
  data() {
    return {
      tableData: [],
      currentPage: 1, //当前页数
      pageSize: 10, //每页显示条数
      total: 0, //总条数
      data: [
        {
          id: 1,
          label: "一级 2",
          children: [
            {
              id: 3,
              label: "二级 2-1",
              children: [
                {
                  id: 4,
                  label: "三级 3-1-1",
                },
                {
                  id: 5,
                  label: "三级 3-1-2",
                  disabled: true,
                },
              ],
            },
            {
              id: 2,
              label: "二级 2-2",
              disabled: true,
              children: [
                {
                  id: 6,
                  label: "三级 3-2-1",
                },
                {
                  id: 7,
                  label: "三级 3-2-2",
                  disabled: true,
                },
              ],
            },
          ],
        },
      ],
      defaultProps: {
        children: "depts",
        label: "deptName",
      },
    };
  },
  created() {
    this.getData();
  },
  computed: {
    compData() {
    //   return this.tableData.slice(
    //     (this.currentPage - 1) * this.pageSize,
    //     this.currentPage * this.pageSize
    //   );
    return this.tableData
    },
  },
  methods: {
    getData() {
      deptAll().then((res) => {
        console.log(res);
        if (res.data.statusCode === 200) {
          this.tableData = res.data.data.list;
          this.total = res.data.data.total;
          console.log(this.tableData);
          console.log(this.data);
        }
      });
    },
  },
};
</script>

<template>
    <div>
        部门列表
    </div>
</template>

<script>
import { deptAll } from "@/api/api.js";

export default {
  data() {
    return {};
  },
  created() {
    this.getData();
  },
  methods: {
    getData() {
      deptAll().then((res) => {
        console.log(res);
      });
    },
  },
};
</script>
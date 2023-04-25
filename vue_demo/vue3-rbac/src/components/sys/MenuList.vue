<template>
    <div>
        菜单列表
    </div>
</template>

<script>
import { menuAll } from "@/api/api.js";

export default {
  data() {
    return {};
  },
  created() {
    this.getData();
  },
  methods: {
    getData() {
      menuAll().then((res) => {
        console.log(res);
      });
    },
  },
};
</script>
<template>
  <el-container>
  <left_card></left_card>

  <el-main>
  <h2> 法问社区公约 </h2>
  </el-main>

  <right_card></right_card>
  </el-container>
</template>

<script>
import left_card from "./left_card";
import right_card from "./right_card";

    export default {
        name: "constitution",
      components:{
          left_card,
        right_card
      }
    }
</script>

<style scoped>

</style>

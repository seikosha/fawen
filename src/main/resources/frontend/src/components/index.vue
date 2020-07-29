<template>
  <el-container>
    <left_card></left_card>
    <buttons></buttons>
    <right_card></right_card>

  </el-container>
</template>

<script>
  import App from '../App'
  import historic_selection from "./historic_selection";
  import star_user from "./star_user";
  import left_card from "./left_card";
  import right_card from "./right_card";
  import buttons from "./buttons";
  import header1 from "./header1";


    export default {
        name: "index",

        components:{
          App,
          historic_selection,
          star_user,
          left_card,
          right_card,
          buttons,
          header1
        },
    }
</script>

<style scoped>
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

</style>

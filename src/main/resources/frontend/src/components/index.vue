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
  .el-header,
  .el-footer {
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
    text-align: center;
  }

  .el-main {
    color: #333;
    text-align: center;
    /*line-height: 160px;*/
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

  #app {
    font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB",
    "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  }

  .el-container {
    margin: auto;
    width: 1140px;
  }

  #title {
    font-weight: 500;
    font-size: larger;
    text-align: center;
    padding-left: 0;
    margin-left: 0;
  }

  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

  #title_link{
    text-decoration: none;
  }
</style>

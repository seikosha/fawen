<template>
  <el-container>
    <left_card></left_card>

    <el-main id="main">
      <el-row>
        <router-link to="/ask"><el-button id="buttonl" type="primary" plain>我有问题</el-button></router-link>
        <router-link to="/answer"><el-button id="buttonr" type="success" plain>我能解答</el-button></router-link>
      </el-row>
    </el-main>

    <right_card></right_card>

  </el-container>
</template>

<script>
  import App from '../App'
  import historic_selection from "./historic_selection";
  import star_user from "./star_user";
  import left_card from "./left_card";
  import right_card from "./right_card";

    export default {
        name: "index",
        components:{
          App,
          historic_selection,
          star_user,
          left_card,
          right_card
        }
    }
</script>

<style scoped>
  #buttonl,
  #buttonr{
    width:240px;
    height:240px;
    margin:auto;ß
    position:relative;
    top:20px;
  }

  #buttonl{
    right:20px;
  }

  #buttonr{
    left:20px;
  }


</style>

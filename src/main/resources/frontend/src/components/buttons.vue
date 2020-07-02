<template>
  <el-main id="main">
    <el-row>
      <router-link to="/ask"><el-button id="buttonl" type="primary" plain>我有问题</el-button></router-link>
      <router-link to="/answer"><el-button id="buttonr" type="success" plain>我能解答</el-button></router-link>
    </el-row>
  </el-main>
</template>

<script>
    export default {
        name: "buttons"
    }
</script>

<style scoped>
  #buttonl,
  #buttonr{
    width:240px;
    height:240px;
    margin:auto;
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

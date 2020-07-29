<template>
  <el-aside id="leftside" width="200px">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>在法问，请发问！</span>
      </div>
      <div class="text item">
        <router-link to="/historic_selection" tag="span" class="left_card">历史精选贴</router-link><br><br>
        <router-link to="/star_user" tag="span" class="left_card">明星回答者</router-link><br><br>
        <router-link to="/posts" tag="span" class="left_card">网站公告</router-link><br><br>
        <router-link to="/about" tag="span" class="left_card">关于法问</router-link>
      </div>
    </el-card>
  </el-aside>
</template>

<script>


    export default {
        name: "left_card"
    }
</script>

<style scoped>
  .left_card:hover{
    cursor: pointer;
  }

  #leftside
  {
    position:relative;
    top:20px;
    left:33px;
  }

  @media screen and (max-width: 479px) {
     #leftside{
       visibility: hidden;
     }
  }
</style>

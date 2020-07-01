<template>
  <el-container>
    <el-aside id="leftside" width="200px">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>在法问，请发问！</span>
        </div>
        <div class="text item">
          <router-link to="/historic_selection" tag="span" class="left_card">历史精选贴</router-link><br><br>
          <span>明星回答者</span><br><br>
          <span>论坛公约</span><br><br>
          <span>网站公告</span>
        </div>
      </el-card>
    </el-aside>

    <el-main id="main">
      <el-row>
        <router-link to="/ask"><el-button id="buttonl" type="primary" plain>我有问题</el-button></router-link>
        <router-link to="/answer"><el-button id="buttonr" type="success" plain>我能解答</el-button></router-link>
      </el-row>
    </el-main>

    <el-aside id="rightside" width="200px">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>按地区浏览历史回答</span>

        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{'列表内容 ' + o }}
        </div>
      </el-card>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>按类型浏览历史回答</span>

        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{'列表内容 ' + o }}
        </div>
      </el-card>
    </el-aside>
  </el-container>
</template>

<script>
  import App from '../App'
  import historic_selection from "./historic_selection";

    export default {
        name: "index",
        components:{
          App,
          historic_selection
        }
    }
</script>

<style scoped>
  #leftside
  {
    position:relative;
    top:20px;
    left:33px;
  }

  #rightside{
    position:relative;
    top:20px;
    right:16px;
  }


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

  .left_card:hover{
    cursor: pointer;
  }
</style>

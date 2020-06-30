<template>
  <div id="app">
    <el-container>
      <el-row id="header">
        <el-header>
          <el-col :span="5" id="title">
            <span>法问</span>
          </el-col>
          <el-col :span="14">
            <el-menu
              :default-active="activeIndex"
              class="el-menu-demo"
              mode="horizontal"
              @select="handleSelect"
              text-color="#000000"
              gutter="20"
            >
              <el-menu-item index="1">我的提问</el-menu-item>
              <el-menu-item index="2">我的回答</el-menu-item>
              <el-menu-item index="3">个人页面</el-menu-item>
              <el-menu-item index="4">站内私信</el-menu-item>
              <el-menu-item index="5">注册</el-menu-item>
              <el-menu-item index="6">登录</el-menu-item>
            </el-menu>
          </el-col>
          <el-col :span="5">
            <el-row gutter="2px">
              <el-col :span="20">
                <el-input placeholder="请输入内容" v-model="input3" class="input-with-select"></el-input>
              </el-col>
              <el-col :span="4">
                <el-button icon="el-icon-search" type="info" plain></el-button>
              </el-col>
            </el-row>
          </el-col>
        </el-header>
      </el-row>

      <el-container>
        <el-aside id="leftside" width="200px">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>法问</span>

            </div>
            <div v-for="o in 4" :key="o" class="text item">
              {{'列表内容 ' + o }}
            </div>
          </el-card>
        </el-aside>

        <el-main id="main">
          <el-row>
            <el-button id="buttonl" type="primary" plain>我有问题</el-button>
            <el-button id="buttonr" type="success" plain>我能解答</el-button>
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

      <el-footer>2020 Powered by ZZ</el-footer>
    </el-container>
  </div>

</template>

<script>
  import HelloWorld from "./components/HelloWorld.vue";

  export default {
    name: "app",
    components: {
      HelloWorld
    },

  };

</script>

<style>
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

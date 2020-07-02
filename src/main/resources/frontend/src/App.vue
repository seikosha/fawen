<template>
  <div id="app">
    <el-container>
      <el-row id="header">
        <el-header>
          <el-col :span="5" id="title">
            <router-link to="/" tag="a" id="title_link">法问</router-link>
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
              <el-menu-item index="1"><router-link to="/my_questions" tag="span">我的提问</router-link></el-menu-item>
              <el-menu-item index="2"><router-link to="/my_answers" tag="span">我的回答</router-link></el-menu-item>
              <el-menu-item index="3"><router-link to="/personal" tag="span">个人页面</router-link></el-menu-item>
              <el-menu-item index="4"><router-link to="/mails" tag="span">站内私信</router-link></el-menu-item>
              <el-menu-item index="5"><router-link to="/register" tag="span">注册</router-link></el-menu-item>
              <el-menu-item index="6"><router-link to="/login" tag="span">登录</router-link></el-menu-item>
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

      <router-view></router-view>

      <el-footer></el-footer>

    </el-container>

  </div>

</template>

<script>
import index from "./components/index";
import ask from "./components/ask";
import answer from "./components/answer";
import my_questions from "./components/my_questions";
import my_answers from "./components/my_answers";
import personal from "./components/personal";
import register from "./components/register";
import login from "./components/login";
import historic_selection from "./components/historic_selection";
import star_user from "./components/star_user";

  export default {
    name: "app",
    components: {
      index,
      ask,
      answer,
      my_questions,
      my_answers,
      personal,
      register,
      login,
      historic_selection,
      star_user
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

#title_link{
  text-decoration: none;
}


</style>

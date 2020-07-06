<template>
  <div id="app">
    <el-container>
      <header1 v-show="true"></header1>
      <header2 v-show="false"></header2>

      <router-view></router-view>

      <el-footer>
        <div id="welcome">
          <div>{{message.username}}</div>
          <div>{{message.location}}</div>
        </div>
      </el-footer>

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
import constitution from "./components/constitution";
import header1 from "./components/header1";
import header2 from "./components/header2";

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
      star_user,
      constitution,
      header1,
      header2
    },
    el:'#welcome',

    data(){
      return{
        message:{
          username:null,
          location:null
        }
      }
    },
    mounted() {
      const axios = require('axios');
      axios.get('/queryUserList').then(response=>(this.message=response.data[0]));
  }}
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

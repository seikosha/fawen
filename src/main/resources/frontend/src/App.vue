<template>
  <div id="app">
    <el-container>
      <header1 v-show="header1_token" ></header1>
      <header2 v-show="header2_token" ></header2>

      <router-view></router-view>

      <el-footer>
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
import store from './store';
import content from "./components/content";
import test from "./components/test";
import specific_content from "./components/specific_content";
import personal_specific from "./components/personal_specific";
import send_mail from "./components/send_mail";
import mail_success from "./components/mail_success";
import mail_specific from "./components/mail_specific";
import search_result from "./components/search_result";
import hot from "./components/hot";
import about from "./components/about";
import more_locations from "./components/more_locations";
import specific_location from "./components/specific_location";

  export default {
    store,
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
      header2,
      content,
      test,
      specific_content,
      personal_specific,
      send_mail,
      mail_success,
      mail_specific,
      search_result,
      hot,
      about,
      more_locations,
      specific_location
    },



    data(){
      return{

        message:{
          username:null
        },
        login_query:''+store.state.Authorization+'',
        header1_token: true,
        header2_token: false
      }
    },



    created() {
      console.log('验证信息：'+this.$store.state.Authorization);
      if(this.$store.state.Authorization == null) {
        console.log('验证为null');
      }else if (this.$store.state.Authorization === ''){
        console.log('验证为空字符串')
      }else{
        this.header1_token = false;
        this.header2_token = true;

      }
    },

  }
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

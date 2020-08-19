<template>
  <div id="app">
    <el-container>
      <header1 id="header1" v-show="header1_token" ></header1>
      <header2 id="header2" v-show="header2_token" ></header2>
      <header3 id="header3" v-show="header1_token"></header3>
      <header4 id="header4" v-show="header2_token"></header4>
      <router-view style="text-align: center"></router-view>
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
import header1 from "./components/header1";
import header2 from "./components/header2";
import store from './store';
import content from "./components/content";
import specific_content from "./components/specific_content";
import personal_specific from "./components/personal_specific";
import send_mail from "./components/send_mail";
import mail_success from "./components/mail_success";
import mail_specific from "./components/mail_specific";
import search_result from "./components/search_result";
import about from "./components/about";
import more_locations from "./components/more_locations";
import specific_location from "./components/specific_location";
import specific_category from "./components/specific_category";
import header3 from "./components/header3";
import header4 from "./components/header4";
import my_profile from "./components/my_profile";
import update_profile from "./components/update_profile";

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
      header1,
      header2,
      content,
      specific_content,
      personal_specific,
      send_mail,
      mail_success,
      mail_specific,
      search_result,
      about,
      more_locations,
      specific_location,
      specific_category,
      header3,
      header4,
      my_profile,
      update_profile
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
    line-height:20px;
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

  @media screen and (min-width: 769px) {
    #header3{
      visibility:hidden;
    }
    #header4{
     display:none;
    }
  }

  @media screen and (max-width: 768px) {
    #header1,#header2{
      visibility:hidden;

    }
    #header3{
      visibility: visible;
    }
  }


</style>

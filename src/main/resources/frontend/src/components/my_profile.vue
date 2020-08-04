<template>
<el-container>
  <el-aside width="200px" id="leftside">


    <el-card class="box-card" style="margin-top: 30px">
      <div slot="header" class="clearfix">
        <span>个人资料</span>
      </div>
      <div class="text-item">
        <router-link to="/send_mail" tag="span">发送私信</router-link>
        <br><br>
        <router-link to="/my_profile" tag="span">个人资料</router-link>
        <br><br>
        <router-link to="/personal_specific" tag="span">查看数据</router-link>

      </div>
    </el-card>
  </el-aside>
  <el-main>
    <h2>这里是用户{{username}}的个人资料页</h2>
    <br>
    <p>邮箱地址: {{email}}</p>
    <br>
    <p>目前生活在：{{location}}</p>
    <br>
    <p>目前状态为：{{status}}</p>
    <br>
    <p>个人描述是：{{description}}</p>
  </el-main>
</el-container>
</template>

<script>
    export default {
        name: "my_profile",
        data(){
          return{
              username:'',
              email:'',
              location:'',
              status:'',
              description:''
          }
        },
        beforeCreate() {
          const axios = require('axios');
          axios.get('/queryUserByUsername',{
            params:{
              username:this.$store.state.CurrentUser
            }}).then(response=>{
            console.log(response.data)
            this.username=response.data.username;
            this.email=response.data.email;
            this.location=response.data.location;
            this.status=response.data.status;
            this.description=response.data.description;
          })
        }
    }
</script>

<style scoped>
  #leftside
  {
    position:relative;
    top:30px;
    left:33px;
  }

  .text-item:hover{
    cursor: pointer;
  }
</style>

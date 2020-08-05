<template>
    <el-container style="text-align: center">
      <el-main id="main">
      <el-row style="margin-top: 30px">
      已成功向用户 {{username}} 发送私信
      </el-row>
      <el-row style="margin-top: 30px">
      <el-button @click="getback">返回首页</el-button>
      </el-row>
      </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "mail_success",
        data(){
          return {
            username:this.$store.state.CurrentUser
          }
        },
        methods:{
          getback(){
            this.$router.push('/');
          }
        }
    }
</script>

<style scoped>
  @media screen and (max-width: 768px) {
    #main{
      position:relative;
      left:80px;
      bottom:40px;
    }
  }
</style>

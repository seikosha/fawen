<template>
<el-container>
  <el-col span="5"></el-col>
  <el-col span="14" style="margin-top: 20px">
    <span>用户名：</span>
    <el-input v-model="input" placeholder="请输入您的用户名" show-word-limit="true" style="margin-bottom: 15px"></el-input>
    <span>密码：</span>
    <el-input placeholder="请输入您的密码" v-model="input" show-password style="margin-bottom: 15px"></el-input>
    <el-button type="info" plain>提交</el-button>
  </el-col>
  <el-col span="5"></el-col>
</el-container>
</template>

<script>
    export default {
        name: "login",
        data(){
          return{
            input: ''
          }
        }
    }
</script>

<style scoped>

</style>

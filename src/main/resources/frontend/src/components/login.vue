<template>
<el-container>
  <el-col span="5" :xs="10" id="leftside"></el-col>
  <el-col span="14" :xs="10"  style="margin-top:20px">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="用户名" prop="username">
        <el-input type="username" v-model="ruleForm.username" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-col>
  <el-col span="5" :xs="4"></el-col>
</el-container>
</template>

<script>

    export default {
        name: "login",
        data(){
          let userToken;
          return{
            userToken,
            ruleForm: {
              username: '',
              password: '',
            },
            rules: {
              username: [
                { required: true, message: '请输入用户名', trigger: 'blur' },
                { min: 4, max: 12, message: '长度在 4-12 个字符', trigger: 'blur' }
              ],
              password: [
                { required: true, message: '请输入密码', trigger: 'blur' },
                { min: 4, max: 12, message: '长度在 6-12 个字符', trigger: 'blur' }
              ],
          }
        }
    },
      methods: {
        refresh:function(){
          this.$router.go(0)
        },
        submitForm(formName) {
          const axios = require('axios');
          let myDate = new Date();
          this.$refs[formName].validate((valid) => {
            if (valid) {
              axios.get('/loginQuery',{
                params:{
                  username:this.ruleForm.username,
                  password:this.ruleForm.password
                }}).then(response=>{
                console.log(response.data[0].username)
                this.userToken = response.data[0].username;
                this.$store.commit('changeLogin',{Authorization: this.userToken});
                if(response.data[0].username === this.ruleForm.username){
                  axios.get('/updateLoginTime',{
                    params:{
                      last_login_time:myDate.getFullYear()+'-'+(myDate.getMonth()+1)+'-'+myDate.getDate()+' '+myDate.getHours()+':'+myDate.getMinutes()+':'+myDate.getSeconds(),
                      username:response.data[0].username
                    }}).then(response=>{
                    this.$router.push('/');
                    this.refresh();
                  })
                }}).catch(err => {
                console.log('服务器连接失败');
                console.log(err);
              })} else {
              console.log('用户信息错误!!');
              return false;
            }
          });
        },
        resetForm(formName) {
          this.$refs[formName].resetFields();
        }
      }
    }

</script>

<style scoped>
</style>

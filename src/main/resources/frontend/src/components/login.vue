<template>
<el-container>
  <el-col span="5"></el-col>
  <el-col span="14" style="margin-top: 20px">
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
  <el-col span="5"></el-col>
</el-container>
</template>

<script>
    import {mapMutations} from "vuex";

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
        submitForm(formName) {
          const axios = require('axios');
          this.$refs[formName].validate((valid) => {
            if (valid) {
              axios.get('/loginQuery?username='+this.ruleForm.username+'&password='+this.ruleForm.password+'')
              .then(response=>{
                if(response.data[0].username === this.ruleForm.username){
                  this.userToken = response.data[0].username;
                  console.log('userToken:'+this.userToken);
                  this.$store.commit('changeLogin',{Authorization: this.userToken});
                  this.$router.push('/');
                }
              }).catch(err => {
                console.log('服务器连接失败');
                console.log(err);
              })
            } else {
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

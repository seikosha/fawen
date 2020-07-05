<template>
<el-container>
  <el-col span="5"></el-col>

  <el-col span="14" style="margin-top: 20px">

    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="用户名：" prop="username">
        <el-input v-model="ruleForm.username"></el-input>
      </el-form-item>
      <el-form-item label="密码：" prop="password">
        <el-input v-model="ruleForm.password" type="password"></el-input>
      </el-form-item>
      <el-form-item label="邮箱地址：" prop="email">
        <el-input v-model="ruleForm.email"></el-input>
      </el-form-item>
      <el-form-item label="所在地区" prop="location">
        <el-select v-model="ruleForm.location" placeholder="请选择所在地区">
          <el-option label="北京" value="北京"></el-option>
          <el-option label="天津" value="天津"></el-option>
          <el-option label="河北" value="河北"></el-option>
          <el-option label="山西" value="山西"></el-option>
          <el-option label="内蒙古" value="内蒙古"></el-option>
          <el-option label="辽宁" value="辽宁"></el-option>
          <el-option label="吉林" value="吉林"></el-option>
          <el-option label="黑龙江" value="黑龙江"></el-option>
          <el-option label="上海" value="上海"></el-option>
          <el-option label="江苏" value="江苏"></el-option>
          <el-option label="浙江" value="浙江"></el-option>
          <el-option label="安徽" value="安徽"></el-option>
          <el-option label="福建" value="福建"></el-option>
          <el-option label="江西" value="江西"></el-option>
          <el-option label="山东" value="山东"></el-option>
          <el-option label="河南" value="河南"></el-option>
          <el-option label="湖北" value="湖北"></el-option>
          <el-option label="湖南" value="湖南"></el-option>
          <el-option label="广东" value="广东"></el-option>
          <el-option label="广西" value="广西"></el-option>
          <el-option label="海南" value="海南"></el-option>
          <el-option label="重庆" value="重庆"></el-option>
          <el-option label="四川" value="四川"></el-option>
          <el-option label="贵州" value="贵州"></el-option>
          <el-option label="云南" value="云南"></el-option>
          <el-option label="西藏" value="西藏"></el-option>
          <el-option label="陕西" value="陕西"></el-option>
          <el-option label="甘肃" value="甘肃"></el-option>
          <el-option label="青海" value="青海"></el-option>
          <el-option label="宁夏" value="宁夏"></el-option>
          <el-option label="新疆" value="新疆"></el-option>
          <el-option label="台湾" value="台湾"></el-option>
          <el-option label="香港" value="香港"></el-option>
          <el-option label="澳门" value="澳门"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="当前状态" prop="status">
        <el-select v-model="ruleForm.status" placeholder="请选择当前状态">
          <el-option label="律师" value="律师"></el-option>
          <el-option label="法律专业学生" value="法律专业学生"></el-option>
          <el-option label="社会法律工作者" value="社会法律工作者"></el-option>
          <el-option label="司法机关从业人员" value="司法机关从业人员"></el-option>
          <el-option label="以上都不是" value="以上都不是"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="个人简介" prop="desciption">
        <el-input type="textarea" v-model="ruleForm.description"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit">立即创建</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>


  </el-col>
  <br>



  <el-col span="5"></el-col>
</el-container>
</template>

<script>
  export default {
    name:"register",
    data() {
      let regExp = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
      let checkEmail = (rule, value, callback) => {
        if(!regExp.test(value)){
          return callback(new Error('邮箱地址不正确'));
        }
      }
      return {
        ruleForm: {
          username: '',
          password: '',
          email: '',
          location: '',
          status: '',
          description: ''
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
          email: [
            { required: true, validator: checkEmail,trigger: 'blur'},
          ],
          location: [
            { required: true, message: '请选择所在区域', trigger: 'change' }
          ],
          status: [
            { required: true, message: '请选择当前状态', trigger: 'change' }
          ],
          description: [
            { required: true, message: '请填写个人简介', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      submit(){
        const axios = require('axios');
        axios.get('/addUser',{
          params:{
            username: this.ruleForm.username,
            password: this.ruleForm.password,
            email:this.ruleForm.email,
            location:this.ruleForm.location,
            status:this.ruleForm.status,
            description:this.ruleForm.description,
          }
        }).then(response=>(console.log('sucess in adding user!')));
      },
      // submitForm(formName) {
      //   const axios = require('axios');
      //   this.$refs[formName].validate((valid) => {
      //     if (valid) {
      //       axios.get('/addUser',{
      //         params:{
      //           username: this.ruleForm.username,
      //           password: this.ruleForm.password,
      //           email:this.ruleForm.email,
      //           location:this.ruleForm.location,
      //           status:this.ruleForm.status,
      //           description:this.ruleForm.textarea,
      //         }
      //       }).then(response=>(console.log('success in adding user!')));
      //     } else {
      //       console.log('注册失败');
      //       return false;
      //     }
      //   });
      // },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style scoped>
  .avatar-uploader{
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    width: 178px;
    height: 178px;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {

    display: block;
  }
</style>

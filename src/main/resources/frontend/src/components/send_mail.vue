<template>
  <el-container>
    <el-col span="4" ></el-col>
    <el-col span="16" style="margin-top: 20px">

      <br><br>
      <p style="text-align: center">给用户 {{username}} 的私信</p>

      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

        <el-form-item label="私信标题" prop="title">
          <el-input v-model="ruleForm.title"></el-input>
        </el-form-item>
        <el-form-item label="私信内容" prop="mail">
          <el-input type="textarea" v-model="ruleForm.mail"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-col>
    <el-col span="4"></el-col>
  </el-container>

</template>

<script>
    export default {
        name: "send_mail",
        data(){
          return{
            sender_id:0,
            receiver_id:0,
            username:'',
            ruleForm: {
              title:'',
              mail:''
            },
            rules: {
              title:[
                { required: true, message:'请输入标题内容',trigger:'blur'},
                { min:4, max:16, message:'长度在4-6个字符之间',trigger:'blur'}
              ],
              mail: [
                { required: true, message: '请输入私信内容', trigger: 'blur' },
                { min: 4, max: 10000, message: '长度在4个字符以上', trigger: 'blur' }
              ]
            }
          }
        },

        methods:{
          resetForm(formName) {
            this.$refs[formName].resetFields();
          },
          submitForm(formName){
            const axios = require('axios');
            let myDate = new Date();
            this.$refs[formName].validate((valid)=>{
              if(valid){
                axios.get('/queryUserByUsername',{
                  params:{
                    username:this.$store.state.Authorization
                  }}).then(response=>{
                    this.sender_id=response.data.id
                    axios.get('/queryUserByUsername',{
                      params:{
                        username:this.$store.state.CurrentUser
                      }}).then(response=>{
                        this.receiver_id=response.data.id
                        axios.get('/addMail',{
                          params:{
                            sender_id:this.sender_id,
                            receiver_id:this.receiver_id,
                            title:this.ruleForm.title,
                            content:this.ruleForm.mail,
                            send_time:myDate.getFullYear()+'-'+(myDate.getMonth()+1)+'-'+myDate.getDate()+' '+myDate.getHours()+':'+myDate.getMinutes()+':'+myDate.getSeconds(),
                          }}).then(response=>{
                            console.log('私信已发出！')
                          this.$router.push('/mail_success')
                        })
                    })
                })
              }
            })
          }
        },

        mounted() {
          this.username=this.$store.state.CurrentUser;
          console.log(this.$store.state.CurrentUser)
        }
    }
</script>

<style scoped>
.demo-ruleForm{
  margin-top:30px;
}
</style>

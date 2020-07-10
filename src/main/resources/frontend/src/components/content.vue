<template>
    <el-container>
<el-aside></el-aside>

<el-main>
  <div>
    <h1>{{content.title}}</h1>
    <span><a href="#">{{this.$store.state.Authorization}}</a></span><span>{{' '+content.create_time}}</span>
    <hr>
    <div class="maintext">{{content.content}}</div>
    <hr>
  </div>



  <hr>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm">
  <el-form-item label="回复内容" prop="reply" id="reply">
    <el-input
      type="textarea"
      placeholder="请输入您的解答"
      v-model="ruleForm.reply"
    >
    </el-input>
    <el-button size="small" type="primary" plain style="float: right; margin-top:2px;" @click="submit('ruleForm')">提交</el-button>
  </el-form-item>
  </el-form>

</el-main>

<el-aside></el-aside>
    </el-container>
</template>

<script>
  import reply from "./reply";

    export default {
        name: "content",
        data() {
          return {
            content:{},
            cid:0,
            ruleForm:{
              reply: ''
            },
            rules:{
              reply: [
                {required: true, message:'请填写至少8个字符以上的回复', trigger:'blur'}
              ]
            },
          }
        },
      methods:{
          submit(formName){
            const axios = require('axios')
            let myDate = new Date();
            this.$refs[formName].validate((valid) => {if(valid){
                axios.get('/addReply',{
                  params:{
                    cid:this.cid,
                    uid:this.uid,
                    content: this.ruleForm.reply,
                    create_time:myDate.getFullYear()+'-'+(myDate.getMonth()+1)+'-'+myDate.getDate()+' '+myDate.getHours()+':'+myDate.getMinutes()+':'+myDate.getSeconds(),
                  },}).then(response=>(
                  console.log('回复发布成功！')
                  ))
              } else{
                console.log('问题发布失败');
                return false;
              }
              })
            },
          },
      beforeCreate() {
        const axios = require('axios')
        //authenticate user
        axios.get('/queryUserByUsername',{
          params:{
            username:this.$store.state.Authorization
          },}).then(response=>(
          this.uid=response.data.id,

        //get the newest post from current user
        axios.get('/queryContentByUid',{
          params:{
            uid:this.uid
          },}).then(response=>{
          this.content=response.data[response.data.length-1]
        })
        ))

        if(this.$store.state.Authorization==null|this.$store.state.Authorization===''||this.$store.state.Authorization===undefined){
          this.$router.push('/login');
        }
      },





      components:{
          reply
      },


    }

</script>

<style scoped>
.maintext{
  margin-top: 20px;
  white-space: pre-wrap;
  word-wrap:break-word;
  text-align: left;
}

#reply{
  margin-top:20px;
}
</style>

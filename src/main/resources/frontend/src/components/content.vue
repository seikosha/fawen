<template>
    <el-container>
<el-aside></el-aside>

<el-main>
  <div>
    <h1>{{content.title}}</h1>
    <span><a href="#">{{this.$store.state.Authorization}}</a></span><span>{{' '+content.create_time}}</span>
    <hr>
    <div class="maintext">{{content.content}}</div>

  </div>

  <el-row v-for="item in items" :key="item.reply_time">
    <hr>
    <el-checkbox v-model="item.checked"></el-checkbox>
    <span>回复人：<a href="#">{{item.replyer_uid}}</a></span><span>{{' '+item.reply_time}}</span>
    <span>获赞数：{{item.reply_star}}</span>
    <div class="maintext">{{item.reply_body}}</div>


    <div style="float: right; margin-top:30px">
      <el-button type="primary" size="small" plain @click="like">赞同</el-button>
      <el-button type="danger" size="small" plain>挑战</el-button>
      <el-button type="warning" plain size="small">最佳</el-button>
      <el-button type="success" plain size="small">已解决问题</el-button>
    </div>

  </el-row>



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
    export default {
        name: "content",
        data() {
          return {
            checked:false,
            items:[{item:{reply_time:'',replyer_uid:0,reply_body:'',reply_star:0}}],
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
          like:function(){
            const axios = require('axios')
            axios.get('/addStar')
          },
          refresh:function(){
            this.$router.go(0)
          },
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
                  console.log('回复发布成功！'),
                  this.refresh()
                  ))
              } else{
                console.log('问题发布失败');
                return false;
              }
              })
            },
          },
      beforeCreate() {
        let _this = this;
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
          this.cid=response.data[response.data.length-1].id

        //get the replies of current post
        axios.get('/queryReplyByCid',{
          params:{
            cid:this.cid
          },}).then(response=>{
          for(let i=0;i<response.data.length;i++){
            _this.items.push({reply_time:response.data[i].create_time,replyer_uid: response.data[i].uid,reply_body: response.data[i].content,reply_star: response.data[i].stars});
          }
          _this.items.shift();
          for (let i = 0; i < response.data.length ; i++) {
            axios.get('/queryUsernameById',{
              params:{
                id:_this.items[i].replyer_uid
              },}).then(response=>{
              _this.items[i].replyer_uid=response.data;
            })
          }
        })
        })
        ))

        if(this.$store.state.Authorization==null|this.$store.state.Authorization===''||this.$store.state.Authorization===undefined){
          this.$router.push('/login');
        }
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

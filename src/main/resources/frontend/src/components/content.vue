<template>
    <el-container>
<el-aside></el-aside>

<el-main>
  <div>
    <h1>{{title}}</h1>
    <span><a href="#">{{poster}}</a></span><span>{{' '+create_time}}</span>
    <hr>
    <div class="maintext">{{body}}</div>
    <hr>
  </div>

  <el-row>
    <span style="float:left">回复人：<a href="#">{{replyer}}</a></span><span>{{' '+reply_time}}</span>
    <div class="maintext">{{reply_body}}</div>
    <div style="float: right; margin-top:30px">
    <el-button type="primary" size="small" plain>赞同</el-button>
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
            temporary_id:0,
            ruleForm:{
              reply: ''
            },
            rules:{
              reply: [
                {required: true, message:'请填写至少8个字符以上的回复', trigger:'blur'}
              ]
            },
            title:'不靠谱的二房东收了我订金，我可以要求退还吗？',
            poster:'seikosha',
            create_time:'2020-6-30 11:30:32',
            replyer: '法问站长',
            reply_time:'2020-7-1 13:52:23',
            body:
               '事情是这样的：\n' +
               '\n' +
               '1.2020年6月30日，我跟一家中介公司交了订金，要租位于xxx地区的房子；\n' +
               '\n' +
               '2.2020年7月1日，我在网上看到，我的那个房子已经交给了一家很不靠谱的公司出租，等于我的房东不是原房东，而是一个专业的二房东，这家二房东在网上的评价很差很差；\n' +
               '\n' +
               '在这种情况下，我担心我租了以后也会发生像网上评价的那些不好的恶评情况，所以我现在想退回我的订金不租了。我想请问一下，是否可以？',
            reply_body:'要区分几种情形，不一定能退'
          }
        },
      methods:{
          submit(formName){
            const axios = require('axios')
            let myDate = new Date();
            this.$refs[formName].validate((valid) => {if(valid){
                axios.get('/addReply',{
                  params:{
                    cid:this.temporary_id,
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
            }
          },
      beforeCreate() {
        const axios = require('axios')
        console.log('加载之前取uid'+this.$store.state.Authorization);
        axios.get('/queryUserByUsername',{
          params:{
            username:this.$store.state.Authorization
          },}).then(response=>(
          this.uid=response.data
        ))
        if(this.$store.state.Authorization==null|this.$store.state.Authorization===''||this.$store.state.Authorization===undefined){
          this.$router.push('/login');
        };
      },
      mounted() {
        const axios = require('axios')
        axios.get('/queryReplyIdByContent',{
          params:{
            content: this.body
          },}).then(response=>(this.temporary_id=response.data,
          console.log('加载之后取cid'+this.temporary_id)))
      }

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

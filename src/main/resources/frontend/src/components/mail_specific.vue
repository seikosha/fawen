<template>
  <el-container>
    <el-aside></el-aside>

    <el-main id="maintext">
      <div>
        <h1>{{mail.title}}</h1>
        <router-link  to="/personal_specific" ><a @click="save_user($event)">{{mail.username}}</a></router-link><span>{{' '+mail.send_time}}</span>
        <hr>
        <div class="maintext">{{mail.content}}</div>

      </div>

      <el-row v-for="(item,index) in items" :key="item.reply_time">
        <hr>
        <span>回复人：<router-link to="/personal_specific"><a @click="save_user($event)">{{item.replyer_id}}</a></router-link></span><span>{{' '+item.reply_time}}</span>
        <div class="maintext">{{item.content}}</div>

      </el-row>
      <hr>

      <el-form :model="ruleForm" :rules="rules" ref="ruleForm">
        <el-form-item label="回复内容" prop="reply" id="reply">
          <el-input
            type="textarea"
            placeholder="请输入您的回复"
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
    name: "mail_specific",
    data() {
      return {
        username:'',
        placeholder_text:'请输入您的回答',
        items:[{item:{reply_time:'',replyer_id:0,content:''}}],
        mail:{},
        mid:0,
        uid:0,
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
      save_user(e){
        this.$store.commit('saveUser',{CurrentUser:e.target.innerText});
      },
      submit(formName){
        const axios = require('axios')
        let myDate = new Date();
        this.$refs[formName].validate((valid) => {if(valid){
          axios.get('/addReplyMail',{
            params:{
              mid:this.mid,
              content: this.ruleForm.reply,
              reply_time:myDate.getFullYear()+'-'+(myDate.getMonth()+1)+'-'+myDate.getDate()+' '+myDate.getHours()+':'+myDate.getMinutes()+':'+myDate.getSeconds(),
              replyer_id:this.uid
            },}).then(response=>(
            console.log('回复发送成功！'),
              this.refresh()
          ))
        } else{
          console.log('回复发布失败');
          return false;
        }
        })
      },
      refresh:function(){
        this.$router.go(0)
      }
    },

    beforeCreate() {
      let _this = this;
      let conTitle = '';
      let conTime = '';
      const axios = require('axios')
      //authenticate user
      axios.get('/queryUserByUsername',{
        params:{
          username:this.$store.state.Authorization
        },}).then(response=>{
        this.uid=response.data.id,
          conTime=this.$store.state.CurrentMail.slice(0,19),
          conTitle=this.$store.state.CurrentMail.replace(conTime,''),


          // get the selected mail
          axios.get('/queryMailByTitleAndTime',{
            params:{
              title:conTitle,
              send_time:conTime
            }}).then(response=>{
            this.mail=response.data[0]
            this.mid=response.data[0].id
            this.sender_id=response.data[0].sender_id
              axios.get('/queryUsernameById',{
                params:{
                  id:this.mail.sender_id
                }}).then(response=>{
                this.mail.username=response.data

                //get the replies of the current mail
                axios.get('/queryReplyMailByMid',{
                  params:{
                    mid:this.mid
                  }}).then(response=>{
                  for (let i = 0; i < response.data.length ; i++) {
                    _this.items.push({reply_time:response.data[i].reply_time,replyer_id:response.data[i].replyer_id,content:response.data[i].content})
                  }
                  _this.items.shift();
                  for (let i = 0; i < response.data.length ; i++) {
                    axios.get('/queryUsernameById',{
                      params:{
                        id:_this.items[i].replyer_id
                      }}).then(response=>{
                        _this.items[i].replyer_id=response.data;

                    })
                  }
                })
                })
              })
      })

      if(this.$store.state.Authorization==null|this.$store.state.Authorization===''||this.$store.state.Authorization===undefined){
        this.$router.push('/login');
      }
    }}

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

  @media screen and (max-width: 768px) {
    #maintext{
      position:relative;
    }
    .el-aside{
      display:none;
    }
  }
</style>


<template>
  <el-container>
    <el-aside></el-aside>

    <el-main>
      <div>
        <h1>{{mail.title}}</h1>
        <router-link  to="/personal_specific" ><a @click="save_user">{{mail.username}}</a></router-link><span>{{' '+mail.send_time}}</span>
        <hr>
        <div class="maintext">{{mail.content}}</div>

      </div>

<!--      <el-row v-for="(item,index) in items" :key="item.reply_time">-->
<!--        <hr>-->
<!--        <span>回复人：<router-link to="/personal_specific"><a @click="save_replyer($event)">{{item.replyer_uid}}</a></router-link></span><span>{{' '+item.reply_time}}</span>-->
<!--        <span>获赞数：{{item.reply_star}}</span>-->
<!--        <div class="maintext">{{item.reply_body}}</div>-->

<!--        <div style="float: right; margin-top:30px">-->
<!--          <span v-show="item.like_success">点赞成功！</span>-->
<!--          <span v-show="item.best_success">此回答为最佳答案！</span>-->
<!--          <span v-show="item.solve_success">成功解决问题！</span>-->
<!--          <el-button type="primary" size="small" plain @click="like(index)" v-bind:disabled="item.liked">赞同</el-button>-->
<!--          <el-button type="danger" size="small" plain @click="challenge(index)">挑战</el-button>-->
<!--          <el-button type="warning" plain size="small" @click="best(index)" v-bind:disabled="item.bested">最佳</el-button>-->
<!--          <el-button type="success" plain size="small" @click="solve(index)" v-bind:disabled="item.solved">已解决问题</el-button>-->
<!--        </div>-->
<!--      </el-row>-->
<!--      <hr>-->





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
        items:[{item:{reply_time:'',replyer_uid:0,reply_body:'',reply_star:0,rid:0,liked:false,solved:false,bested:false,like_success:false,best_success:false,solve_success:false}}],
        mail:{},
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
      save_replyer(e){
        this.$store.commit('saveUser',{CurrentUser:e.target.innerText});
      },
      save_user(){
        this.$store.commit('saveUser',{CurrentUser:this.content.username});
      },
      like:function(index){
        let _this=this;
        const axios = require('axios')
        axios.get('/addStar',{
          params:{
            id:_this.items[index].rid
          },}).then(response=>{
          _this.items[index].liked=true;
          _this.items[index].like_success=true;
          _this.items[index].solve_success=false;
          _this.items[index].best_success=false;
          this.$forceUpdate();
          axios.get('/addLiked',{
            params:{
              liker_id:_this.uid,
              rid:_this.items[index].rid
            }}).then(response=>{
            console.log('添加liked成功！')
          })
        })
      },
      solve:function(index){
        let _this=this;
        const axios = require('axios')
        axios.get('/addSolve',{
          params:{
            id:_this.items[index].rid
          },}).then(response=>{
          _this.items[index].solved=true;
          _this.items[index].like_success=false;
          _this.items[index].solve_success=true;
          _this.items[index].best_success=false;
          for (let i = 0; i < _this.items.length ; i++) {
            _this.items[i].solved=true;
          }
          this.$forceUpdate();
        })
      },
      best:function(index){
        let _this=this;
        const axios = require('axios')
        axios.get('/addBest',{
          params:{
            id:_this.items[index].rid
          },}).then(response=>{
          _this.items[index].bested=true;
          _this.items[index].like_success=false;
          _this.items[index].solve_success=false;
          _this.items[index].best_success=true;
          for (let i = 0; i < _this.items.length ; i++) {
            _this.items[i].bested=true;
          }
          this.$forceUpdate();
        })
      },
      challenge:function(index){
        let _this=this;
        const axios = require('axios')
        axios.get('/addChallenge',{
          params:{
            id:_this.items[index].rid
          },}).then(response=>{
          document.getElementById("reply").scrollIntoView();
          _this.ruleForm.reply="我对"+_this.items[index].replyer_uid+"提出的如下意见存有不同看法："+_this.items[index].reply_body;
        })
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


          // get the selected post
          axios.get('/queryMailByTitleAndTime',{
            params:{
              title:conTitle,
              send_time:conTime
            }}).then(response=>{
            this.mail=response.data[0]
            this.cid=response.data[0].id,
              axios.get('/queryUsernameById',{
                params:{
                  id:this.mail.sender_id
                }}).then(response=>{
                this.mail.username=response.data
                console.log(this.mail.username)
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
</style>


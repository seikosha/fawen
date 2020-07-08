<template>
<el-container>
<left_card></left_card>

<el-main>
  <el-col :span="4">&nbsp;</el-col>
  <el-col :span="16" id="main">

    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="标题：" prop="title" >
        <el-input placeholder="请输入标题" v-model="ruleForm.title"></el-input>
      </el-form-item>
      <el-form-item label="详细描述：" prop="content">
        <el-input type="textarea" placeholder="请输入对问题的详细描述" v-model="ruleForm.content" resize="none" rows="10"></el-input>
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
    <el-form-item label="案件性质" prop="category">
      <el-select v-model="ruleForm.category" placeholder="请选择案件性质">
        <el-option label="刑事" value="刑事"></el-option>
        <el-option label="民事" value="民事"></el-option>
        <el-option label="行政" value="行政"></el-option>
        <el-option label="不清楚" value="不清楚"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submit('ruleForm')">提交</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
    </el-form>
  </el-col>
  <el-col :span="4">&nbsp;</el-col>


</el-main>

<el-aside id="rightside" width="200px">
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span>如何正确描述问题？</span>

    </div>
    <div v-for="o in 4" :key="o" class="text item">
      {{'列表内容 ' + o }}
    </div>
  </el-card>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span>历史精选提问</span>

    </div>
    <div v-for="o in 4" :key="o" class="text item">
      {{'列表内容 ' + o }}
    </div>
  </el-card>
</el-aside>
</el-container>
</template>

<script>
  import left_card from "./left_card";

  export default {
      name: "ask",
      methods: {
        submit(formName){
          const axios = require('axios')
          this.$refs.ruleForm.validate((valid)=>{if(valid){
            axios.get('/addContent',{
              params:{
                uid:this.uid,
                title: this.ruleForm.title,
                content: this.ruleForm.content,
                category:this.ruleForm.category,
                location:this.ruleForm.location,
                // create_time:'',
              },}).then(response=>(
              console.log('问题发布成功！')))
          } else{
            console.log('问题发布失败');
            return false;
          }})},
        resetForm(formName) {
          this.$refs[formName].resetFields();
        }
      },
      data() {
        let uid;
        let create_time;
        return {
          uid,
          create_time,
          ruleForm: {
            title:'',
            content:'',
            category:'',
            location:'',
          },
          rules: {
            title: [
              { required:true, message:'请输入标题',trigger:'blur'},
              { min: 8, max: 16, message:'长度在8-16个字符之间',trigger: 'blur'}
            ],
            content:[
              { required:true, message:'请输入内容描述',trigger:'blur'},
              { min: 16,  message:'长度在16个字符以上',trigger:'blur'}
            ],
            category:[
              {required:true, message:'请选择案件类型',trigger:'change'}
            ],
            location:[
              {required:true, message:'请选择所在地区',trigger:'change'}
            ]
          }
        };
      },
      components:{
          left_card
      },




      beforeCreate() {
        const axios = require('axios')
        console.log('加载之前取uid'+this.$store.state.Authorization);
        axios.get('/queryUserByUsername',{
          params:{
            username:this.$store.state.Authorization
          },}).then(response=>(
            this.uid=response.data,

            console.log(this.uid)))
        if(this.$store.state.Authorization==null|this.$store.state.Authorization===''||this.$store.state.Authorization===undefined){
          this.$router.push('/login');
        }
      }
    }
</script>

<style scoped>
  #main{
    text-align: left;
  }

  #leftside
  {
    position:relative;
    top:20px;
    left:33px;
  }

  #rightside{
    position:relative;
    top:20px;
    right:16px;
  }


</style>

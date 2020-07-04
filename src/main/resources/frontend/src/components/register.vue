<template>
<el-container>
  <el-col span="5"></el-col>

  <el-col span="14" style="margin-top: 20px">
    <span>用户名：</span>
    <el-input v-model="username" placeholder="长度为4个字符（两个汉字)以上" show-word-limit="true" style="margin-bottom: 15px"></el-input>
    <span>密码：</span>
    <el-input placeholder="请输入字符为6位以上的密码" v-model="password" show-password style="margin-bottom: 15px"></el-input>
    <span>邮箱地址：</span>
    <el-input v-model="email" placeholder="请输入您的邮箱地址" show-word-limit="true" style="margin-bottom: 15px"></el-input>
    <span>所在地区：</span><br>
    <el-select v-model="value" placeholder="请选择" style="margin-bottom: 15px">
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select>
    <br>
    <span>当前状态：</span><br>
    <el-select v-model="value1" placeholder="请选择" style="margin-bottom: 15px">
      <el-option
        v-for="item1 in status_options"
        :key="item1.value1"
        :label="item1.label1"
        :value="item1.value1">
      </el-option>
    </el-select>
    <br>

    <span>自我介绍：</span>
    <el-input
      type="textarea"
      :rows="2"
      placeholder="请输入您的自我介绍"
      v-model="textarea"
      style="margin-bottom: 15px">
    </el-input>
    <el-button v-on:click="submit" type="info" plain>提交</el-button>
  </el-col>
  <br>



  <el-col span="5"></el-col>
</el-container>
</template>

<script>
    export default {
        name: "register",
        data() {
          return {
            options: [{
              value: '北京',
              label: '北京'
            }, {
              value: '天津',
              label: '天津'
            }, {
              value: '河北',
              label: '河北'
            }, {
              value: '山西',
              label: '山西'
            }, {
              value: '内蒙古',
              label: '内蒙古'
            }, {
              value: '辽宁',
              label: '辽宁'
            }, {
              value: '吉林',
              label: '吉林'
            }, {
              value: '黑龙江',
              label: '黑龙江'
            }, {
              value: '上海',
              label: '上海'
            }, {
              value: '江苏',
              label: '江苏'
            }, {
              value: '浙江',
              label: '浙江'
            }, {
              value: '安徽',
              label: '安徽'
            },{
              value: '福建',
              label: '福建'
            }, {
              value: '江西',
              label: '江西'
            }, {
              value: '山东',
              label: '山东'
            }, {
              value: '河南',
              label: '河南'
            }, {
              value: '湖北',
              label: '湖北'
            }, {
              value: '湖南',
              label: '湖南'
            }, {
              value: '广东',
              label: '广东'
            }, {
              value: '广西',
              label: '广西'
            }, {
              value: '海南',
              label: '海南'
            }, {
              value: '重庆',
              label: '重庆'
            }, {
              value: '四川',
              label: '四川'
            }, {
              value: '贵州',
              label: '贵州'
            }, {
              value: '云南',
              label: '云南'
            }, {
              value: '西藏',
              label: '西藏'
            }, {
              value: '陕西',
              label: '陕西'
            }, {
              value: '甘肃',
              label: '甘肃'
            }, {
              value: '青海',
              label: '青海'
            }, {
              value: '宁夏',
              label: '宁夏'
            }, {
              value: '新疆',
              label: '新疆'
            }, {
              value: '台湾',
              label: '台湾'
            }, {
              value: '香港',
              label: '香港'
            }, {
              value: '澳门',
              label: '澳门'
            }
            ],
            status_options: [{
              value1: '律师',
              label1: '律师'
            }, {
              value1: '法律专业学生',
              label1: '法律专业学生'
            }, {
              value1: '社会法律工作者',
              label1: '社会法律工作者'
            }, {
              value1: '司法机关从业者',
              label1: '司法机关从业者'
            }, {
              value1: '以上都不是',
              label1: '以上都不是'
            }
            ],
            username: '',
            password: '',
            email:'',
            textarea: '',
            value:'',
            value1:''
          }
        },
        methods:{
          submit(){
            const axios = require('axios');
            let myDate = new Date();
            let year = myDate.getFullYear();
            let month = myDate.getMonth()+1;
            let day = myDate.getDate();
            let hour = myDate.getHours();
            let minute = myDate.getMinutes();
            let second = myDate.getSeconds();

            axios.get('/addUser',{
              params:{
                username: this.username,
                password: this.password,
                email:this.email,
                location:this.options.value,
                status:this.status_options.value1,
                description:this.textarea,
                create_time: year.toString().concat('-').concat(month).concat('-').concat(day).concat(' ').concat(hour).concat(':').concat(minute).concat(':').concat(second),}
            }).then(response=>(console.log('vila！')));
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

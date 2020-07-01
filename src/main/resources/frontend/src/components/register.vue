<template>
<el-container>
  <el-col span="5"></el-col>

  <el-col span="14" style="margin-top: 20px">
    <span>用户名：</span>
    <el-input v-model="input" placeholder="长度为4个字符（两个汉字)以上" show-word-limit="true" style="margin-bottom: 15px"></el-input>
    <span>密码：</span>
    <el-input placeholder="请输入字符为6位以上的密码" v-model="input" show-password style="margin-bottom: 15px"></el-input>
    <span>邮箱地址：</span>
    <el-input v-model="input" placeholder="请输入您的邮箱地址" show-word-limit="true" style="margin-bottom: 15px"></el-input>
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
    <el-select v-model="value" placeholder="请选择" style="margin-bottom: 15px">
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
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
    <span>上传头像：</span>
    <el-upload
      class="avatar-uploader"
      action="https://jsonplaceholder.typicode.com/posts/"
      :show-file-list="false"
      :on-success="handleAvatarSuccess"
      :before-upload="beforeAvatarUpload"
      style="margin-bottom: 15px">
      <img v-if="imageUrl" :src="imageUrl" class="avatar">
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
    <el-button type="info" plain>提交</el-button>
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
              value: '选项1',
              label: '黄金糕'
            }, {
              value: '选项2',
              label: '双皮奶'
            }, {
              value: '选项3',
              label: '蚵仔煎'
            }, {
              value: '选项4',
              label: '龙须面'
            }, {
              value: '选项5',
              label: '北京烤鸭'
            }],
            input: '',
            value: '',
            imageUrl: ''
          }
        },
        methods:{
          handleAvatarSuccess(res, file) {
            this.imageUrl = URL.createObjectURL(file.raw);
          },
          beforeAvatarUpload(file) {
            const isJPG = file.type === 'image/jpeg';
            const isLt2M = file.size / 1024 / 1024 < 2;

            if (!isJPG) {
              this.$message.error('上传头像图片只能是 JPG 格式!');
            }
            if (!isLt2M) {
              this.$message.error('上传头像图片大小不能超过 2MB!');
            }
            return isJPG && isLt2M;
        }
    }}
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

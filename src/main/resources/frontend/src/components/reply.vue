<template>
  <el-row>
    <span >回复人：<a href="#">{{replyer}}</a></span><span>{{' '+reply_time}}</span>
    <div class="maintext">{{reply_body}}</div>
    <div style="float: right; margin-top:30px">
      <el-button type="primary" size="small" plain>赞同</el-button>
      <el-button type="danger" size="small" plain>挑战</el-button>
      <el-button type="warning" plain size="small">最佳</el-button>
      <el-button type="success" plain size="small">已解决问题</el-button>
    </div>
  </el-row>
</template>

<script>
    export default {
        name: "reply",
        data(){
          return {
            replyer:'熊孜',
            reply_time:'2020-6-30 14:53:03',
            reply_body:'我觉得这样是不行的'
          }
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
</style>

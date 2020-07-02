<template>
  <el-aside id="rightside" width="200px">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>按地区浏览历史回答</span>

      </div>
      <div v-for="o in 4" :key="o" class="text item">
        {{'列表内容 ' + o }}
      </div>
    </el-card>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>按类型浏览历史回答</span>

      </div>
      <div v-for="o in 4" :key="o" class="text item">
        {{'列表内容 ' + o }}
      </div>
    </el-card>
  </el-aside>
</template>

<script>
    export default {
        name: "right_card"
    }
</script>

<style scoped>
  #rightside{
    position:relative;
    top:20px;
    right:16px;
  }
</style>

<template>
  <el-container>
    <el-aside id="leftside" width="200px">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>法问</span>

        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{'列表内容 ' + o }}
        </div>
      </el-card>
    </el-aside>

    <el-main id="main">
      <el-row>
        <router-link to="/ask"><el-button id="buttonl" type="primary" plain>我有问题</el-button></router-link>
        <el-button id="buttonr" type="success" plain>我能解答</el-button>
      </el-row>
    </el-main>

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
  </el-container>
</template>

<script>
    export default {
        name: "index"
    }
</script>

<style scoped>
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


  #buttonl,
  #buttonr{
    width:240px;
    height:240px;
    margin:auto;
    position:relative;
    top:20px;
  }

  #buttonl{
    right:20px;
  }

  #buttonr{
    left:20px;
  }

  /*#ask{*/
  /*  text-decoration: none;*/
  /*}*/
</style>

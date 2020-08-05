<template>
    <el-container>
      <left_card></left_card>

      <el-main id="main">
        <h2>法问更新公告</h2>
        <br>
        <p>1.遵守中华人民共和国法律法规</p>
      </el-main>

      <right_card></right_card>
    </el-container>
</template>

<script>
  import left_card from "./left_card";
  import right_card from "./right_card";
    export default {
        name: "posts",
      components: {
          left_card,
        right_card
      }
    }
</script>

<style scoped>
  @media screen and (max-width: 768px) {
    #main{
      position:relative;
      left:80px;
      bottom:40px;
    }
  }
</style>

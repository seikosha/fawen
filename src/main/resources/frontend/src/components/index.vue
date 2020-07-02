<template>
  <el-container>
    <left_card></left_card>
    <buttons></buttons>
    <right_card></right_card>

  </el-container>
</template>

<script>
  import App from '../App'
  import historic_selection from "./historic_selection";
  import star_user from "./star_user";
  import left_card from "./left_card";
  import right_card from "./right_card";
  import buttons from "./buttons";

    export default {
        name: "index",

        components:{
          App,
          historic_selection,
          star_user,
          left_card,
          right_card,
          buttons
        },


    }
</script>

<style scoped>

</style>

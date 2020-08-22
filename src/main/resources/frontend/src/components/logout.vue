<template>
    <el-container>
      <el-main id="main">
        <p>您是否要登出当前账号？</p><br><br>

        <router-link to="/"
         v-bind="this.$store.commit('changeLogin',{Authorization: ''})"
        @click.native="refresh"><el-button type="danger" plain>是的</el-button></router-link>
        <router-link to="/"><el-button plain>不是</el-button></router-link>
      </el-main>

    </el-container>
</template>

<script>
    export default {
        name: "logout",
        methods: {
          refresh:function(){
            this.$router.go(0)
          },
        }
    }

</script>

<style scoped>
  @media screen and (max-width: 768px) {
    #main{
      position:relative;
    }
  }
</style>

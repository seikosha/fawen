<template>
    <el-header>
      <el-col :span="5" id="title">
        <router-link to="/" tag="a" id="title_link">法问</router-link>
      </el-col>
      <el-col :span="14">
        <el-menu
          class="el-menu-demo"
          mode="horizontal"
          text-color="#000000"
          gutter="20"
        >
          <el-menu-item index="1"><router-link to="/my_questions" tag="span">我的提问</router-link></el-menu-item>
          <el-menu-item index="2"><router-link to="/my_answers" tag="span">我的回答</router-link></el-menu-item>
          <el-menu-item index="3"><router-link to="/personal" tag="span">个人页面</router-link></el-menu-item>
          <el-menu-item index="4"><router-link to="/mails" tag="span">站内私信</router-link></el-menu-item>
          <el-menu-item index="5"><router-link to="/register" tag="span" >注册</router-link></el-menu-item>
          <el-menu-item index="6"><router-link to="/login" tag="span">登录</router-link></el-menu-item>

        </el-menu>
      </el-col>
      <el-col :span="5">

        <el-row gutter="2px">
          <el-col :span="20">
            <el-input placeholder="请输入内容" v-model="input" class="input-with-select"></el-input>
          </el-col>
          <el-col :span="4">
            <el-button icon="el-icon-search" type="info" plain @click="search(input)"></el-button>
          </el-col>

        </el-row>


      </el-col>
    </el-header>

</template>

<script>
    export default {
      name: "header1",
      data(){
        return{
            input:'',
        }
      },
      methods:{
        search(input){
          this.$store.commit('saveKeyword',{CurrentKeyword: this.input});
          this.$router.push('/search_result');
        }
      }

    }
</script>

<style scoped>

</style>

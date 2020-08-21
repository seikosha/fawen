<template>
  <el-header>
    <el-row>
      <el-col :span="4">
        <router-link to="/" tag="h2" id="title_link">法问</router-link>
      </el-col>
      <el-col :span="20" >
        <el-col :span="6">
          <el-dropdown>
  <span class="el-dropdown-link">
    个人菜单<i class="el-icon-arrow-down el-icon--right"></i>
  </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item><router-link to="/my_questions" tag="span">我的提问</router-link></el-dropdown-item>
              <el-dropdown-item><router-link to="/my_answers" tag="span">我的回答</router-link></el-dropdown-item>
              <el-dropdown-item><router-link to="/personal" tag="span">个人页面</router-link></el-dropdown-item>
              <el-dropdown-item><router-link to="/mails" tag="span">站内私信</router-link></el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-col>
        <el-col :span="6">
          <el-dropdown>
  <span class="el-dropdown-link">
    网站导航<i class="el-icon-arrow-down el-icon--right"></i>
  </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item><router-link to="/historic_selection" tag="span">历史精选贴</router-link></el-dropdown-item>
              <el-dropdown-item><router-link to="/star_user" tag="span">明星回答者</router-link></el-dropdown-item>
              <el-dropdown-item><router-link to="/posts" tag="span">网站公告</router-link></el-dropdown-item>
              <el-dropdown-item><router-link to="/about" tag="span">关于法问</router-link></el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-col>
        <el-col :span="6">
          <el-dropdown>
  <span class="el-dropdown-link">
    问题类型<i class="el-icon-arrow-down el-icon--right"></i>
  </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item><router-link to="/historic_selection" tag="span">刑事</router-link></el-dropdown-item>
              <el-dropdown-item><router-link to="/star_user" tag="span">民事</router-link></el-dropdown-item>
              <el-dropdown-item><router-link to="/posts" tag="span">行政</router-link></el-dropdown-item>
              <el-dropdown-item><router-link to="/about" tag="span">不清楚</router-link></el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-col>
        <el-col :span="6">
          <el-button plain><router-link to="/logout" tag="span">登出</router-link></el-button>
        </el-col>
      </el-col>
    </el-row>
  </el-header>
</template>

<script>
  export default {
    name: "header4",
    data() {
      return {
        username: ''+this.$store.state.Authorization+'',
      }
    },
    methods:{
      saveCategory(e){
        this.$store.commit('saveCategory',{CurrentCategory:e.target.innerText});
        this.$router.go(0)
      }
    }
  }
</script>

<style scoped>
  #leftside{
    cursor: pointer;
  }
  @media screen and (min-width: 768px) {
    #leftside{
      display:none;
    }
  }
</style>
+

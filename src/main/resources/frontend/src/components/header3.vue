<template>
    <el-header>
      <router-link to="/" tag="h2" id="title_link">法问</router-link>
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose">
          <el-menu-item index="1">
            <i class="el-icon-question"></i>
            <router-link to="/ask" tag="span">我有问题</router-link>
          </el-menu-item>
          <el-menu-item index="2" >
            <i class="el-icon-key"></i>
            <router-link to="/answer" tag="span">我能解答</router-link>
          </el-menu-item>
          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-tickets"></i>
              <span>个人菜单</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="1-1"><router-link to="/my_questions" tag="span">我的提问</router-link></el-menu-item>
              <el-menu-item index="1-2"><router-link to="/my_answers" tag="span">我的回答</router-link></el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group>
              <el-menu-item index="1-3"><router-link to="/personal" tag="span">个人页面</router-link></el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group>
              <el-menu-item index="1-4"><router-link to="/mails" tag="span">站内私信</router-link></el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-menu-item index="4" >
            <i class="el-icon-edit-outline"></i>
            <router-link to="/register" tag="span">注册</router-link>
          </el-menu-item>
          <el-menu-item index="5" >
            <i class="el-icon-ship"></i>
            <router-link to="/login" tag="span">登录</router-link>
          </el-menu-item>
          <el-submenu index="6">
            <template slot="title">
              <i class="el-icon-document-copy"></i>
              <span>问题分类</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="1-1">
                <router-link @click.native="saveCategory($event)" tag="span" to="/specific_category" style="font-size:small" >刑事</router-link>
              </el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group>
              <el-menu-item index="1-2">
                <router-link @click.native="saveCategory($event)" tag="span" to="/specific_category" style="font-size:small" >民事</router-link>
              </el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group>
              <el-menu-item index="1-3">
                <router-link @click.native="saveCategory($event)" tag="span" to="/specific_category" style="font-size:small" >行政</router-link>
              </el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group>
              <el-menu-item index="1-4">
                <router-link @click.native="saveCategory($event)" tag="span" to="/specific_category" style="font-size:small" >不清楚</router-link>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
    </el-menu>
    </el-header>
</template>

<script>
    export default {
        name: "header3",
      methods:{
        saveCategory(e){
          this.$store.commit('saveCategory',{CurrentCategory:e.target.innerText});
          this.$router.go(0)
        }
      }
    }
</script>

<style scoped>

</style>

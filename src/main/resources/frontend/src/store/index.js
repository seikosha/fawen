import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

export default new Vuex.Store({

  state: {
    // // 存储token
     Authorization: localStorage.getItem('Authorization') ? localStorage.getItem('Authorization') : '',
     CurrentContent: localStorage.getItem('CurrentContent') ? localStorage.getItem('CurrentContent') : ''
  },

  mutations: {
    // 修改token，并将token存入localStorage
    changeLogin (state,user) {
      state.Authorization = user.Authorization;
      console.log("store/index.js---到这里了!");
      localStorage.setItem('Authorization', user.Authorization);
    },

    saveContent(state,content){
      state.CurrentContent=content.CurrentContent;
      console.log("成功暂存帖子信息");
      localStorage.setItem('CurrentContent',content.CurrentContent);
    }

    // changeLogin(username){
    //   this.Authorization = username;
    //   console.log('验证注入成功！');
    //   console.log('验证信息为'+this.Authorization.toString());
    // }
  }
});

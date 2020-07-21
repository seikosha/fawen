import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

export default new Vuex.Store({

  state: {
    // // 存储token
     Authorization: localStorage.getItem('Authorization') ? localStorage.getItem('Authorization') : '',
     CurrentContent: localStorage.getItem('CurrentContent') ? localStorage.getItem('CurrentContent') : '',
     CurrentUser: localStorage.getItem('CurrentUser') ? localStorage.getItem('CurrentUser') : ''
  },

  mutations: {
    // 修改token，并将token存入localStorage
    changeLogin (state,user) {
      state.Authorization = user.Authorization;
      localStorage.setItem('Authorization', user.Authorization);
    },

    saveContent(state,content){
      state.CurrentContent=content.CurrentContent;
      console.log("成功暂存帖子信息");
      localStorage.setItem('CurrentContent',content.CurrentContent);
    },

    saveUser(state,user){
      state.CurrentUser=user.CurrentUser;
      console.log('成功保存指定用户信息');
      localStorage.setItem('CurrentUser',user.CurrentUser);
    }
  }
});

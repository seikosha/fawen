import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

export default new Vuex.Store({

  state: {
    // // 存储token
     Authorization: localStorage.getItem('Authorization') ? localStorage.getItem('Authorization') : '',
     CurrentContent: localStorage.getItem('CurrentContent') ? localStorage.getItem('CurrentContent') : '',
     CurrentUser: localStorage.getItem('CurrentUser') ? localStorage.getItem('CurrentUser') : '',
     CurrentMail: localStorage.getItem('CurrentMail') ? localStorage.getItem('CurrentMail') : '',
     CurrentKeyword: localStorage.getItem('CurrentKeyword') ? localStorage.getItem('CurrentKeyword') : '',
     CurrentLocation: localStorage.getItem('CurrentLocation') ? localStorage.getItem('CurrentLocation') : '',
     CurrentCategory: localStorage.getItem('CurrentCategory') ? localStorage.getItem('CurrentCategory') : ''
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

    saveMail(state,mail){
      state.CurrentMail = mail.CurrentMail;
      console.log("成功暂存当前私信");
      localStorage.setItem('CurrentMail',mail.CurrentMail);
    },

    saveUser(state,user){
      state.CurrentUser=user.CurrentUser;
      console.log('成功保存指定用户信息');
      localStorage.setItem('CurrentUser',user.CurrentUser);
    },

    saveKeyword(state,keyword){
      state.CurrentKeyword=keyword.CurrentKeyword;
      console.log('成功保存关键字');
      localStorage.setItem('CurrentKeyword',keyword.CurrentKeyword);
    },

    saveLocation(state,location){
      state.CurrentLocation=location.CurrentLocation;
      console.log('成功保存当前地区信息');
      localStorage.setItem('CurrentLocation',location.CurrentLocation);
    },

    saveCategory(state,category){
      state.CurrentCategory=category.CurrentCategory;
      console.log('成功保存当前案件类别');
      localStorage.setItem('CurrentCategory',category.CurrentCategory);
    }
  }
});

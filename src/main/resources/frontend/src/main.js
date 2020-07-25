import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import echarts from 'echarts';
import Vuex from 'vuex'
import store from './store';

import index from "./components/index"
import ask from "./components/ask";
import answer from "./components/answer";
import my_questions from "./components/my_questions";
import my_answers from "./components/my_answers";
import personal from "./components/personal";
import mails from "./components/mails";
import register from "./components/register";
import login from "./components/login";
import historic_selection from "./components/historic_selection";
import star_user from "./components/star_user";
import left_card from "./components/left_card";
import right_card from "./components/right_card";
import constitution from "./components/constitution";
import posts from "./components/posts";
import logout from "./components/logout";
import content from "./components/content";
import test from "./components/test";
import specific_content from "./components/specific_content";
import personal_specific from "./components/personal_specific";
import send_mail from "./components/send_mail";
import mail_success from "./components/mail_success";
import mail_specific from "./components/mail_specific";
import search_result from "./components/search_result";
import hot from "./components/hot";
import about from "./components/about";
import more_locations from "./components/more_locations";
import specific_location from "./components/specific_location";



Vue.use(VueRouter)
Vue.use(ElementUI)
Vue.use(Vuex)
Vue.prototype.$echarts = echarts;

const routes = [

  { path: '/', component: index},
  { path: '/ask', component: ask },
  { path: '/answer', component: answer},
  { path: '/my_questions', component: my_questions},
  { path: '/my_answers', component: my_answers},
  { path: '/personal', component: personal},
  { path: '/mails', component: mails},
  { path: '/register', component: register},
  { path: '/login', component: login},
  { path: '/historic_selection', component: historic_selection},
  { path: '/star_user', component: star_user},
  { path: '/left_card', component: left_card},
  { path: '/right_card', component: right_card},
  { path: '/constitution', component: constitution},
  { path: '/posts', component: posts},
  { path: '/logout', component: logout},
  { path: '/content', component: content},
  { path: '/test', component: test},
  { path: '/specific_content', component: specific_content},
  { path: '/personal_specific', component: personal_specific},
  { path: '/send_mail', component: send_mail},
  { path: '/mail_success', component: mail_success},
  { path: '/mail_specific', component: mail_specific},
  { path: '/search_result', component: search_result},
  { path: '/hot',component:hot},
  { path: '/about', component: about},
  { path: '/more_locations', component: more_locations},
  { path: '/specific_location', component: specific_location}
]

const router = new VueRouter({
  routes,
  mode: 'history'
})


new Vue({
  el: '#app',
  //用<App/>代替根元素
  template: '<App/>',
  //声明App组件，这样上面的<App/>元素就可以生效
  components: { App },
  //将上面声明的路由器传递到根Vue实例
  router,
  store
}).$mount('#app')//将这个实例挂载到id=app的根元素上

const axios = require('axios');
//异步请求前在header里加入token
axios.interceptors.request.use(
  config => {
    if(config.url==='/login'||config.url==='/register'){  //如果是登录和注册操作，则不需要携带header里面的token
    }else{
      if (localStorage.getItem('Authorization')) {
        config.headers.Authorizatior = localStorage.getItem('Authorization');
      }
    }
    return config;
  },
  error => {
    return Promise.reject(error);
  });
//异步请求后，判断token是否过期
axios.interceptors.response.use(
  response =>{
    return response;
  },
  error => {
    if(error.response){
      switch (error.response.status) {
        case 401:
          localStorage.removeItem('Authorization');
          this.$router.push('/');
      }
    }
  }
)








import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import index from "./components/index"
import ask from "./components/ask";
import answer from "./components/answer";
import my_questions from "./components/my_questions";
import my_answers from "./components/my_answers";

Vue.use(VueRouter)
Vue.use(ElementUI)

const routes = [

  { path: '/', component: index},
  { path: '/ask', component: ask },
  { path: '/answer', component: answer},
  { path: '/my_questions', component: my_questions},
  { path: '/my_answers', component: my_answers}
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
  router
}).$mount('#app')//将这个实例挂载到id=app的根元素上



import { createRouter, createWebHistory } from 'vue-router'

import Login from '../components/login/Login.vue';
import Main from '../components/Main/Main.vue'

const routes = [

  {
      path: '/', component: Login, children:[
      
    ]
    //pathMatch,동적인  import-> 미리로드하지 않고 쓸지 않쓸지 모르는 걸 위한 Lazy로딩법
  },
  {
    path: '/main',
    component: Main
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});


export default routes;
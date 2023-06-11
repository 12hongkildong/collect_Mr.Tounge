import { createRouter, createWebHistory } from 'vue-router'

import Login from '../components/login/Login.vue';

import Index from '../components/Index.vue'

import Main from '../components/Main/Main.vue'
import Board from '../components/board/FreeBoard.vue'
import MyList from '../components/MyList/MyList.vue'



const routes = [
  {
    path: '/login', component: Login, children:[
    
  ]
  //pathMatch,동적인  import-> 미리로드하지 않고 쓸지 않쓸지 모르는 걸 위한 Lazy로딩법
  },
  {
      path: '/', component: Index, children:[
        {
          path: 'main',
          component: Main
        },
        {
          path: 'board',
          component: Board
        },
        {
          path: 'list',
          component: MyList
        },
    ]
    //pathMatch,동적인  import-> 미리로드하지 않고 쓸지 않쓸지 모르는 걸 위한 Lazy로딩법
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});


export default routes;
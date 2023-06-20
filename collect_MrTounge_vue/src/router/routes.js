import { createRouter, createWebHistory } from 'vue-router'

import Login from '../components/login/Login.vue';
import Sign from '../components/login/Sign.vue';
import Main from '../components/Main/Main.vue'
import Board from '../components/board/FreeBoard.vue'
import MyList from '../components/MyList/MyList.vue'
import gpt from '../components/board/gptPage.vue'
import Detail from '../components/board/Detail.vue'
import CreateArticle from '../components/board/CreateArticle.vue'



const routes = [

  {
      path: '/', component: Login, children:[
      
    ]
    //pathMatch,동적인  import-> 미리로드하지 않고 쓸지 않쓸지 모르는 걸 위한 Lazy로딩법
  },
  {
    path: '/sign', component: Sign,
  },
  {
    path: '/main',
    component: Main
  },
  {
    path: '/board',
    component: Board,
    // children:[
    //   {path: ':id', component:Detail}
    // ]
  },
  {
    path: '/board/:id', 
    component:Detail,
    name:'detail',
    props: true,
  },
  {
    path:'/create',
    component:CreateArticle
  },
  {
    path: '/list',
    component: MyList
  },
  {
    path: '/gpt',
    component: gpt
  },
];


const router = createRouter({
  history: createWebHistory(),
  routes,
});


export default routes;
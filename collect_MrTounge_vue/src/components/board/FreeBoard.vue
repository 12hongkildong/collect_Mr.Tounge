<template lang="">
    <section class="grid grid grid-cols-[26.875rem_1fr_26.875rem] min-h-[59.5rem] w-[120rem]" >
        <h1>메인 창</h1>
        <section class="col-start-2 bg-pink-400 grid grid-rows-[100px_524px_200px_128px]">
            <div>공략집</div>
            
            <section>
                <form action="">
                    <select name="" id="">
                        <option value="title">제목</option>
                        <option value="writer">작성자</option>
                        <option value="content">내용</option>
                    </select>
                    <input type="text">
                    <button class="bg-white border">검색</button>
                </form>
                <section class="grid grid-flow-row bg-red-400 border-solid border-2" > <!-- 게시판 -->
                    <h1 class="hidden">게시판 테이블</h1>
                    <div class="grid grid-cols-[60px_500px_128px_60px_100px_60px] border-solid border-2">
                        <div>번호</div>
                        <div>제목</div>
                        <div>작성자</div>
                        <div>조회수</div>
                        <div>날짜</div>
                        <div>추천수</div>
                    </div>
                    <div v-for="(list, i) in data" :key="i" class="grid grid-cols-[60px_500px_128px_60px_100px_60px] ">
                        <div>{{data[i].id}}</div>
                        <div>{{data[i].title}}</div>
                        <div>{{data[i].memberId}}</div>
                        <div>{{data[i].hit}}</div>
                        <div>{{data[i].regDate}}</div>
                        <div>0</div>
                    </div>
                </section>
                <section >
                    <h1 class="hidden">페이지네이션</h1>
                    <nav aria-label="Page navigation">
                      <ul class="inline-flex">
                        <li><button class="h-10 px-5 text-indigo-600 transition-colors duration-150 bg-white rounded-l-lg focus:shadow-outline hover:bg-indigo-100" @click="changePage(1)">First</button></li>
                        <li><button class="h-10 px-5 text-indigo-600 transition-colors duration-150 bg-white rounded-l-lg focus:shadow-outline hover:bg-indigo-100" @click="fiveMinuseJumpPage()">5점프</button></li>
                        <li><button class="h-10 px-5 text-indigo-600 transition-colors duration-150 bg-white rounded-l-lg focus:shadow-outline hover:bg-indigo-100" @click="previousPage()">이전</button></li>
                        <div v-for="num in showPage" :key="num">
                          <li><button class="" :class="currentPage == num ? 'h-10 px-5 text-white transition-colors duration-150 bg-indigo-600 focus:shadow-outline' : 'h-10 px-5 text-indigo-600 transition-colors duration-150 bg-white focus:shadow-outline hover:bg-indigo-100'" @click="changePage(num)">{{num}}</button></li>
                        </div>
                        <li><button class="h-10 px-5 text-indigo-600 transition-colors duration-150 bg-white rounded-r-lg focus:shadow-outline hover:bg-indigo-100" @click="nextPage()">다음</button></li>
                        <li><button class="h-10 px-5 text-indigo-600 transition-colors duration-150 bg-white rounded-r-lg focus:shadow-outline hover:bg-indigo-100" @click="fiveJumpPage()">5점프</button></li>
                        <li><button class="h-10 px-5 text-indigo-600 transition-colors duration-150 bg-white rounded-r-lg focus:shadow-outline hover:bg-indigo-100" @click="changePage(totalPages)">Last</button></li>
                      </ul>
                    </nav>
                </section>
            </section>
        </section>
    </section>

    {{data}}
    {{totalPages}}
    <!-- <div class="bg-red-300">{{data}}</div>
    
    <div class="bg-blue-300">{{data2}}</div>
    <div class="bg-yellow-300">{{data3}}</div>

    <div class="bg-purple-400" v-for="item in data.boardList" :key="item.id">
      {{item}}
    </div> -->
</template>
<script setup>
import { reactive, onMounted, onUpdated, onBeforeMount, ref, computed } from 'vue';

// let data = reactive();
let data = ref("");
let list = ref("");
let totalPages = ref(11);
let PageChangeRange = 5;
let currentPage = ref(1);

let pageCutCount = computed(()=>{
  return Math.trunc(totalPages.value/PageChangeRange);
});

let showPage = ref(5);

// let showPage = computed(()=>{
//     const start = (currentPage.value - 1) * PageChangeRange + 1;
//     const end = Math.min(start + PageChangeRange - 1, totalPages.value);
//     return Array.from({ length: end - start + 1 }, (_, index) => start + index);
//   }
// );

function updatePage(){
  const start = (Math.floor((currentPage.value - 1) / PageChangeRange) * PageChangeRange) + 1;
  const end = Math.min(start + PageChangeRange - 1, totalPages.value);
  showPage = Array.from({ length: end - start + 1 }, (_, index) => start + index);
};

function nextPage() {
  if (currentPage.value < totalPages.value) {
    currentPage.value++;
    updatePage();
  }
}

function previousPage() {
  if (currentPage.value !=1) {
    currentPage.value--;
    updatePage();
  }
}

function changePage(num){
  // if(!currentPage == (1||totalPages))
    currentPage.value=num;
    updatePage();
}

function fiveJumpPage(){
  if(!((totalPages.value-currentPage.value)<=Math.trunc(totalPages.value%5)-1))
  currentPage.value = Math.ceil(currentPage.value / PageChangeRange) * PageChangeRange + 1;
  updatePage();
}

function fiveMinuseJumpPage(){
  if (currentPage.value > 5){ 
  currentPage.value -= (PageChangeRange+(Math.trunc(currentPage.value-1)%PageChangeRange))
  console.log()
  updatePage();
  }
}


// let data2 = reactive({
//   id: '',
//   title: '',
//   contnent: '',
//   regDate: '',
//   hit: '',
//   memberId: '',
// })
// let data3 = reactive();

onMounted(() => {
  var requestOptions = {
    method: 'GET',
    redirect: 'follow'
  };

  fetch("http://localhost:8080/listallpagenation?page=0", requestOptions)
    .then(response => response.json())
    .then(result => {
      // data = result;
      data.value = result;
      data.value = result.boardList;
      list.value = result.boardList;
      totalPages.value = result.totalPages;
      console.log(totalPages);
      console.log(result)
    })
    .catch(error => console.log('error', error));
  console.log("마운트");
})



</script>
<style scoped></style>
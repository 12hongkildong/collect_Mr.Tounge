<template lang="">
    <section class="grid grid grid-cols-[26.875rem_1fr_26.875rem] min-h-[59.5rem] w-[120rem]" >
        <h1>메인 창</h1>
        <section class="col-start-2 bg-pink-400 grid grid-rows-[100px_524px_200px_128px]">

                <h1>메인</h1>
                <div class="row-start-2 z-0">
                        <!-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=582abe9ccb2561cbe67f7bcc34c45c1e"></script> -->
                    <kakao :userId="userId" ref="child" :latLng="latLng" :map="map"></kakao>

                </div>
                <div class="row-start-3 grid grid-cols-3 justify-items-center items-center text-center">
                    <button class="rounded-3xl w-56 h-40 bg-blue-50 text-4xl" @click="modalBtn">사진 업로드</button>
                    <router-link to="/list" class="rounded-3xl w-56 h-40 bg-blue-50  text-4xl grid items-center justify-center">모아보기</router-link>
                    <router-link to="/board" class="rounded-3xl w-56 h-40 bg-blue-50  text-4xl grid items-center justify-center">공략집</router-link>

                </div>

        </section>
    </section>

    <Modal class="z-99 grid justify-center content-center" 
           v-show="showModal" :modalState="showModal" :userId="userId" @closeModal="closeModal" @center="uploadedCenter">

    </Modal>


</template>
<script setup>
import Modal from '../Modal/Modal.vue'
import {ref, onUpdated, reactive} from 'vue';
import kakao from '../Map/KakaoMap.vue'
import { useUserDetailsStore } from '../../stores/useUserDetailsStore.js';
import { useLatLngStore } from '../../stores/useLatLngStore.js';

let userId = useUserDetailsStore().userId; // 유저아이디 공유

let latLngStore = useLatLngStore(); // 최초 지도 중앙 위치
const latLng = reactive([
    latLngStore.lat,
    latLngStore.lng
]);

let map = ref('');
let center1 = reactive([]);
let child = ref(null);

let showModal = ref(false);
console.log(showModal.value)

function modalBtn(){
    showModal.value = true;
    console.log(showModal.value)
}
function closeModal(){
    showModal.value=false;
    showMarkers()
}
function showMarkers() {
    child.value.setMarkers(map)    
}

function uploadedCenter(test){ // 가장 최근에 자식에서 업로드 한 이미지 center값 부모로 받아오기
    center1=test;

    latLngStore.saveCategory(center1.Ma,center1.La)
    
    changeCenter();
    // showMarkers();
}

function changeCenter(){
    child.value.setCenter(center1)
}

</script>
<style scoped>


</style>
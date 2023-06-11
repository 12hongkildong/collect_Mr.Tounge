<template lang="">
    <section class="grid grid grid-cols-[26.875rem_1fr_26.875rem] min-h-[59.5rem] w-[120rem]" >
        <h1>메인 창</h1>
        <section class="col-start-2 bg-pink-400 grid grid-rows-[100px_524px_200px_128px]">

                <h1>메인</h1>
                <div class="row-start-2 z-0">
                        <!-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=582abe9ccb2561cbe67f7bcc34c45c1e"></script> -->
                    <kakao ></kakao>


                </div>
                <div class="row-start-3 grid grid-cols-3 justify-items-center items-center text-center">
                    <button class="rounded-3xl w-56 h-40 bg-blue-50 text-4xl" @click="modalBtn">사진 업로드</button>
                    <router-link to="/list" class="rounded-3xl w-56 h-40 bg-blue-50  text-4xl">모아보기</router-link>
                    <router-link to="/board" class="rounded-3xl w-56 h-40 bg-blue-50  text-4xl">공략집</router-link>

                </div>

        </section>
    </section>

    <Modal class="z-99 grid justify-center content-center" v-show="showModal" :modalState="showModal" @closeModal="closeModal">

    </Modal>


</template>
<script setup>
import Modal from '../Modal/Modal.vue'
import {ref} from 'vue';
import kakao from '../Map/KakaoMap.vue'

let showModal = ref(false);
console.log(showModal.value)
function modalBtn(){
    showModal.value = true;
    console.log(showModal.value)
}
function closeModal(){
    showModal.value=false;
}

</script>
<style scoped>


</style>
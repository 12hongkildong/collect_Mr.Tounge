<template lang="">
    <section class="grid grid grid-cols-[26.875rem_1fr_26.875rem] min-h-[59.5rem] w-[120rem]" >
        <h1>메인 창</h1>
        <section class="col-start-2 bg-pink-400 grid grid-rows-4 ">

                <h1>메인</h1>
                <div class="row-start-2">map</div>
                <div class="row-start-3 grid grid-cols-2 justify-items-center items-center text-center">
                    <button class="rounded-3xl w-56 h-40 bg-blue-50 text-4xl" @click="modalBtn">사진 업로드</button>
                    <router-link to="www.naver.com" class="rounded-3xl w-56 h-40 bg-blue-50  text-4xl">모아보기</router-link>
                </div>

        </section>
    </section>

    <Modal v-show="showModal" class="" :modalState="showModal" @closeModal="closeModal">

    </Modal>


</template>
<script setup>
import Modal from '../Modal/Modal.vue'
import {ref} from 'vue';
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
    .modal-wrapper{
        position:fixed;
        top:0;
        left:0;
        width: 100%;
        height: 100%;
        background-color: rgba(0,0, 0, 0.5);

    }


</style>
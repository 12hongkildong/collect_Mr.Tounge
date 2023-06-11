<template lang="">
    <div class="modal-wrapper">
        <div class="bg-white rounded-lg w-[50rem] h-[30rem] ">
            <span class="hover:text-red-600 text-3xl cursor-pointer" @click="closeModal">&times;</span>
            <section>
                <h1>사진 업로드</h1>
                <input type="file" name="" id="" accept="image/*">
                <div class="bg-blue-400 w-96 h-48">지도</div>
                <div>간단 설명</div>
                <textarea name="" id="" cols="43" rows="5" class="resize border-solid border-black border-2"></textarea>
                <button class="w-20 h-20 bg-gray-500" @click="imgUpload">완료</button>
            </section>
        </div>
    </div>
</template>

<script setup>
import {defineProps, defineEmits} from 'vue';

const emit = defineEmits([
    "closeModal"
]);

const props = defineProps({
    modalState:{
        type:Boolean
    }
})

function closeModal(){
    console.log(props.modalState)
    emit('closeModal');
    
}

function imgUpload(){
    console.log("사진 올림")
    emit('closeModal');
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
    .modal-content-box{
        background-color: #fff;
        
        
    }
    .resize{
        resize: none;
    }
</style>
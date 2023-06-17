<template lang="">
        <section class="grid grid grid-cols-[26.875rem_1fr_26.875rem] min-h-[59.5rem] w-[120rem] select-none" >
        <h1>메인 창</h1>
    <section class="col-start-2 bg-pink-400 grid grid-rows-[60px_1fr_100px_128px] ">
            <h1>디테일 게시글</h1>
            <section class="p-5">
                <input type="text" class="text-6xl mb-2" maxlength="20" v-model="title" placeholder="제목">
                <div class="border-t-4 border-indigo-500 border-solid bg-blue-400 pl-2">

                </div>
                <div class="h-[500px] bg-white">
                    <textarea name="" id="" class="p-4 h-[500px] w-[1020px] resize-none whitespace-pre-line" v-model="content"  placeholder="내용을 입력하세요."></textarea>
                </div>
            </section>
            <div class="grid justify-center">
                <router-link to="board" class="bg-gray-400 w-32 h-32 grid items-center justify-center cursor-pointer" @click="savePost(title, content)">저장하기</router-link>
            </div>
        </section>
    </section>
</template>
<script setup>
import {ref} from 'vue'
import { useUserDetailsStore } from '../../stores/useUserDetailsStore.js'

let userId = useUserDetailsStore().userId;
let title = ref("");
let content = ref("");


    function savePost(title, content) {
        console.log("세이부")

        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        var raw = JSON.stringify({
            "memberId": userId,
            "title": title,
            "content": content
        });

        var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
        };

        fetch("http://localhost:8080/createArticle", requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
    }

</script>
<style lang="">
    
</style>
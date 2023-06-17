<template lang="">
    <section class="grid grid grid-cols-[26.875rem_1fr_26.875rem] min-h-[59.5rem] w-[120rem] select-none" >
        <h1>메인 창</h1>
        <section class="col-start-2 bg-pink-400 grid grid-rows-[60px_1fr_100px_128px]" v-if="!modifyVisible">
            <h1>디테일 게시글</h1>
            <section class="p-5">
                <h1 class="text-6xl mb-2">{{data.title}}</h1>
                <div class="border-t-4 border-indigo-500 border-solid bg-blue-400 pl-2">
                    {{data.memberId}}
                    {{data.regDate}}
                </div>
                <div class="h-[500px] bg-white">
                    <div class="p-4 whitespace-pre-line">
                        {{data.content}}
                    </div>
                </div>
            </section>
            <div class="grid justify-center">
                <div v-if="data.memberId==userId" class="bg-gray-400 w-32 h-32 grid items-center justify-center cursor-pointer" @click="modifyPost">수정하기</div>
            </div>
        </section>
        <section v-if="modifyVisible" class="col-start-2 bg-pink-400 grid grid-rows-[60px_1fr_100px_128px] ">
            <h1>디테일 게시글</h1>
            <section class="p-5">
                <input type="text" class="text-6xl mb-2" v-model="data.title" maxlength="20">
                <div class="border-t-4 border-indigo-500 border-solid bg-blue-400 pl-2">
                    {{data.memberId}}
                    {{data.regDate}}
                </div>
                <div class="h-[500px] bg-white">
                    <textarea name="" id="" class="p-4 h-[500px] w-[1020px] resize-none whitespace-pre-line" v-model="data.content"></textarea>
                </div>
            </section>
            <div class="grid justify-center">
                <div v-if="data.memberId==userId" class="bg-gray-400 w-32 h-32 grid items-center justify-center cursor-pointer" @click="savePost(data.id, data.title, data.content)">저장하기</div>
            </div>
        </section>
    </section>

</template>
<script setup>
import { defineProps, ref, onMounted, toRefs } from 'vue';
import { useUserDetailsStore } from '../../stores/useUserDetailsStore.js'

let userId = useUserDetailsStore().userId;

let data = ref("");

let modifyVisible = ref(false);

function modifyPost() {
    modifyVisible.value = !modifyVisible.value
    console.log(modifyVisible.value)
}

function savePost(id, title, content) {
    modifyVisible.value = !modifyVisible.value



    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "id": id,
        "title": title,
        "content": content
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("http://localhost:8080/updateArticle", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}

const props = defineProps({
    id: {
        type: String,
    },
})


onMounted(() => {
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch(`http://localhost:8080/detailPage?id=${props.id}`, requestOptions)
        .then(response => response.json())
        .then(result => {
            console.log(result)
            data.value = result;
            console.log("데이타는" + data.value.id)
        })
        .catch(error => console.log('error', error));
})

console.log(props)
</script>
<style scoped>
.input-reset {
    /* 초기화할 속성을 기본값으로 설정 */
    all: unset;
}
</style>
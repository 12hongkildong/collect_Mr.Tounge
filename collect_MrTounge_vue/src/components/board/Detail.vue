<template lang="">
    <section class="grid grid grid-cols-[26.875rem_1fr_26.875rem] min-h-[59.5rem] w-[120rem] select-none" >
        <h1>메인 창</h1>
        <section class="col-start-2 bg-pink-400 grid grid-rows-[60px_1fr_100px_128px]">
            <h1>디테일 게시글</h1>
            <section class="p-5">
                <h1 class="text-6xl mb-2">{{data.title}}</h1>
                <div class="border-t-4 border-indigo-500 border-solid bg-blue-400 pl-2">
                    {{data.memberId}}
                    {{data.regDate}}
                </div>
                <div class="h-[500px] bg-white">
                    <div class="p-4">
                        {{data.content}}
                    </div>
                </div>
            </section>
            <div v-if="1==1">수정하기</div>
        </section>
    </section>

</template>
<script setup>
import { defineProps, ref, onMounted } from 'vue';

let data = ref("");

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
            console.log("데이타는"+data.value.id)
        })
        .catch(error => console.log('error', error));
})

console.log(props)
</script>
<style lang="">
    
</style>
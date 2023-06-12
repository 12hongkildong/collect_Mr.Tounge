<template lang="">
    <h1>카카오맵 출력 테스트</h1>
    <div id="map" class="w-[1060px] h-[500px]"></div>
</template>

<script setup>
import { onMounted } from 'vue';

function initMap(){
    const container = document.getElementById("map");
    const options = {
        center : new kakao.maps.LatLng(37.5666612,126.9783785),
        level: 3,
    };
    let map = new kakao.maps.Map(container, options)
}

onMounted(() => {
    console.log("계속되나 확인")
    if(!window.kakao || !window.kakao.maps){
        const script = document.createElement("script");
        script.src = '//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=582abe9ccb2561cbe67f7bcc34c45c1e'

        script.addEventListener("load", () => {
            kakao.maps.load(()=>{
                initMap();
            })
        });
        document.head.appendChild(script);
        
    }
    else{
        initMap();
    }
})


</script>
<style lang="">
    
</style>
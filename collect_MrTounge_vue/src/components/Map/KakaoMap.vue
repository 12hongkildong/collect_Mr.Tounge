<template lang="">
    <h1>카카오맵 출력 테스트</h1>
    <div id="map" class="w-[1060px] h-[500px]"></div>
</template>

<script setup>
import { onMounted, reactive, ref, defineProps, onUpdated } from 'vue';

const props = defineProps({
    userId: {
        type: Number
    },
    latLng:{
        type:Array
    },
    map:{
    }
})

let collectList = reactive([]);
let markers = reactive([]);
let userId = props.userId;
let latLng = props.latLng;
let map;

function getCollect() {
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch(`http://localhost:8080/main/collectData?userId=${userId}`, requestOptions)
        .then(response => response.json())
        .then(result => {
            collectList=result; // db에서 불러온 값들 collectList에 담기
            for(let i in collectList){
                console.log(i)
                addMarker(new kakao.maps.LatLng(collectList[i].lat, collectList[i].lng))
            }
        })
        .catch(error => console.log('error', error));
}


onMounted(async () => {
  if (!window.kakao || !window.kakao.maps) {
    const script = document.createElement("script");
    script.src = "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=7b216600d29c3a7c098a5c21b56e324f";

    script.addEventListener("load", () => {
      kakao.maps.load(async () => {
        await initMap(); // initMap 함수가 완료될 때까지 기다립니다.
        getCollect(); // initMap 함수가 완료된 후에 getCollect 함수를 호출합니다.
      });
    });
    document.head.appendChild(script);
  } else {
    await initMap(); // initMap 함수가 완료될 때까지 기다립니다.
    getCollect(); // initMap 함수가 완료된 후에 getCollect 함수를 호출합니다.
  }
});
// onMounted(() => {
//     if (!window.kakao || !window.kakao.maps) {
//         const script = document.createElement("script");
//         script.src = '//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=7b216600d29c3a7c098a5c21b56e324f'

//         script.addEventListener("load", () => {
//             kakao.maps.load(() => {
//                 initMap();
//             })
//         });
//         document.head.appendChild(script);
//     }
//     else {
//         initMap();
//     }
//     getCollect();
// })

function initMap() {
    const container = document.getElementById("map");
    const options = {
        center: new kakao.maps.LatLng(latLng[0], latLng[1]),
        level: 7,
    };
    map = new kakao.maps.Map(container, options)
}

function addMarker(LatLng) { // db에 불러온 값들 메인 지도에 마커 달기

    var imageSrc = '/images/pin.png', // 마커이미지의 주소입니다    
        imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
        imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

    // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
        markerPosition = new kakao.maps.LatLng(LatLng.Ma, LatLng.La);

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: markerPosition,
        image: markerImage
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);

    // 생성된 마커를 배열에 추가합니다
    markers.push(marker);
}


onUpdated(() => {
    for(let i in collectList.length){
        addMarker(new kakao.maps.LatLng(collectList[i].lat, collectList[i].lng))
    }

    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }
})

function setMarkers(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }            
}

function setCenter(LatLng) {      
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new kakao.maps.LatLng(LatLng.Ma, LatLng.La);
    
    // 지도 중심을 이동 시킵니다
    map.setCenter(moveLatLon);
}

defineExpose({
    setCenter,
    setMarkers
})

</script>
<style lang="">
    
</style>
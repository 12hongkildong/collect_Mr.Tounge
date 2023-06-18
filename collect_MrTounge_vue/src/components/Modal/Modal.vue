<template lang="">
    <div class="modal-wrapper">
        <div class="bg-white rounded-lg w-[50rem] h-[30rem] ">
            <section>
                <h1>사진 업로드</h1>
                <!-- <form action="" method="post" enctype="multipart/form-data"> -->
                    <input type="file" name="image" id="imageData2" ref="selectFile" accept="image/*" v-on:change="changeFile($event.target.files[0])">
                    <div class="bg-blue-400 w-96 h-48">
                        <div id="map2" class="w-96 h-48"></div>
                    </div>
                    <label for="message" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">간단 설명</label>
                    <textarea  id="message" cols="100" rows="4" class="resize block p-2.5 w-fit text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 focus:bg-white" placeholder="Write your thoughts here..." v-model="content"></textarea>
                    <div class="bg-gray-50 px-4 py-3 sm:flex sm:flex-row-reverse sm:px-6 rounded-b-lg">
                        <button type="button" class="inline-flex w-full justify-center rounded-md bg-blue-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-blue-500 sm:ml-3 sm:w-auto"  @click="imgUpload()">완료</button>
                        <button type="button" class="mt-3 inline-flex w-full justify-center rounded-md bg-white px-3 py-2 text-sm font-semibold text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-gray-50 sm:mt-0 sm:w-auto" @click="closeModal">Cancel</button>
                    </div>
                <!-- </form>     -->
            </section>
        </div>
    </div>
</template>

<script setup>
import { defineProps, defineEmits, ref, onUpdated, onMounted, reactive } from 'vue';
import { useUserDetailsStore } from '../../stores/useUserDetailsStore';

let userId = useUserDetailsStore().userId;
let imageUrl = ref("");

let latitude = ref(0);
let longitude = ref(0);

let lat = ref(0);
let lng = ref(0);

let file = "";
let file2 = ref("");

let content = ref("");

// let imageFileSongJavaVer = reactive("");

const selectFile = ref(null);


const emit = defineEmits([
    "closeModal"
]);

const props = defineProps({
    modalState: {
        type: Boolean
    }
})

function changeFile(e) {
    file = e; // 이미지 파일
    file2.value = e;
    
    EXIF.getData(file, function () {
        let exifLong = EXIF.getTag(this, "GPSLongitude");
        let exifLat = EXIF.getTag(this, "GPSLatitude");
        let exifLongRef = EXIF.getTag(this, "GPSLongitudeRef");
        let exifLatRef = EXIF.getTag(this, "GPSLatitudeRef");

        if (exifLatRef == "S") {
            latitude = (exifLat[0] * -1) + (((exifLat[1] * -60) + (exifLat[2] * -1)) / 3600);
        } else {
            latitude = exifLat[0] + (((exifLat[1] * 60) + exifLat[2]) / 3600);
        }

        

        if (exifLongRef == "W") {
            longitude = (exifLong[0] * -1) + (((exifLong[1] * -60) + (exifLong[2] * -1)) / 3600);
        } else {
            longitude = exifLong[0] + (((exifLong[1] * 60) + exifLong[2]) / 3600);
        }

        console.log(latitude)
        console.log(longitude)

        lat.value=latitude;
        lng.value=longitude;

        // const file = e.target.files[0];
        const reader = new FileReader();

        reader.onload = () => {
            this.imageUrl = reader.result;
            imageUrl.value = this.imageUrl
            addMap(imageUrl.value)
        };

        reader.readAsDataURL(file);
    });
}

function addMap(url) {
    const container2 = document.getElementById("map2");
    const options2 = {
        center: new kakao.maps.LatLng(latitude, longitude),
        level: 2,
    };

    let map2 = new kakao.maps.Map(container2, options2)

    var imageSrc = '/images/pin.png', // 마커이미지의 주소입니다    
        imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
        imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

    // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
        markerPosition = new kakao.maps.LatLng(latitude, longitude);

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: markerPosition,
        image: markerImage // 마커이미지 설정 
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map2);
}

function closeModal() {
    console.log(props.modalState)

    document.getElementById('imageData2').value = null;
    emit('closeModal');
}


function imgUpload() {

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "multipart/form-data; boundary=--MyBoundary123")

    var formdata = new FormData();
    formdata.append("image", file2)
    formdata.append("collect",JSON.stringify({
            "memberId": userId,
            "information": content.value,
            "lat": lat.value,
            "lng": lng.value
        }), {type: "application/json"});

    var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: formdata,
    redirect: 'follow'
    };

    fetch("http://localhost:8080/main/uploadImage", requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
    .catch(error => console.log('error', error));

}

</script>
<style scoped>
.modal-wrapper {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
}

.modal-content-box {
    background-color: #fff;


}

.resize {
    resize: none;
}
</style>
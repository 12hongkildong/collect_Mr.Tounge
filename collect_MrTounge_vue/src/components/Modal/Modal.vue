<template lang="">
    <div class="modal-wrapper">
        <div class="bg-white rounded-lg w-[50rem] h-[30rem] ">
            <section>
                <h1>사진 업로드</h1>
                <!-- <form action="" method="post" enctype="multipart/form-data"> -->
                    <input type="file" name="" id="" accept="image/*" v-on:change="changeFile($event.target.files[0])">
                    <div class="bg-blue-400 w-96 h-48">지도</div>
                    <label for="message" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">간단 설명</label>
                    <textarea id="message" cols="100" rows="4" class="resize block p-2.5 w-fit text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 focus:bg-white" placeholder="Write your thoughts here..."></textarea>
                    <div class="bg-gray-50 px-4 py-3 sm:flex sm:flex-row-reverse sm:px-6 rounded-b-lg">
                        <button type="button" class="inline-flex w-full justify-center rounded-md bg-blue-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-blue-500 sm:ml-3 sm:w-auto"  @click="imgUpload">완료</button>
                        <button type="button" class="mt-3 inline-flex w-full justify-center rounded-md bg-white px-3 py-2 text-sm font-semibold text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-gray-50 sm:mt-0 sm:w-auto" @click="closeModal">Cancel</button>
                    </div>
                <!-- </form>     -->
            </section>
        </div>
    </div>
</template>

<script setup>
import { defineProps, defineEmits } from 'vue';
import { useUserDetailsStore } from '../../stores/useUserDetailsStore';


let userId = useUserDetailsStore.userId;

const emit = defineEmits([
    "closeModal"
]);

const props = defineProps({
    modalState: {
        type: Boolean
    }
})

function changeFile(e) {
    // console.log(e);
    const exifData = ExifReader.load(e);
    console.log(exifDate);
    const { GPSLatitude, GPSLongitude } = exifData;

    if (GPSLatitude && GPSLongitude) {
      const latitude = GPSLatitude.description;
      const longitude = GPSLongitude.description;
      console.log("Latitude:", latitude);
      console.log("Longitude:", longitude);
    } else {
      console.log("Location information not found.");
    }
}



function closeModal() {
    console.log(props.modalState)
    emit('closeModal');

}

function imgUpload() {
    console.log("사진 올림")
    emit('closeModal');
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
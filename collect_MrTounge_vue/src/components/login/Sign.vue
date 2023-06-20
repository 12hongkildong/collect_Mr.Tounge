<template lang="">
    <section class="grid grid-cols-[26.875rem_1fr_26.875rem] min-h-[59.5rem] w-[120rem]" >
        <h1>메인 창</h1>
        <section class="bg-pink-400 grid">

                <h1 class="hidden">회원가입</h1>

            <form  @submit.prevent="validateForm">
                <fieldset class="p-5 grid grid-rows-3 grid-cols-[10rem_1fr_10rem]">
                    <div class="col-start-2">
                        <legend class="hidden">회원가입 폼</legend>
                            <div class="mt-2.5">
                                <label for="email">이메일</label>
                                <input v-model="email" type="text" name="email" id="email" autocomplete="off" class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" placeholder="이메일" required/>
                            </div>
                            <div class="mt-2.5">
                                <label for="pwd">비밀번호</label>
                                <input  v-model="pwd" type="password" name="pwd" id="pwd" class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" placeholder="비밀번호" required/>
                            </div>
                            <div class="mt-2.5">
                                <label  for="checkPwd">비밀번호 확인</label>
                                <input  v-model="pwdCheck" type="password" name="checkPwd" id="checkPwd" class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" placeholder="비밀번호 확인" required/>
                            </div>      
                            <div class="mt-2.5">
                                <label for="nickname">닉네임</label>
                                <input v-model="nickname" type="text" name="nickname" id="nickname" autocomplete="off" class="block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" placeholder="닉네임" required/>
                            </div>

                            <button  class="rounded-md bg-indigo-600 px-3.5 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600" type="submit">회원가입</button>
                    </div>
                </fieldset>
            </form>
        </section>
    </section>
</template>
<script setup>
import { ref } from 'vue'
import { useRouter, useRoute } from 'vue-router'
const router = useRouter()

let email = ref("");
let pwd = ref("");
let pwdCheck = ref("");
let nickname = ref("");

function isValidEmail(email) {
  var pattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  return pattern.test(email);
}


function validateForm(event) {
   
    if (!isValidEmail(email.value)) {
        alert("이메일 형식이 아니네요. 다시 작성해주세요.")
    }

    else if (pwd.value === pwdCheck.value) {

        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        var raw = JSON.stringify({
            "email": email.value,
            "nickname": nickname.value,
            "password": pwd.value
        });

        var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
        };

        fetch("http://localhost:8080/sign/send", requestOptions)
            .then(response => response.text())
            .then(result => {
                if(result==1){
                    router.push({ path: "/" })
                    alert("회원가입 성공했습니다.")
                }
                else{
                    alert("아이디 혹은 닉네임이 기존사용자와 중복됩니다. 다시 작성해주세요.")
                }
            })
            .catch(error => console.log('error', error));


    } else {
        alert("두 비밀번호가 다릅니다. 비밀번호를 확인해 다시 입력해주세요.")
    }
}

</script>
<style lang="">
    
</style>
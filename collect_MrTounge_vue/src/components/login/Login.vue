<template lang="">
    <section class="grid grid grid-cols-[26.875rem_1fr_26.875rem] grid-rows-[100px_524px_200px_128px] w-[120rem] min-h-[59.5rem]" >
        <h1>로그인 창</h1>
        <section class="col-start-2 row-start-2 bg-pink-400 grid grid-rows-4">
            <input type="text" placeholder="아이디" class="border-solid border-2 border-black row-start-2">
            <input type="text" placeholder="비밀번호"  class="border-solid border-2 border-black row-start-3">
            <button class="border-solid border-2 border-black row-start-4 ">로그인</button>
            <div class="row-start-5">
                <button class="rounded-full w-14 h-14 bg-yellow-300">카카오 로그인</button>
                <button class="rounded-full w-14 h-14 bg-green-600">구글 로그인</button>
            </div>
        </section>
    </section>
</template>
<script>
export default {

}
</script>
<style lang="">
    
</style>
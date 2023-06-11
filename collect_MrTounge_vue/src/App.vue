<script setup>
import { RouterLink, RouterView } from 'vue-router'
// import HelloWorld from './components/HelloWorld.vue'
</script>

<template>
    <header class="text-3xl bg-pink-400 w-[120rem] h-[8rem] grid grid-cols-[26.875rem_1fr_26.875rem] content-center">
        <h1 class="hidden">헤더</h1>
        <div class="col-start-2">Collect_Mr.Tongue</div>
    </header>

    <main>
        <router-view></router-view>
    </main>

</template>

<style scoped>

</style>

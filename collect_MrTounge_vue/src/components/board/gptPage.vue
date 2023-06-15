<template>
    <div>
      <ul>
        <li v-for="item in visibleItems" :key="item">{{ item }}</li>
      </ul>
      <button @click="previousPage" :disabled="currentPage === 1">Previous</button>
      <button @click="nextPage" :disabled="currentPage === totalPages">Next</button>
    </div>
  </template>
  
  <script>
  import { ref, computed } from 'vue';
  
  export default {
    setup() {
      const totalItems = 11;
      const itemsPerPage = 5;
      const currentPage = ref(1);
  
      const totalPages = computed(() => Math.ceil(totalItems / itemsPerPage));
  
      const visibleItems = computed(() => {
        const start = (currentPage.value - 1) * itemsPerPage + 1;
        const end = Math.min(start + itemsPerPage - 1, totalItems);
        return Array.from({ length: end - start + 1 }, (_, index) => start + index);
      });
  
      function nextPage() {
        if (currentPage.value < totalPages.value) {
          currentPage.value++;
        }
      }
  
      function previousPage() {
        if (currentPage.value > 1) {
          currentPage.value--;
        }
      }
  
      return {
        currentPage,
        totalPages,
        visibleItems,
        nextPage,
        previousPage
      };
    }
  };
  </script>
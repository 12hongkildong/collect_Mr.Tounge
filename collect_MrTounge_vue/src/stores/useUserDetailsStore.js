import { defineStore } from "pinia";

export const useUserDetailsStore = defineStore("userId", {
    state: () => ({
        userId: 1
    }),
    actions: {
        saveCategory(id) {
            this.userId = id;
        },
    }
});

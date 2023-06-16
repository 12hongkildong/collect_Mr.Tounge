import { defineStore } from "pinia";

export const useBoardPageStore = defineStore("boardPage", {
    state: () => ({
        page: 1
    }),
    actions: {
        savePage(num) {
            this.page = num;
        },
    }
});

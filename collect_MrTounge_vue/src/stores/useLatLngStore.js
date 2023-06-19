import { defineStore } from "pinia";

export const useLatLngStore = defineStore("latLng", {
    state: () => ({
        lat: 37.5666612,
        lng: 126.9783785
    }),
    actions: {
        saveCategory(lat, lng) {
            this.lat = lat;
            this.lng = lng;
        },
    }
});

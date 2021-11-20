var app = new Vue({
    el: '#OrganizacionesVue',
    data: {
        organizaciones: [],
    },
    created() {
        fetch('http://localhost:8080/organizaciones/nombres')
            .then(response => response.json()).then(json => {
            this.organizaciones = json;
        })
    }
})

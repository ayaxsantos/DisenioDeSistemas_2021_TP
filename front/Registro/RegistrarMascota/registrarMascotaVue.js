var appOrganizacionesVue = new Vue({
    el: '#OrganizacionesVue',
    data: {
        orgElegida: 'PatitasJugetonas',
        organizaciones: [],
        caracteristicas: []
    },
    methods: {
        cambioOrg() {
            fetch("http://localhost:8080/organizacion/" + this.orgElegida.toString() + "/caracteristicas")
                .then(response => response.json()).then(json => {
                this.caracteristicas = json;
            })
        }
    },
    created() {
        fetch('http://localhost:8080/organizaciones/nombres')
            .then(response => response.json()).then(json => {
            this.organizaciones = json;
        })
    }
})

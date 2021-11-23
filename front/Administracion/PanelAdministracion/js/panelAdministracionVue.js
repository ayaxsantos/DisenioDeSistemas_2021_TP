var appPanelAdmin = new Vue({
    el: '#PanelAdministracionVue',
    data: {
        orgElegida: '',
        organizaciones: [],
        nombreUsuario: '',
        usuariosSinPrivilegios: [],
        calidadFoto: '',
        tamañoFoto: '',
        caracteristicas:[]
    },
    method:
        {
            solicitarOrg() {
                fetch('localhost:8080/organizacion/panelAdministracion')
                    .then(response => response.json()).then(json =>{
                    this.nombreUsuario = json.nombreUsuario;
                    this.usuariosSinPrivilegios = json.usuariosSinPrivilegios;
                    this.calidadFoto = json.calidadFoto;
                    this.tamañoFoto = json.tamañoFoto;
                    this.caracteristicas = json.caracteristicas;
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
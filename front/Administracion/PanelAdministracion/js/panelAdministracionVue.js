var appPanelAdministracionVue = new Vue({
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
    methods:
        {
            solicitarOrg() {

                var idSesion = localStorage.getItem("IDSESION") // Recuperamos el ID de sesion...
                fetch("http://localhost:8080/organizacion/" + this.orgElegida.toString() + "/panelAdministracion", {
                    headers: {
                        "Authorization": idSesion // Enviamos el ID de sesion como header...
                    }
                })
                    .then(response => response.json()).then(infoPanel => {
                        this.nombreUsuario = infoPanel.nombreUsuario;
                        this.usuariosSinPrivilegios = infoPanel.usuariosSinPrivilegios;
                        this.calidadFoto = infoPanel.calidadFoto;
                        this.tamañoFoto = infoPanel.tamañoFoto;
                        this.caracteristicas = infoPanel.caracteristicas;
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
var idSesion = localStorage.getItem("IDSESION") // Recuperamos el ID de sesion...

var appPanelAdministracionVue = new Vue({
    el: '#PanelAdministracionVue',
    data: {
        orgElegida: '',
        organizaciones: [],
        nombreUsuario: '',
        usuariosAdministradores: [],
        calidadFoto: '',
        tamanioFoto: '',
        caracteristicas:[],
        calidadesFotos: [],
        tamaniosFotos: [],
        calidadElegida: '',
        tamanioElegido: '',
        caracteristicaIngresada:''
    },
    methods:
        {
            solicitarOrg: function() {
                this.usuariosAdministradores = []
                this.caracteristicas = []
                this.calidadElegida = ''
                this.tamanioElegido= ''
                fetch("http://localhost:8080/organizacion/" + this.orgElegida.toString() + "/panelAdministracion", {
                    headers: {
                        "Authorization": idSesion // Enviamos el ID de sesion como header...
                    }
                })
                    .then(response => response.json()).then(infoPanel => {
                        this.nombreUsuario = infoPanel.nombreUsuario
                        this.usuariosAdministradores = infoPanel.usuariosAdministradores
                        this.calidadFoto = infoPanel.calidadFoto
                        this.tamanioFoto = infoPanel.tamañoFoto
                        infoPanel.caracteristicas.forEach(
                            unaCar => this.caracteristicas.push({caracteristica:unaCar,valorIngresado: unaCar, flagIngresoCar:false})
                        )
                        this.calidadElegida = this.calidadFoto
                        this.tamanioElegido = this.tamanioFoto
                    }
                )
            },
            agregarFilaCaracteristicas: function(){
                if(this.caracteristicas.length != 0)
                    this.caracteristicas.push({caracteristica:'',valorIngresado: '',flagIngresoCar:true})
            },
            levatarFlagIngresoCar: function(car){
                car.flagIngresoCar = true
            },
            guardarValor: function(indice)
            {
                this.caracteristicas[indice].caracteristica = this.caracteristicas[indice].valorIngresado
                this.caracteristicas[indice].flagIngresoCar = true
                this.actualizarCaracteristicas()
            },
            actualizarCaracteristicas: function()
            {
                var response = {
                        caracteristica : this.caracteristicas.map(
                            unaCar => unaCar.caracteristica
                        )
                    }
                console.log(JSON.stringify(response))
                this.realizarActualizacion(response,"http://localhost:8080/organizacion/"
                    + this.orgElegida.toString() + "/actualizarCaracteristicas")
            },
            actualizarDetalleFotos: function()
            {
                var response = {
                    //Falta response para fotos!!
                }
            },
            realizarActualizacion: function(response,input)
            {
                fetch(input,
                    {
                        method: "POST",
                        headers:
                            {
                                'Content-Type': 'application/json',
                                "Authorization": idSesion
                            },
                        body: JSON.stringify(response)
                    }).then(response => {
                        if(response.status != 200)
                            alert("Algo salio mal!!")
                    })
            }
        },
    created() {
        fetch('http://localhost:8080/organizaciones/nombres')
            .then(response => response.json()).then(json => {
            this.organizaciones = json;
        })
        fetch('http://localhost:8080/datos/persona/calidadesFoto')
            .then(response => response.json()).then(json => {
            this.calidadesFotos = json.map(unaCalidad => unaCalidad.toUpperCase());
        })
        fetch('http://localhost:8080/datos/persona/tamanioFotos')
            .then(response => response.json()).then(json => {
            this.tamaniosFotos = json.map(unTamanio => unTamanio.toUpperCase());
        })
    }
})
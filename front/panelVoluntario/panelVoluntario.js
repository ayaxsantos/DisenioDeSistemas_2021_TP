const idVoluntario = localStorage.getItem("idVoluntario");
if (!idVoluntario) {
    window.location.href = "../inicio/home.html";
}


var appPanelVoluntarioVue = new Vue({
    el: '#PanelVoluntarioVue',
    data: {
        publicacionesMascotaEncontrada: [],

    },
    methods:
        {
            actualizarAdmins: function () {
                var response = {
                    adminNuevo: this.usuarioIngresado,
                    contrasenia: this.contraseniaIngresada
                }
                console.log(JSON.stringify(response))
                this.realizarActualizacion(response, "http://localhost:8080/organizacion/panelAdministracion/actualizarAdministradores")
                this.adminsAniadidos.push(this.usuarioIngresado)
            },
            actualizarCaracteristicas: function () {
                var response = {
                    nuevaCaracteristica: this.caracteristicaIngresada
                }
                console.log(JSON.stringify(response))
                this.realizarActualizacion(response, "http://localhost:8080/organizacion/panelAdministracion/actualizarCaracteristicas")
                this.caracteristicasAniadidas.push(this.caracteristicaIngresada)
            },
            actualizarDetalleFotos: function () {
                var response = {
                    calidadFoto: this.calidadElegida,
                    tamanioFoto: this.tamanioElegido
                }
                console.log(JSON.stringify(response))
                this.realizarActualizacion(response, "http://localhost:8080/organizacion/panelAdministracion/actualizarDetalleFotos")
            },
            realizarActualizacion: function (response, input) {
                fetch(input,
                    {
                        method: "POST",
                        headers:
                            {
                                'Content-Type': 'application/json',
                                "Authorization": idAdmin
                            },
                        body: JSON.stringify(response)
                    }).then(response => {
                    if (response.status !== 200)
                        alert("Algo salio mal!!")
                })
            }
        },
    created() {
        fetch("http://localhost:8080/organizacion/panelVoluntario" + this.orgElegida.toString() + "voluntario/organizacion/publicacionesNoVisibles")
            .then(response => response.json())
            .then(unasPublicaciones =>
                unasPublicaciones.forEach(publicacion =>
                    this.publicaciones.push(publicacion)));

        fetch("http://localhost:8080/organizacion/panelVoluntario", {
            headers: {
                "Authorization": idVoluntario
            }
        }).then(response => response.json()).then(infoPanel => {
            this.publicacionesMascotaEncontrada = infoPanel.publicacionesMascotaEncontrada
        })
    }
})
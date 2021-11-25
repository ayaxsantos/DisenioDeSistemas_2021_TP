var RegistrarUsuarioVue = new Vue({
    el: '#RegistrarUsuarioVue',
    data: {
        tiposDocumento: [],
        tipoDocumentoSeleccionado: '',
        numeroDocumento: '',
        usuario: '',
        contrasenia: '',
        repeticionContrasenia: ''
    },
    methods: {

        enviarDatos() {
            var solicitudRegistroUsuario = {
                nombre: this.orgElegida,
                numeroDocumento: numeroDocumento,
                tipoDocumento: tipoDocumento,
                nombre: this.nombre,
                tipoAnimal: this.tipoAnimalSeleccionado,
                apodo: this.apodo,
                edad: this.edad,
                sexo: this.sexoAnimalSeleccionado,
                tamanio: this.tamanioAnimalSeleccionado,
                descripcionFisica: this.descripcionFisica,
                fotos: this.fotos,
                caracteristicas: {}
            }
            var caracteristicasPreguntas = this.caracteristicas.map(caracteristica => caracteristica.name);
            var caracteristicasRespuestas = this.caracteristicas.map(caracteristica => caracteristica.value);
            caracteristicasPreguntas.forEach((key, i) => solicitudRegistroMascota.caracteristicas[key] = caracteristicasRespuestas[i]);
            console.log(solicitudRegistroMascota);
            fetch("http://localhost:8080/registrar/mascota", {
                method: "POST",
                headers:
                    {
                        'Content-Type': 'application/json'
                    },
                body: JSON.stringify(solicitudRegistroMascota)
            }).then(response => {
                if (response.status >= 400) {
                    alert("Hubo un error en el API")
                } else {
                    console.log(response);
                    return response.json()
                }
            })
        },
    },

    created() {
        fetch('http://localhost:8080/datos/persona/tipoDocumento')
            .then(response => response.json()).then(json => {
            this.tiposDocumento = json;
        })
    }
})
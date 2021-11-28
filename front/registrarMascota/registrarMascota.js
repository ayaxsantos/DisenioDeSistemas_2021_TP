const tipoDocumento = localStorage.getItem("tipoDocumento");
const numeroDocumento = localStorage.getItem("numeroDocumento");
const idUsuario = localStorage.getItem('idSesion');

var appRegistrarMascotaVue = new Vue({
    el: '#RegistrarMascotaVue',
    data: {
        orgElegida: 'info',
        organizaciones: [],
        caracteristicas: [],
        nombre: '',
        apodo: '',
        edad: '',
        tipoAnimalSeleccionado: '',
        sexoAnimalSeleccionado: '',
        tamanioAnimalSeleccionado: '',
        descripcionFisica: '',
        fotos: [],
        tiposAnimal: [],
        sexosAnimal: [],
        tamaniosAnimal: [],
    },
    methods: {
        cambioOrg() {
            this.caracteristicas = [];
            fetch("http://localhost:8080/organizacion/" + this.orgElegida.toString() + "/caracteristicas")
                .then(response => response.json())
                .then(unasCaracteristicas =>
                    unasCaracteristicas.forEach(caracteristica =>
                        this.caracteristicas.push({name: caracteristica, value: ""})));
        },
        enviarDatos() {
            var solicitudRegistroMascota = {
                organizacion: this.orgElegida,
                numeroDocumento: '',
                tipoDocumento: '',
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
            console.log("idUsuario: " + idUsuario);
            console.log("tipoDocumento: " + tipoDocumento);
            //TODO no esta andando desde el idusuario, revisar
            if(idUsuario != null){
                fetch('http://localhost:8080/persona/documento', {headers: {"Authorization": idUsuario}})
                    .then(response => response.json()).then(documento => {
                        solicitudRegistroMascota.numeroDocumento = documento.numero.toString();
                        solicitudRegistroMascota.tipoDocumento = documento.tipo.toString();
                })
            } else if (numeroDocumento != null){
                solicitudRegistroMascota.numeroDocumento = numeroDocumento;
                solicitudRegistroMascota.tipoDocumento = tipoDocumento;
            }
            else {
                alert("Debe iniciar sesión para registrar una mascota");
                return;
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
        agregarFotos: function (event) {
            var files = event.target.files
            Array.from(files).forEach(unFile => this.getBase64(unFile).then(foto => {
                this.fotos.push(foto)
            }))
        },
        getBase64: function (file) {
            return new Promise((resolve, reject) => {
                var reader = new FileReader();
                reader.readAsDataURL(file);
                reader.onload = function () {
                    resolve(reader.result)
                };
                reader.onerror = function (error) {
                    reject('Error: ', error);
                }
            })
        }
    },
    created() {
        fetch('http://localhost:8080/organizaciones/nombres')
            .then(response => response.json()).then(json => {
            this.organizaciones = json;
        })
        fetch('http://localhost:8080/datos/mascota/animal')
            .then(response => response.json()).then(json => {
            this.tiposAnimal = json;
        })
        fetch('http://localhost:8080/datos/mascota/sexo')
            .then(response => response.json()).then(json => {
            this.sexosAnimal = json;
        })
        fetch('http://localhost:8080/datos/mascota/tamanio')
            .then(response => response.json()).then(json => {
            this.tamaniosAnimal = json;
        })
    }
})
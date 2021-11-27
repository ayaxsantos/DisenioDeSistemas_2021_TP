const tipoDocumento = sessionStorage.getItem("tipoDocumento");
const numeroDocumento = sessionStorage.getItem("numeroDocumento");

var appRegistrarMascotaVue = new Vue({
    el: '#RegistrarMascotaVue',
    data: {
        orgElegida: '',
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
            fetch("https://rescate-de-patitas-g6-1.herokuapp.com/organizacion/" + this.orgElegida.toString() + "/caracteristicas")
                .then(response => response.json())
                .then(unasCaracteristicas =>
                    unasCaracteristicas.forEach(caracteristica =>
                        this.caracteristicas.push({name: caracteristica, value: ""})));
        },
        enviarDatos() {
            var solicitudRegistroMascota = {
                organizacion: this.orgElegida,
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
            fetch("https://rescate-de-patitas-g6-1.herokuapp.com/registrar/mascota", {
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
        fetch('https://rescate-de-patitas-g6-1.herokuapp.com/organizaciones/nombres')
            .then(response => response.json()).then(json => {
            this.organizaciones = json;
        })
        fetch('https://rescate-de-patitas-g6-1.herokuapp.com/datos/mascota/animal')
            .then(response => response.json()).then(json => {
            this.tiposAnimal = json;
        })
        fetch('https://rescate-de-patitas-g6-1.herokuapp.com/datos/mascota/sexo')
            .then(response => response.json()).then(json => {
            this.sexosAnimal = json;
        })
        fetch('https://rescate-de-patitas-g6-1.herokuapp.com/datos/mascota/tamanio')
            .then(response => response.json()).then(json => {
            this.tamaniosAnimal = json;
        })
    }
})
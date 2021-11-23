/*
const tipoDocumento = sessionStorage.getItem("tipoDocumento");
const numeroDocumento = sessionStorage.getItem("numeroDocumento");
*/

const tipoDocumento = "DNI";
const numeroDocumento = 38554127;

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
        caracteristicasTest : new Map ()
    },
    methods: {
        cambioOrg() {
            this.caracteristicas = [];
            fetch("http://localhost:8080/organizacion/" + this.orgElegida.toString() + "/caracteristicas")
                .then(response => response.json())
                .then(unasCaracteristicas =>
                    unasCaracteristicas.forEach(caracteristica =>
<<<<<<< HEAD
                        this.caracteristicas.push({ name: caracteristica, value: "" }))
=======
                        this.caracteristicas.push({name: caracteristica, value: ""}))
>>>>>>> ba3b0a8030c7ea3ffb96c9edbe1b0d323a2067fb
                )
        },
        enviarDatos() {
            this.caracteristicas.forEach(caracteristica => this.caracteristicasTest.set(caracteristica.name, caracteristica.value))
            var solicitudRegistroMascota = {
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
                caracteristicasTest: this.caracteristicasTest,
                caracteristicasPreguntas: this.caracteristicas.map(caracteristica => caracteristica.name),
                caracteristicasRespuestas: this.caracteristicas.map(caracteristica => caracteristica.value)
            }
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


/*var appOrganizacionesVue = new Vue({
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

var appMascotaRadioVue = new Vue({
    el: '#MascotaRadioVue',
    data: {
        tipoAnimalSeleccionado: '',
        sexoAnimalSeleccionado: '',
        tamanioAnimalSeleccionado: '',
        tiposAnimal: [],
        sexosAnimal: [],
        tamaniosAnimal: []
    },
    created() {
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
})*/
/*

var appRegistrarMascota = new Vue(
    {
        el: '#RegistrarMascotaVue',
        data: {
            nombre: '',
            apodo: '',
            edad: '',
            respuestasCaracteristicas: []
        },
)


sessionStorage.getItem("TipoDocumento", datos.tipoDocumento);
sessionStorage.getItem("NumeroDocumento", datos.numeroDocumento);
*/

/*

then(datos => {
    localStorage.setItem("IDSESION", datos.idSesion)
    if(datos.idSesion == "-1")
        alert("Usuario o contraseña invalido");
    else window.location.href = "../Home/index.html";
})*/



var appRegistrarMascotaVue = new Vue({
    el: '#RegistrarMascotaVue',
    data: {
        orgElegida: '',
        organizaciones: [],
        caracteristicas: [],
        tipoAnimalSeleccionado: '',
        sexoAnimalSeleccionado: '',
        tamanioAnimalSeleccionado: '',
        tiposAnimal: [],
        sexosAnimal: [],
        tamaniosAnimal: [],
        respuestasCaracteristica: []
    },
    methods: {
        cambioOrg() {
            fetch("http://localhost:8080/organizacion/" + this.orgElegida.toString() + "/caracteristicas")
                .then(response => response.json())
                .then(unasCaracteristicas =>
                    unasCaracteristicas.forEach(caracteristica =>
                        this.caracteristicas.push({ name: caracteristica, value: "" }))
            )
        },
        enviarDatos(){

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

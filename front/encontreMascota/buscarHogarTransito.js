const urlParams = new URLSearchParams(window.location.search);
let myParam = urlParams.get('id');

if(myParam !== "null"){
    document.getElementById("conChapita1").style.display = "none";
    document.getElementById("conChapita2").style.display = "none";
    document.getElementById("conChapita3").style.display = "none";
} else{
    myParam = null;
}

const tipoDocumento = localStorage.getItem("tipoDocumento");
const numeroDocumento = localStorage.getItem("numeroDocumento");
const idUsuario = localStorage.getItem('idSesion');


var appBuscarHogarTransitoVue = new Vue({
    el: '#BuscarHogarTransitoVue',
    data: {
        tipoAnimalSeleccionado: '',
        tamanioAnimalSeleccionado: '',
        tiposAnimal: [],
        tamaniosAnimal: [],
        tipoDocumento: '',
        numeroDocumento: '',
        hogares: []
    },
    methods: {
        enviarDatos(){
            if(myParam){
                solicitud = {
                    tipoDocRescatista: this.tipoDocumento,
                    numDocRescatista: this.numeroDocumento,
                    idMascota: myParam
                }
                input = "http://localhost:8080/rescatista/HogarTransitoChapita"
            } else {
                solicitud = {
                    tipoDocRescatista: this.tipoDocumento,
                    numDocRescatista: this.numeroDocumento,
                    tamanio: this.tamanioAnimalSeleccionado,
                    tipo: this.tipoAnimalSeleccionado
                }
                input = "http://localhost:8080/rescatista/HogarTransitoSinChapita"
            }

            console.log(solicitud);

            fetch(input, {
                method: "POST",
                headers:
                    {
                        'Content-Type': 'application/json'
                    },
                body: JSON.stringify(solicitud)
            }).then(response => {
                if (response.status === 200) {
                } else {
                    alert("Hubo un error en el API")
                }
                let respuesta = response.json().then(hogares => {
                    this.hogares = hogares;
                });
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
        fetch('http://localhost:8080/datos/mascota/animal')
            .then(response => response.json()).then(json => {
            this.tiposAnimal = json;
        })

        fetch('http://localhost:8080/datos/mascota/tamanio')
            .then(response => response.json()).then(json => {
            this.tamaniosAnimal = json;
        })

        if (idUsuario) {
            fetch('http://localhost:8080/persona/documento', {headers: {"Authorization": idUsuario}}).then(response => response.json()).then(json => {
                this.numeroDocumento = json.numero;
                this.tipoDocumento = json.tipo;
            })
        } else if (numeroDocumento) {
            this.numeroDocumento = numeroDocumento;
            this.tipoDocumento = tipoDocumento;
        } else {
            location.href = "../registrarPersona/registrarPersona.html";
        }
        if(myParam) {
            var solicitud = {
                tipoDocRescatista: this.tipoDocumento,
                numDocRescatista: this.numeroDocumento,
                idMascota: myParam
            }
            var input = "http://localhost:8080/rescatista/HogarTransitoChapita"

            fetch(input, {
                method: "POST",
                headers:
                    {
                        'Content-Type': 'application/json'
                    },
                body: JSON.stringify(solicitud)
            }).then(response => {
                if (response.status === 200) {
                } else {
                    alert("Hubo un error en el API")
                }
                let respuesta = response.json().then(hogares => {
                    this.hogares = hogares;
                });
            })
                console.log(this.hogares)
        }
    }
})
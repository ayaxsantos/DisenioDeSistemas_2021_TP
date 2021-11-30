const urlParams = new URLSearchParams(window.location.search);
const myParam = urlParams.get('id');

if(!myParam){
    document.getElementById('SeleccionarOrg').style.display = 'block';
    document.getElementById('botonRegistrar').value = 'Crear publicación';
}


const tipoDocumento = localStorage.getItem("tipoDocumento");
const numeroDocumento = localStorage.getItem("numeroDocumento");
const idUsuario = localStorage.getItem('idSesion');


var appEncontreMascotaVue = new Vue({
    el: '#EncontreMascotaVue',
    data: {
        fotos: [],
        descripcion: '',
        longitud: '',
        latitud: '',
        numeroDocumento: '',
        tipoDocumento: '',
        organizaciones: [],
        orgElegida: 'info'
    },
    methods: {
        enviarDatos(){
            var solicitud
            var input
            if(myParam){
                solicitud = {
                    tipoDocumentoRescatista: this.tipoDocumento,
                    numeroDocumentoRescatista: this.numeroDocumento,
                    idMascota: myParam,
                    estado: this.descripcion,
                    longitud: this.longitud,
                    latitud: this.latitud,
                    fotos: this.fotos
                }
                input = "http://localhost:8080/mascotaEncontradaConChapita"
            } else {
                solicitud = {
                    tipoDocumentoRescatista: this.tipoDocumento,
                    numeroDocumentoRescatista: this.numeroDocumento,
                    nombreOrganizacion: this.orgElegida,
                    estado: this.descripcion,
                    longitud: this.longitud,
                    latitud: this.latitud,
                    fotos: this.fotos
                }
                input = "http://localhost:8080/rescatista/PublicarMascotaEncontrada"
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
                    location.href = "buscarHogarTransito.html?id=" + myParam;
                } else {
                    alert("Hubo un error en el API")
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
        fetch('http://localhost:8080/organizaciones/nombres')
            .then(response => response.json()).then(json => {
            this.organizaciones = json;
        })
    }
})
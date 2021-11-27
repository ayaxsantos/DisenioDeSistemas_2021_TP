var RegistrarUsuarioVue = new Vue({
    el: '#RegistrarUsuarioVue',
    data: {
        usuario: '',
        contrasenia: '',
        repeticionContrasenia: ''
    },
    methods: {

        enviarDatos() {
            if(this.contrasenia !== this.repeticionContrasenia){
                alert("Las contraseñas no coinciden");
                return;
            }
            sessionStorage.setItem("usuario", this.usuario);
            var solicitudRegistroUsuario = {
                nombreUsuario: this.usuario,
                contrasenia: this.contrasenia
            }
            fetch("http://localhost:8080/registrar/usuario", {
                method: "POST",
                headers:
                    {
                        'Content-Type': 'application/json'
                    },
                body: JSON.stringify(solicitudRegistroUsuario)
            }).then(response => {
                console.log(response)
                console.log("hola")
                console.log(response)
                switch (response.status) {
                    case 400:
                        alert("contraseña debil")
                        break;
                    case 404:
                        alert("usuario ya registrado")
                        break;
                    case 200:
                        alert("se registro el usuario correctamente")
                        console.log(response);
                        return response.json()
                        break;
                    default:
                        alert("error desconocido")
                        break;
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
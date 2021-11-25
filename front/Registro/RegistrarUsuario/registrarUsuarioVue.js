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
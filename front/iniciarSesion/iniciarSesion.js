var app = new Vue(
    {
        el: '#loginVue',
        data: {
            nombreUsuario: "",
            contrasenia: "",
        },
        methods: {
            iniciarSesion: async function () {
                const datos = await this.solicitudInicioSesion({
                    nombreUsuario: this.nombreUsuario,
                    contrasenia: this.contrasenia
                })
                localStorage.setItem("IDSESION", datos.idSesion)
                if (datos.idSesion == "-1")
                    alert("Usuario o contraseña invalido");
                else window.location.href = "../inicio/home.html";

            },
            solicitudInicioSesion: async function (unaSolicitud) {
                return fetch("http://localhost:8080/usuarios/autenticar",
                    {
                        method: "POST",
                        headers:
                            {
                                'Content-Type': 'application/json'
                            },
                        body: JSON.stringify(unaSolicitud)
                    })
                    .then(response => response.json())
                    .then(datos => {return datos})
            },
            accederHome: function()
            {
                window.location.href = "../inicio/home.html";
            },
            accederRegistro: function ()
            {

            }
        }
    }
)

var app = new Vue(
    {
        el: '#loginVue',
        data: {
            nombreUsuario: "",
            contrasenia: "",
        },
        methods: {
            iniciarSesion: function () {
                crearSolicitudInicioSesion({
                        nombreUsuario : this.nombreUsuario,
                        contrasenia : this.contrasenia
                })
            },
        }
    }
)

function crearSolicitudInicioSesion(unaSolicitud)
{
    fetch("http://localhost:8080/usuarios/autenticar",
        {
            method: "POST",
            headers:
                {
                    'Content-Type': 'application/json'
                },
            body: JSON.stringify(unaSolicitud)
        })
        .then(response => response.json())
        .then(datos => {
            localStorage.setItem("IDSESION", datos.idSesion)
            if(datos.idSesion == "-1")
                alert("Usuario o contraseña invalido");
        })
}

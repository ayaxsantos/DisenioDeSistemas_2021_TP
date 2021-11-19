var estado = 0;

var app = new Vue(
    {
        el: '#loginVue',
        data: {
            nombreUsuario: "",
            contrasenia: ""
        },
        methods: {
            iniciarSesion: function () {
                crearSolicitudInicioSesion({
                        nombreUsuario : this.nombreUsuario,
                        contrasenia : this.contrasenia
                })
            }
        }
    }
)

function crearSolicitudInicioSesion(unaSolicitud)
{
 /* Con DOM...

    var unaSolicitudPri = {
        nombreUsuario : document.getElementById("nombreUsuario").value,
        contrasenia : document.getElementById("contrasenia").value
    };

 */
    fetch("http://localhost:8080/usuarios/autenticar",
        {
            method: "POST",
            headers:
                {
                    'Content-Type': 'application/json'
                },
            body: JSON.stringify(unaSolicitud)
        })
        .then(response => {
            if(response.status >= 400)
            {
                alert("USUARIO INEXISTENTE O CONTRASEÑA INCORRECTA!!");
            }
            else
            {
                alert("USUARIO CORRECTO!!");
                console.log(response.status);
            }
        })
    estado = response.status;
}

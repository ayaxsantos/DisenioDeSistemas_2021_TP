const idUsuario = localStorage.getItem('idSesion');
const idAdmin = localStorage.getItem('idAdmin');
const idVol = localStorage.getItem('idVoluntario');

if(idUsuario !== null || idAdmin !== null || idVol !== null){
document.getElementById("botonIniciarSesion").style.display = "none";
document.getElementById("botonRegistrarse").style.display = "none";
document.getElementById("elementoCerrarSesion").style.display = "block";
}

function redireccionamiento(input){
    if(idUsuario !== null){
        location.href=input
    } else {
        location.href="../registrarPersona/registrarPersona.html"
    }
}

/*TODO cerrar sesion, mandadole a la app para que sepa que ese sesionID ya no sirve*/
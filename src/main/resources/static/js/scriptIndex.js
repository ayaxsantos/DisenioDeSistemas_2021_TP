//TODO: Actualizar los enlaces a la version deploy del cliente pesado!

const idUsuario = localStorage.getItem('idSesion');
const idAdmin = localStorage.getItem('idAdmin');
const idVol = localStorage.getItem('idVoluntario');

if(idUsuario || idAdmin || idVol){
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

function cerrarSesion()
{
    appCerrarSesionVue.cerrarSesion();
    localStorage.removeItem('idSesion');
    localStorage.removeItem('idAdmin');
    localStorage.removeItem('idVoluntario');
    location.href = "../inicio/home.html"
}

function desconectar(auth) {
    fetch('http://localhost:8080/usuarios/desconectar',
        {headers: {"Authorization": auth}}).then(response => {
        if (response.status !== 200) alert("Algo salio mal!!")
    })
}

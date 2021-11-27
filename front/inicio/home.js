const sesion = localStorage.getItem('sesionID');
if(sesion !== null){
document.getElementById("botonIniciarSesion").innerHTML = "Cerrar Sesión";
document.getElementById("botonRegistrarse").style.display = "none";
}
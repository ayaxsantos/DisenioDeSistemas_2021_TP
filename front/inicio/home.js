const sesion = localStorage.getItem('sesionID');
if(sesion !== null){
document.getElementById("botonIniciarSesion").style.display = "none";
document.getElementById("botonRegistrarse").style.display = "none";
document.getElementById("elementoCerrarSesion").style.display = "block";
}
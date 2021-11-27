function realizarSolicitud()
{
    let unaSolicitud = {
        nombreUsuario: document.getElementById("nombreUsuario").value,
        contrasenia: document.getElementById("contrasenia").value
    }
    fetch("./autenticar",
    {
            method: "POST",
            headers:
            {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(unaSolicitud)
        }).then(response => response.json())
        .then(datos => {
            localStorage.setItem("IDSESION", datos.idSesion)
            if(datos.idSesion == "-1")
                alert("Usuario o contraseña invalido");
            else alert("Usuario OK");
        });
}

function registro()
{

}

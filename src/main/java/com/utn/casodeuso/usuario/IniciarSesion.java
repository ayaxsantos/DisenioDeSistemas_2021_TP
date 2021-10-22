package com.utn.casodeuso.usuario;

import com.utn.dominio.Usuarios;
import org.springframework.stereotype.Component;
import com.utn.dominio.excepcion.CredencialesInvalidasException;

@Component
public class IniciarSesion {

    private final Usuarios usuarios;

    public IniciarSesion(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public void ejecutar(String nombreUsuario, String contraseña) {
        usuarios.obtenerPorNombreUsuario(nombreUsuario)
                .orElseThrow(CredencialesInvalidasException::new)
                .iniciarSesion(nombreUsuario, contraseña);
    }
}
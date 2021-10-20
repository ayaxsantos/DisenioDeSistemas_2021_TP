package com.utn.casodeuso.usuario;

import com.utn.dominio.Usuarios;
import org.springframework.stereotype.Component;
import com.utn.dominio.excepcion.CredencialesInvalidasException;

@Component
public class CerrarSesion {

    private final Usuarios usuarios;

    public CerrarSesion(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public void ejecutar(String nombreUsuario) {
        usuarios.obtenerPorNombreUsuario(nombreUsuario)
            .orElseThrow(CredencialesInvalidasException::new)
            .cerrarSesion();
    }

}
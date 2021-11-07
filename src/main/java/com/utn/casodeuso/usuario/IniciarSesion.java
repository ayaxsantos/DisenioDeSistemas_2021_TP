package com.utn.casodeuso.usuario;

import com.utn.dominio.Usuarios;
import com.utn.dominio.excepcion.UsuarioNoEncontradoException;

import javax.persistence.NoResultException;

public class IniciarSesion {

    private final Usuarios usuarios;

    public IniciarSesion(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public void ejecutar(String nombreUsuario, String contraseña) {
        try
        {
            usuarios.obtenerPorNombreUsuario(nombreUsuario)
                    .iniciarSesion(nombreUsuario, contraseña);
        }
        catch(NoResultException e)
        {
            throw new UsuarioNoEncontradoException();
        }
    }
}
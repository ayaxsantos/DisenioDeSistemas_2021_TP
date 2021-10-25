package com.utn.casodeuso.usuario;

import com.utn.dominio.Usuarios;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.excepcion.UsuarioYaRegistradoException;
import com.utn.dominio.persona.Contacto;
import com.utn.dominio.persona.Persona;

import javax.persistence.NoResultException;

public class Registrar
{
    private final Usuarios usuarios;

    public Registrar(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public void ejecutar(String nombrePersona, String apellidoPerson, String usuario, String contraseña, String correoElectronico, String telefono){
        try{
            usuarios.obtenerPorNombreUsuario(usuario);
            throw new UsuarioYaRegistradoException();
        }
        catch (NoResultException e){
            Usuario unUsuario = new Usuario(usuario,contraseña);
            Contacto unContacto = new Contacto(nombrePersona, apellidoPerson, telefono, correoElectronico);
            Persona unaPersona = new Persona(unContacto, null, null, null, null, unUsuario, null);

            usuarios.guardar(unUsuario);
        }
    }
}

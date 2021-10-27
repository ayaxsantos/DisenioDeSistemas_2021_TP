package com.utn.casodeuso.usuario;

import com.utn.dominio.Organizaciones;
import com.utn.dominio.Personas;
import com.utn.dominio.Usuarios;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.excepcion.UsuarioYaRegistradoException;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.persona.Contacto;
import com.utn.dominio.persona.Persona;

import javax.persistence.NoResultException;

public class Registrar
{
    private final Usuarios usuarios;
    private final Organizaciones organizaciones;
    private final Personas personas;

    public Registrar(Usuarios usuarios, Organizaciones organizaciones, Personas personas) {
        this.usuarios = usuarios;
        this.organizaciones = organizaciones;
        this.personas = personas;
    }

    public void ejecutar(String nombrePersona, String apellidoPerson, String usuario, String contraseña, String correoElectronico, String telefono, String nombreOrganizacion){
        try
        {
            usuarios.obtenerPorNombreUsuario(usuario);
            throw new UsuarioYaRegistradoException();
        }
        catch (NoResultException e){
            Organizacion organizacion = organizaciones.obtenerPorNombre(nombreOrganizacion);
            Usuario unUsuario = new Usuario(usuario,contraseña);
            Contacto unContacto = new Contacto(nombrePersona, apellidoPerson, telefono, correoElectronico);
            Persona unaPersona = new Persona(unContacto, null, null, null, null, unUsuario, null);
            
            unUsuario.añadirOrganizacion(organizacion);
            
            personas.guardar(unaPersona);
        }
    }
}

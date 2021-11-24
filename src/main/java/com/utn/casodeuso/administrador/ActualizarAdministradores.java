package com.utn.casodeuso.administrador;

import com.utn.dominio.Administradores;
import com.utn.dominio.Organizaciones;
import com.utn.dominio.Usuarios;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.organizacion.Administrador;
import com.utn.dominio.organizacion.Organizacion;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ActualizarAdministradores extends AccederAdministrador
{

    private Usuarios usuarios;

    public ActualizarAdministradores(Administradores unosAdministradores, Organizaciones unasOrganizaciones, Usuarios usuarios) {
        super(unosAdministradores, unasOrganizaciones);
        this.usuarios = usuarios;
    }

    public void ejecutar(String nombreUsuario, String nombreOrganizacion, List<String> usuariosAdministradores)
    {
        Organizacion unaOrganizacion = this.ejecutar(nombreUsuario,nombreOrganizacion);
        List<Administrador> unosAdministradores = new ArrayList<>();

        usuariosAdministradores.forEach(unAdm -> unosAdministradores.add(this.buscardAdmin(unaOrganizacion,unAdm)));

        List<Administrador> administradoresActuales = unaOrganizacion.getAdministradores();
        unosAdministradores.removeAll(administradoresActuales);
        unosAdministradores.forEach(unAdm -> unaOrganizacion.añadirAdministrador(unAdm));
        organizaciones.guardar(unaOrganizacion);
    }

    public Administrador buscardAdmin(Organizacion unaOrganizacion, String userAdmin)
    {
        try
        {
            return administradores.obtenerPorNombreUsuario(userAdmin);
        }
        catch(NoResultException e){
            Usuario unUsuario = usuarios.obtenerPorNombreUsuario(userAdmin);
            return new Administrador(unUsuario,unaOrganizacion);
        }
    }
}

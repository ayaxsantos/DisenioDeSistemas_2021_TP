package com.utn.casodeuso.administrador;

import com.utn.dominio.Administradores;
import com.utn.dominio.Organizaciones;
import com.utn.dominio.excepcion.UsuarioNoEncontradoException;
import com.utn.dominio.excepcion.UsuarioNoEsAdministradorException;
import com.utn.dominio.organizacion.Administrador;
import com.utn.dominio.organizacion.Organizacion;

import java.util.List;

public class AccederAdministrador
{
    private final Administradores administradores;
    private final Organizaciones organizaciones;

    public AccederAdministrador(Administradores unosAdministradores, Organizaciones unasOrganizaciones)
    {
        this.administradores = unosAdministradores;
        this.organizaciones = unasOrganizaciones;
    }

    public Organizacion ejecutar(String nombreUsuario, String nombreOrganizacion)
    {
        Organizacion unaOrganizacion = organizaciones.obtenerPorNombre(nombreOrganizacion);
        List<Administrador> unosAdm = unaOrganizacion.getAdministradores();

        Administrador unAdministrador = unosAdm.stream().filter(
                admin -> admin.getUsuario().nombreUsuario().equals(nombreUsuario)
        ).findFirst().orElseThrow(UsuarioNoEsAdministradorException::new);

        return unaOrganizacion;
    }
}

package com.utn.casodeuso.administrador;

import com.utn.dominio.Administradores;
import com.utn.dominio.Organizaciones;
import com.utn.dominio.excepcion.NoEsAdministradorDeLaOrganizacionException;
import com.utn.dominio.organizacion.Administrador;
import com.utn.dominio.organizacion.Organizacion;

public class AccederAdministrador
{
    protected final Administradores administradores;
    protected final Organizaciones organizaciones;

    public AccederAdministrador(Administradores unosAdministradores, Organizaciones unasOrganizaciones)
    {
        this.administradores = unosAdministradores;
        this.organizaciones = unasOrganizaciones;
    }

    public Organizacion ejecutar(String nombreUsuario, String nombreOrganizacion)
    {
        Administrador unAdministrador = administradores.obtenerPorNombreUsuario(nombreUsuario);
        Organizacion unaOrganizacion = organizaciones.obtenerPorNombre(nombreOrganizacion);
        if(unaOrganizacion.esAdministrador(unAdministrador))
        {
            return unaOrganizacion;
        }
        else throw new NoEsAdministradorDeLaOrganizacionException();
    }
}

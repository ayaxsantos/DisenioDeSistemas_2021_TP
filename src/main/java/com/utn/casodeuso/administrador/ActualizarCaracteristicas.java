package com.utn.casodeuso.administrador;

import com.utn.dominio.Administradores;
import com.utn.dominio.Organizaciones;
import com.utn.dominio.organizacion.Organizacion;

import java.util.List;

public class ActualizarCaracteristicas extends AccederAdministrador
{
    public ActualizarCaracteristicas(Administradores unosAdministradores, Organizaciones unasOrganizaciones) {
        super(unosAdministradores, unasOrganizaciones);
    }

    public void ejecutar(String nombreUsuario, String nombreOrganizacion, List<String> unasCaracteristicas)
    {
        Organizacion unaOrganizacion = this.ejecutar(nombreUsuario,nombreOrganizacion);
        unaOrganizacion.setCaracteristicas(unasCaracteristicas);
        organizaciones.guardar(unaOrganizacion);
    }
}

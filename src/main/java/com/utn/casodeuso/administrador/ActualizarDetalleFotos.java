package com.utn.casodeuso.administrador;

import com.utn.dominio.Administradores;
import com.utn.dominio.Organizaciones;
import com.utn.dominio.foto.CalidadFoto;
import com.utn.dominio.foto.TamañoFoto;
import com.utn.dominio.organizacion.Organizacion;

public class ActualizarDetalleFotos extends AccederAdministrador
{

    public ActualizarDetalleFotos(Administradores unosAdministradores, Organizaciones unasOrganizaciones) {
        super(unosAdministradores, unasOrganizaciones);
    }

    public void ejecutar(String nombreUsuario, String nombreOrganizacion, TamañoFoto unTamaño, CalidadFoto unaCalidad)
    {
        Organizacion unaOrganizacion = this.ejecutar(nombreUsuario,nombreOrganizacion);
        unaOrganizacion.tamañoFoto(unTamaño);
        unaOrganizacion.calidadFoto(unaCalidad);
    }
}

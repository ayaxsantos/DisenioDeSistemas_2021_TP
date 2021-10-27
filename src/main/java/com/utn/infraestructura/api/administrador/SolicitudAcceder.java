package com.utn.infraestructura.api.administrador;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitudAcceder
{
    @JsonProperty
    private String nombreUsuario;

    @JsonProperty
    private String nombreOrganizacion;

    public String getNombreUsuario()
    {
        return this.nombreUsuario;
    }

    public String getNombreOrganizacion()
    {
        return this.nombreOrganizacion;
    }

    public void setNombreUsuario(String nombreUsuario)
    {
        this.nombreUsuario = nombreUsuario;
    }

    public void setNombreOrganizacion(String nombreOrganizacion)
    {
        this.nombreOrganizacion = nombreOrganizacion;
    }
}

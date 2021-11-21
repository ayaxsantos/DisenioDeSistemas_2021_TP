package com.utn.infraestructura.api.administrador;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.organizacion.Organizacion;

public class RespuestaAcceso
{
    @JsonProperty
    private String nombreUsuario;

    @JsonProperty
    private Organizacion unaOrganizacion;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Organizacion getUnaOrganizacion() {
        return unaOrganizacion;
    }

    public void setUnaOrganizacion(Organizacion unaOrganizacion) {
        this.unaOrganizacion = unaOrganizacion;
    }
}

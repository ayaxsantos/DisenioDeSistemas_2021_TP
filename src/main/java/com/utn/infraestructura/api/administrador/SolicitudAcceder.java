package com.utn.infraestructura.api.administrador;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitudAcceder {

    @JsonProperty
    private String nombreOrganizacion;

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
    }
}

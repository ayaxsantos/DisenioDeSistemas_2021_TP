package com.utn.infraestructura.api.administrador;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RespuestaOrganizaciones
{
    @JsonProperty
    private List<String> nombresOrganizaciones;

    public List<String> getNombresOrganizaciones() {
        return nombresOrganizaciones;
    }

    public void setNombresOrganizaciones(List<String> nombresOrganizaciones) {
        this.nombresOrganizaciones = nombresOrganizaciones;
    }
}

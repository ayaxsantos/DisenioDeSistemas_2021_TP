package com.utn.infraestructura.api.persona;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitudQuieroAdoptar {

    @JsonProperty
    private String nombreUsuarioDuenio;

    public String getNombreUsuarioDuenio() {
        return nombreUsuarioDuenio;
    }

    public void setNombreUsuarioDuenio(String nombreUsuarioDuenio) {
        this.nombreUsuarioDuenio = nombreUsuarioDuenio;
    }
}

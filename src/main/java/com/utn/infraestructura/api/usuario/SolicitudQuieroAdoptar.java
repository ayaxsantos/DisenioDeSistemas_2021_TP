package com.utn.infraestructura.api.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitudQuieroAdoptar {

    @JsonProperty
    private String nombreUsuarioAdoptante;

    @JsonProperty
    private String nombreUsuarioDuenio;


    public String getNombreUsuarioAdoptante(){
        return nombreUsuarioAdoptante;
    }

    public String getNombreUsuarioDuenio() {
        return nombreUsuarioDuenio;
    }

    public void setNombreUsuarioAdoptante(String nombreUsuarioAdoptante) {
        this.nombreUsuarioAdoptante = nombreUsuarioAdoptante;
    }

    public void setNombreUsuarioDuenio(String nombreUsuarioDuenio) {
        this.nombreUsuarioDuenio = nombreUsuarioDuenio;
    }
}

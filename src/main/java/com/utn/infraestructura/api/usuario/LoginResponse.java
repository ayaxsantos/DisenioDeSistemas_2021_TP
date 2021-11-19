package com.utn.infraestructura.api.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {

    @JsonProperty
    private String idSesion;

    @JsonProperty
    private boolean codigoEstado;

    public LoginResponse(String idSesion, boolean codigoEstado) {
        this.idSesion = idSesion;
        this.codigoEstado = codigoEstado;
    }

    public String getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(String idSesion) {
        this.idSesion = idSesion;
    }

    public boolean isCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(boolean codigoEstado) {
        this.codigoEstado = codigoEstado;
    }
}

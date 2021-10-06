package com.utn.infraestructura.api.dueño;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitudConfirmarMascotaEncontrada {

    @JsonProperty
    private int documentoRescatista;

    public int documentoRescatista() {
        return this.documentoRescatista;
    }

}
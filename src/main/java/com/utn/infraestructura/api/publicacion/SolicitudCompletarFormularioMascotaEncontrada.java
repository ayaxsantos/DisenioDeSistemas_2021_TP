package com.utn.infraestructura.api.publicacion;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitudCompletarFormularioMascotaEncontrada { //todo faltan algunas cosas q estaban en los wireframes

    @JsonProperty
    private String nombreOrganizacion;

    @JsonProperty
    private Double latitud;

    @JsonProperty
    private Double longitud;

    @JsonProperty
    private String estadoDeLaMascota;

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }


    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public String getEstadoDeLaMascota() {
        return estadoDeLaMascota;
    }

}

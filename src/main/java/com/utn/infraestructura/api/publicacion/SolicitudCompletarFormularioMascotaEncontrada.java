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

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
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

    public void setEstadoDeLaMascota(String estadoDeLaMascota) {
        this.estadoDeLaMascota = estadoDeLaMascota;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}

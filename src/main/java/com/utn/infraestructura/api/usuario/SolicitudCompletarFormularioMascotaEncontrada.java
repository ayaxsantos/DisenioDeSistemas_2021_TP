package com.utn.infraestructura.api.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitudCompletarFormularioMascotaEncontrada { //todo faltan algunas cosas q estaban en los wireframes

    @JsonProperty
    private String nombreUsuario;

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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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

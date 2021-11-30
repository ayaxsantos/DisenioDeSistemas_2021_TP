package com.utn.infraestructura.api.rescatista;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.persona.TipoDocumento;

import java.util.List;

public class SolicitudMascotaEncontradaPublicacion {

    @JsonProperty
    private String nombreOrganizacion;

    @JsonProperty
    private Integer numeroDocumentoRescatista;

    @JsonProperty
    private TipoDocumento tipoDocumentoRescatista;

    @JsonProperty
    private String estado;

    @JsonProperty
    private Double latitud;

    @JsonProperty
    private Double longitud;

    @JsonProperty
    private List<String> fotos;

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
    }

    public Integer getNumeroDocumentoRescatista() {
        return numeroDocumentoRescatista;
    }

    public void setNumeroDocumentoRescatista(Integer numeroDocumentoRescatista) {
        this.numeroDocumentoRescatista = numeroDocumentoRescatista;
    }

    public TipoDocumento getTipoDocumentoRescatista() {
        return tipoDocumentoRescatista;
    }

    public void setTipoDocumentoRescatista(TipoDocumento tipoDocumentoRescatista) {
        this.tipoDocumentoRescatista = tipoDocumentoRescatista;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }
}

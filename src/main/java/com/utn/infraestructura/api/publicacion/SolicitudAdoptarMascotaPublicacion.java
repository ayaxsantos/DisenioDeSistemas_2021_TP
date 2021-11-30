package com.utn.infraestructura.api.publicacion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.persona.TipoDocumento;

public class SolicitudAdoptarMascotaPublicacion {

    @JsonProperty
    private int numeroDocDuenio;

    @JsonProperty
    private TipoDocumento tipoDocumentoDuenio;

    @JsonProperty
    private String nombreMascota;

    @JsonProperty
    private int numeroDocAdoptante;

    @JsonProperty
    private TipoDocumento tipoDocumentoAdoptante;

    public int getNumeroDocDuenio() {
        return numeroDocDuenio;
    }

    public void setNumeroDocDuenio(int numeroDocDuenio) {
        this.numeroDocDuenio = numeroDocDuenio;
    }

    public TipoDocumento getTipoDocumentoDuenio() {
        return tipoDocumentoDuenio;
    }

    public void setTipoDocumentoDuenio(TipoDocumento tipoDocumentoDuenio) {
        this.tipoDocumentoDuenio = tipoDocumentoDuenio;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getNumeroDocAdoptante() {
        return numeroDocAdoptante;
    }

    public void setNumeroDocAdoptante(int numeroDocAdoptante) {
        this.numeroDocAdoptante = numeroDocAdoptante;
    }

    public TipoDocumento getTipoDocumentoAdoptante() {
        return tipoDocumentoAdoptante;
    }

    public void setTipoDocumentoAdoptante(TipoDocumento tipoDocumentoAdoptante) {
        this.tipoDocumentoAdoptante = tipoDocumentoAdoptante;
    }
}

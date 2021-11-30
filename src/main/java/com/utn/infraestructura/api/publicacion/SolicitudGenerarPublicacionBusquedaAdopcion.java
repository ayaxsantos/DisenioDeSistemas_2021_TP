package com.utn.infraestructura.api.publicacion;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.persona.TipoDocumento;

public class SolicitudGenerarPublicacionBusquedaAdopcion {

    @JsonProperty
    private String nombreOrganizacion;

    @JsonProperty
    private List<String> comodidades;

    @JsonProperty
    private Integer numeroDocumentoAdoptante;

    @JsonProperty
    private TipoDocumento tipoDocumentoAdoptante;

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
    }

    public List<String> getComodidades() {
        return comodidades;
    }

    public void setComodidades(List<String> comodidades) {
        this.comodidades = comodidades;
    }

    public Integer getNumeroDocumentoAdoptante() {
        return numeroDocumentoAdoptante;
    }

    public void setNumeroDocumentoAdoptante(Integer numeroDocumentoAdoptante) {
        this.numeroDocumentoAdoptante = numeroDocumentoAdoptante;
    }

    public TipoDocumento getTipoDocumentoAdoptante() {
        return tipoDocumentoAdoptante;
    }

    public void setTipoDocumentoAdoptante(TipoDocumento tipoDocumentoAdoptante) {
        this.tipoDocumentoAdoptante = tipoDocumentoAdoptante;
    }
}

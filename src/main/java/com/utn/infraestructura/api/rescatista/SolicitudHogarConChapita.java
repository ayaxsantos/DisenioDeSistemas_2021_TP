package com.utn.infraestructura.api.rescatista;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.persona.TipoDocumento;

public class SolicitudHogarConChapita {

    @JsonProperty
    private int numDocRescatista;

    @JsonProperty
    private TipoDocumento tipoDocRescatista;

    @JsonProperty
    private int idMascota;

    public int getNumDocRescatista() {
        return numDocRescatista;
    }

    public void setNumDocRescatista(int numDocRescatista) {
        this.numDocRescatista = numDocRescatista;
    }

    public TipoDocumento getTipoDocRescatista() {
        return tipoDocRescatista;
    }

    public void setTipoDocRescatista(TipoDocumento tipoDocRescatista) {
        this.tipoDocRescatista = tipoDocRescatista;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

}

package com.utn.infraestructura.api.publicacion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.persona.TipoDocumento;

import java.util.HashMap;
import java.util.Map;

public class SolicitudPublicarMascotaEnAdopcion {

    @JsonProperty
    private TipoDocumento tipoDocumento;

    @JsonProperty
    private int numeroDocumento;

    @JsonProperty
    private String nombreMascota;

    @JsonProperty
    private HashMap<String, String> preguntasRespuestas;

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public HashMap<String, String> getPreguntasRespuestas() {
        return preguntasRespuestas;
    }

    public void setPreguntasRespuestas(HashMap<String, String> preguntasRespuestas) {
        this.preguntasRespuestas = preguntasRespuestas;
    }
}

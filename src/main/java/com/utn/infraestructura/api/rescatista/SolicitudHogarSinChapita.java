package com.utn.infraestructura.api.rescatista;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.animal.Animal;
import com.utn.dominio.animal.Tamaño;
import com.utn.dominio.persona.TipoDocumento;

public class SolicitudHogarSinChapita {
    @JsonProperty
    private Animal animal;

    @JsonProperty
    private Tamaño tamanio;

    @JsonProperty
    private int numDocRescatista;

    @JsonProperty
    private TipoDocumento tipoDocRescatista;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Tamaño getTamanio() {
        return tamanio;
    }

    public void setTamanio(Tamaño tamanio) {
        this.tamanio = tamanio;
    }

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
}

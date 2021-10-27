package com.utn.infraestructura.api.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.animal.Tamaño;
import com.utn.dominio.hogar.criterios.TipoAnimal;

import java.util.List;

public class SolicitudBuscarHogarTransito { //todo preguntar cris caso de uso si cambiar o no caMBIAR
    //tomamos como que hay una validacion previa de si esta registrada o no la mascota

    @JsonProperty
    private int idMascota;

    @JsonProperty
    private String nombreUsuario;

    @JsonProperty
    private TipoAnimal tipoAnimal;

    @JsonProperty
    private Tamaño tamaño;

    @JsonProperty
    private List<String> caracteristicas;

    @JsonProperty
    private int radioDeCercania;

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setTamaño(Tamaño tamaño){this.tamaño = tamaño;}

    public void setCaracteristicas(List<String> caracteristicas){this.caracteristicas = caracteristicas;}

    public void setRadioDeCercania(int radioDeCercania) {
        this.radioDeCercania = radioDeCercania;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public Tamaño getTamaño() {return tamaño;}

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public int getIdMascota(){return idMascota;}
}

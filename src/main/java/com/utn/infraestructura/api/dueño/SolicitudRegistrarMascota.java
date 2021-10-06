package com.utn.infraestructura.api.dueño;

import java.util.Map;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitudRegistrarMascota {

    @JsonProperty
    private int idMascota;

    @JsonProperty
    private String nombre;

    @JsonProperty
    private String tipoAnimal;

    @JsonProperty
    private String apodo;

    @JsonProperty
    private int edad;

    @JsonProperty
    private String sexo;

    @JsonProperty
    private String tamaño;

    @JsonProperty
    private String descripcionFisica;

    @JsonProperty
    private List<String> fotos;

    @JsonProperty
    private Map<String, String> caracteristicas;

    public int idMascota() {
        return this.idMascota;
    }

    public String nombre() {
        return this.nombre;
    }

    public String tipoAnimal() {
        return this.tipoAnimal;
    }

    public String apodo() {
        return this.apodo;
    }

    public int edad() {
        return this.edad;
    }

    public String sexo() {
        return this.sexo;
    }

    public String tamaño() {
        return this.tamaño;
    }

    public String descripcionFisica() {
        return this.descripcionFisica;
    }

    public List<String> fotos() {
        return this.fotos;
    }

    public Map<String, String> caracteristicas() {
        return this.caracteristicas;
    }

}
package com.utn.infraestructura.api.dueño;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolicitudRegistrarMascota {

    @JsonProperty
    private String organizacion;

    @JsonProperty
    private int numeroDocumento;

    @JsonProperty
    private String tipoDocumento;

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
    private String tamanio;

    @JsonProperty
    private String descripcionFisica;

    @JsonProperty
    private List<String> fotos;

    @JsonProperty
    private HashMap<String, String> caracteristicas;

    @JsonProperty
    private List<String> caracteristicasPreguntas;

    @JsonProperty
    private List<String> caracteristicasRespuestas;

    public int numeroDocumento() {
        return this.numeroDocumento;
    }

    public String tipoDocumento() {
        return this.tipoDocumento;
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
        return this.tamanio;
    }

    public String descripcionFisica() {
        return this.descripcionFisica;
    }

    public List<String> fotos() {
        return this.fotos;
    }

    public List<String> caracteristicasPreguntas() {
        return this.caracteristicasPreguntas;
    }

    public List<String> caracteristicasRespuestas() {
        return this.caracteristicasRespuestas;
    }

    public HashMap<String, String> caracteristicas() {
        return this.caracteristicas;
    }

    public String organizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }
}
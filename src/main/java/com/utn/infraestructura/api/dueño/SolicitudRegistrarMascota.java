package com.utn.infraestructura.api.dueño;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.persona.TipoDocumento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolicitudRegistrarMascota {

    @JsonProperty
    private String organizacion;

    @JsonProperty
    private int numeroDocumento;

    @JsonProperty
    private TipoDocumento tipoDocumento;

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

    public int numeroDocumento() {
        return this.numeroDocumento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
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
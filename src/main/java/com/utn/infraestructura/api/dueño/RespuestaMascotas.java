package com.utn.infraestructura.api.dueño;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.organizacion.Organizacion;

import java.util.Map;

public class RespuestaMascotas {

    @JsonProperty
    private String nombre;

    @JsonProperty
    private String foto;

    @JsonProperty
    private String organizacion;

    public RespuestaMascotas(String nombre, String foto, String organizacion) {
        this.nombre = nombre;
        this.foto = foto;
        this.organizacion = organizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }
}

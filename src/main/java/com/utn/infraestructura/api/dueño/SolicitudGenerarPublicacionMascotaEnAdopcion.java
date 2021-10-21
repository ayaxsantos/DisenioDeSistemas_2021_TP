package com.utn.infraestructura.api.dueño;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SolicitudGenerarPublicacionMascotaEnAdopcion {

    /*
    @JsonProperty
    private int idMascota;

    @JsonProperty
    private int idOrganizacion;*/

    @JsonProperty
    private String nombreMascota;

    @JsonProperty
    private String nombreOrganizacion;

    @JsonProperty
    private List<String> respuestasMascota;


    //TODO eliminar si no hace falta
    /*public int idMascota() {
        return this.idMascota;
    }

    public int idOrganizacion() {
        return this.idOrganizacion;
    }*/

    public String nombreOrganizacion() {
        return this.nombreOrganizacion;
    }
    public String nombreMascota(){return this.nombreMascota;}

    public List<String> respuestasMascota() {
        return this.respuestasMascota;
    }

}
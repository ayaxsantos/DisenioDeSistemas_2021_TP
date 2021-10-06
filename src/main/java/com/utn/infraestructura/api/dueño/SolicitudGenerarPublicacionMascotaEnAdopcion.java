package com.utn.infraestructura.api.dueño;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SolicitudGenerarPublicacionMascotaEnAdopcion {

    @JsonProperty
    private int idMascota;

    @JsonProperty
    private int idOrganizacion;

    @JsonProperty
    private List<String> respuestasMascota;

    public int idMascota() {
        return this.idMascota;
    }

    public int idOrganizacion() {
        return this.idOrganizacion;
    }

    public List<String> respuestasMascota() {
        return this.respuestasMascota;
    }

}
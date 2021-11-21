package com.utn.infraestructura.api.publicacion;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitudGenerarPublicacionBusquedaAdopcion {

    @JsonProperty
    private String nombreOrganizacion;

    @JsonProperty
    private List<String> comodidades;

    public String getNombreOrganizacion() {

        return nombreOrganizacion;
    }

    public List<String> getComodidades(){
        return comodidades;
    }

    public void setNombreUsuarioDuenio(String nombreOrganizacion) {

        this.nombreOrganizacion = nombreOrganizacion;
    }
}

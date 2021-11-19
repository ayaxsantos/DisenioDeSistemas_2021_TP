package com.utn.infraestructura.api.publicacion;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitudGenerarPublicacionBusquedaAdopcion {

    @JsonProperty
    private String nombreUsuario;

    @JsonProperty
    private String nombreOrganizacion;

    @JsonProperty
    private List<String> comodidades;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreOrganizacion() {

        return nombreOrganizacion;
    }

    public List<String> getComodidades(){
        return comodidades;
    }

    public void setNombreUsuarioAdoptante(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setNombreUsuarioDuenio(String nombreOrganizacion) {

        this.nombreOrganizacion = nombreOrganizacion;
    }
}

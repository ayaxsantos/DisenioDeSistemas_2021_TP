package com.utn.infraestructura.api.administrador;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SolicitudActualizarAdministradores
{
    @JsonProperty
    private List<String> usuariosAdministradores;

    public List<String> getUsuariosAdministradores() {
        return usuariosAdministradores;
    }

    public void setUsuariosAdministradores(List<String> usuariosAdministradores) {
        this.usuariosAdministradores = usuariosAdministradores;
    }
}

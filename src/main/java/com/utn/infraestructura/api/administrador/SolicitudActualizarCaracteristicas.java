package com.utn.infraestructura.api.administrador;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SolicitudActualizarCaracteristicas
{
    @JsonProperty
    private List<String> caracteristicasActualizar;

    public List<String> getCaracteristicasActualizar() {
        return caracteristicasActualizar;
    }

    public void setCaracteristicasActualizar(List<String> caracteristicasActualizar) {
        this.caracteristicasActualizar = caracteristicasActualizar;
    }
}

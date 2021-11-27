package com.utn.infraestructura.api.administrador;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.organizacion.CalidadFoto;
import com.utn.dominio.organizacion.TamañoFoto;

public class SolicitudActualizarDetalleFotos
{
    @JsonProperty
    private CalidadFoto calidadFoto;

    @JsonProperty
    private TamañoFoto tamanioFoto;

    public CalidadFoto getCalidadFoto() {
        return calidadFoto;
    }

    public void setCalidadFoto(CalidadFoto calidadFoto) {
        this.calidadFoto = calidadFoto;
    }

    public TamañoFoto getTamanioFoto() {
        return tamanioFoto;
    }

    public void setTamanioFoto(TamañoFoto tamanioFoto) {
        this.tamanioFoto = tamanioFoto;
    }
}

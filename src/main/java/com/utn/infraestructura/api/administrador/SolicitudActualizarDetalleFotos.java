package com.utn.infraestructura.api.administrador;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.foto.CalidadFoto;
import com.utn.dominio.foto.TamañoFoto;

public class SolicitudActualizarDetalleFotos
{
    @JsonProperty
    private CalidadFoto calidadFoto;

    @JsonProperty
    private TamañoFoto tamañoFoto;

    public CalidadFoto getCalidadFoto() {
        return calidadFoto;
    }

    public void setCalidadFoto(CalidadFoto calidadFoto) {
        this.calidadFoto = calidadFoto;
    }

    public TamañoFoto getTamañoFoto() {
        return tamañoFoto;
    }

    public void setTamañoFoto(TamañoFoto tamañoFoto) {
        this.tamañoFoto = tamañoFoto;
    }
}

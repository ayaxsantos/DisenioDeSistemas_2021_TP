package com.utn.dominio.foto;

import java.util.Arrays;
import com.utn.dominio.excepcion.CalidadFotoNoValidaException;

public enum CalidadFoto {

    BAJA("Baja"),
    MEDIA("Media"),
    ALTA("Alta");

    CalidadFoto(String valor) {
        this.valor = valor;
    }

    private final String valor;

    public static CalidadFoto obtener(String valor) {
        return Arrays.stream(CalidadFoto.values())
            .filter(calidadFoto -> calidadFoto.coincide(valor))
            .findFirst()
            .orElseThrow(CalidadFotoNoValidaException::new);
    }

    public boolean coincide(String valor) {
        return this.valor.equals(valor);
    }

}
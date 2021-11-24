package com.utn.dominio.foto;

import com.utn.dominio.excepcion.CalidadFotoNoValidaException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum TamañoFoto {

    CHICA("Chica"),
    NORMAL("Normal"),
    GRANDE("Grande");

    TamañoFoto(String valor) {
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

    public Integer ancho(){
        switch (this){
            case CHICA: return 540;
            case NORMAL: return 720;
            case GRANDE: return 1080;
            default: return null; // TODO Arrojar una excepción?
        }
    }

    public Integer alto(){
        switch (this){
            case CHICA: return 960;
            case NORMAL: return 1280;
            case GRANDE: return 1920;
            default: return null; // TODO Arrojar una excepción?
        }
    }

    public static List<String> getDescripciones() {
        return Arrays.stream(TamañoFoto.values())
                .map(unTamaño -> unTamaño.valor)
                .collect(Collectors.toList());
    }
}

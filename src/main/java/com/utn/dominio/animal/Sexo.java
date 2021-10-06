package com.utn.dominio.animal;

import java.util.Arrays;

public enum Sexo {

    MACHO("Macho"),
    HEMBRA("Hembra");

    Sexo(String descripcion){
        this.descripcion = descripcion;
    }

    private final String descripcion;

    public static Sexo buscar(String descripcion) {
        return Arrays.stream(Sexo.values())
            .filter(sexo -> sexo.descripcion.equals(descripcion))
            .findFirst()
            .orElseThrow(RuntimeException::new);
    }

}
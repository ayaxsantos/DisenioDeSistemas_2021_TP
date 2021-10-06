package com.utn.dominio.animal;

import java.util.Arrays;

public enum Tamaño {

    CHICO("Chico"),
    MEDIANO("Mediano"),
    GRANDE("Grande");

    private final String descripcion;

    Tamaño(String descripcion){
        this.descripcion = descripcion;
    }

    public static Tamaño buscar(String descripcion) {
        return Arrays.stream(Tamaño.values())
            .filter(tamaño -> tamaño.descripcion.equals(descripcion))
            .findFirst()
            .orElseThrow(RuntimeException::new);
    }

}
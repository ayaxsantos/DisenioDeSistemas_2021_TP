package com.utn.infraestructura.persistencia.tamaño;

public enum JpaTamaño {
    CHICO("Chico"),
    MEDIANO("Mediano"),
    GRANDE("Grande");

    private final String descripcion;

    JpaTamaño(String descripcion){
        this.descripcion = descripcion;
    }
}

package com.utn.infraestructura.persistencia.sexo;

public enum JpaSexo {
    MACHO("Macho"),
    HEMBRA("Hembra");

    private final String descripcion;

    JpaSexo(String descripcion) {
        this.descripcion = descripcion;
    }
}

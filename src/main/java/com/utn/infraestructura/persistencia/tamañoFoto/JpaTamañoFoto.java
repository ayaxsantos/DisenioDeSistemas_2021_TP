package com.utn.infraestructura.persistencia.tamañoFoto;

public enum JpaTamañoFoto {
    CHICA("Chica"),
    NORMAL("Normal"),
    GRANDE("Grande");

    private final String descripcion;

    JpaTamañoFoto(String descripcion) {
        this.descripcion = descripcion;
    }
}

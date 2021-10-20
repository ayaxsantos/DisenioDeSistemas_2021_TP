package com.utn.infraestructura.persistencia.calidadFoto;

public enum JpaCalidadFoto {
    BAJA("Baja"),
    MEDIA("Media"),
    ALTA("Alta");

    private final String descripcion;

    JpaCalidadFoto(String descripcion) {
        this.descripcion = descripcion;
    }
}

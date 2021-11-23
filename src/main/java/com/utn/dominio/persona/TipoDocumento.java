package com.utn.dominio.persona;

import java.util.Arrays;

public enum TipoDocumento {

    DNI("DNI"),
    LICENCIA("LICENCIA"),
    PASAPORTE("PASAPORTE");

    TipoDocumento(String descripcion){
        this.descripcion = descripcion;
    }

    private final String descripcion;

    public static TipoDocumento buscar(String descripcion) {
        return Arrays.stream(TipoDocumento.values())
            .filter(tipoDocumento -> tipoDocumento.descripcion.equals(descripcion))
            .findFirst()
            .orElseThrow(RuntimeException::new);
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}

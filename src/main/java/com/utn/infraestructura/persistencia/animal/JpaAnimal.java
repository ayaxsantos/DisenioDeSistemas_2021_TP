package com.utn.infraestructura.persistencia.animal;

public enum JpaAnimal {
    GATO("Gato"),
    PERRO("Perro");

    private final String descripcion;

    JpaAnimal(String descripcion) {
        this.descripcion = descripcion;
    }
}

package com.utn.dominio.animal;

import java.util.Arrays;

public enum Animal {

    GATO("Gato"),
    PERRO("Perro");

    Animal(String descripcion){
        this.descripcion = descripcion;
    }

    private final String descripcion;

    public static Animal buscar(String descripcion) {
        return Arrays.stream(Animal.values())
            .filter(animal -> animal.descripcion.equals(descripcion))
            .findFirst()
            .orElseThrow(RuntimeException::new);
    }

}
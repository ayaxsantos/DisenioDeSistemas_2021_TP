package com.utn.dominio.animal;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Mascota {

    private final int id;
    private final String nombre;
    private final Animal animal;
    private final String apodo;
    private final int edad;
    private final Sexo sexo;
    private final Tamaño tamaño;
    private final String descripcionFisica;
    private final List<String> fotosNormalizadas = new ArrayList<>();
    private final Map<String, String> caracteristicas = new HashMap<>();

    public Mascota(
        int id, String nombre, Animal animal, String apodo, int edad, Sexo sexo, Tamaño tamaño,
        String descripcionFisica, List<String> fotosNormalizadas,  Map<String, String> caracteristicas){
            this.id = id;
            this.nombre = nombre;
            this.animal = animal;
            this.apodo = apodo;
            this.edad = edad;
            this.sexo = sexo;
            this.tamaño = tamaño;
            this.descripcionFisica = descripcionFisica;
            this.fotosNormalizadas.addAll(fotosNormalizadas);
            this.caracteristicas.putAll(caracteristicas);
    }

    public int id() {
        return this.id;
    }

    public String nombre() {
        return this.nombre;
    }

    public Animal animal() {
        return animal;
    }

    public Map<String,String> caracteristicas() {
        return this.caracteristicas;
    }

    public Tamaño tamaño() {
        return tamaño;
    }

    public Sexo sexo() { return sexo; }
}
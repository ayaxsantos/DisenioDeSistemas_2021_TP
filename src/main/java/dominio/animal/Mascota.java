package dominio.animal;

import dominio.organizacion.Caracteristica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mascota {

    private final int id;
    private final String nombre;
    private final Animal animal;
    private final String apodo;
    private final Integer edad;
    private final Sexo sexo;
    private final Tamaño tamaño;
    private final String descripcionFisica;
    private final List<Foto> fotos = new ArrayList<>();
    private final Map<Caracteristica, String> caracteristicas = new HashMap<>();

    public Mascota(int id, String nombre, Animal animal, String apodo, Integer edad, Sexo sexo, Tamaño tamaño, String descripcionFisica){
        this.id = id;
        this.nombre = nombre;
        this.animal = animal;
        this.apodo = apodo;
        this.edad = edad;
        this.sexo = sexo;
        this.tamaño = tamaño;
        this.descripcionFisica = descripcionFisica;
    }

    public void añadirFoto(Foto unaFoto){
        fotos.add(unaFoto);
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

    public Map<Caracteristica,String> caracteristicas() {
        return this.caracteristicas;
    }

    public Tamaño tamaño() {
        return tamaño;
    }

}
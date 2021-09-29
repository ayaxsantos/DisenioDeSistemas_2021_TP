package dominio.publicacion;

import dominio.animal.Animal;
import dominio.animal.Sexo;
import dominio.animal.Tamaño;

public class Preferencia {

    private final Sexo sexo;
    private final Animal animal;
    private final Tamaño tamaño;

    public Preferencia(Sexo sexo, Animal animal, Tamaño tamaño) {
        this.animal = animal;
        this.sexo = sexo;
        this.tamaño = tamaño;
    }

    public Animal animal() {
        return animal;
    }

    public Sexo sexo() {
        return sexo;
    }

    public Tamaño tamaño() {
        return tamaño;
    }

}
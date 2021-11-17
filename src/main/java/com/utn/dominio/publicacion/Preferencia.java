package com.utn.dominio.publicacion;

import com.utn.dominio.EntidadPersistente;
import com.utn.dominio.animal.Animal;
import com.utn.dominio.animal.Sexo;
import com.utn.dominio.animal.Tamaño;

import javax.persistence.*;

@Entity
@Table(name = "preferencia")
public class Preferencia extends EntidadPersistente {
    
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private Animal animal;

    @Enumerated(EnumType.STRING)
    private Tamaño tamaño;

    public Preferencia(Sexo sexo, Animal animal, Tamaño tamaño) {
        this.animal = animal;
        this.sexo = sexo;
        this.tamaño = tamaño;
    }

    public Preferencia() {

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
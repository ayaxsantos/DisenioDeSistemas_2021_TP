package com.utn.infraestructura.persistencia.preferencia;

import com.utn.infraestructura.persistencia.animal.JpaAnimal;
import com.utn.infraestructura.persistencia.sexo.JpaSexo;
import com.utn.infraestructura.persistencia.tamaño.JpaTamaño;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "preferencia")
public class JpaPreferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private JpaSexo sexo;

    @Enumerated(EnumType.STRING)
    private JpaAnimal animal;

    @Enumerated(EnumType.STRING)
    private JpaTamaño tamaño;

    public JpaPreferencia(Integer id, JpaSexo sexo, JpaAnimal animal, JpaTamaño tamaño) {
        this.id = id;
        this.sexo = sexo;
        this.animal = animal;
        this.tamaño = tamaño;
    }

    public JpaPreferencia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JpaSexo getSexo() {
        return sexo;
    }

    public void setSexo(JpaSexo sexo) {
        this.sexo = sexo;
    }

    public JpaAnimal getAnimal() {
        return animal;
    }

    public void setAnimal(JpaAnimal animal) {
        this.animal = animal;
    }

    public JpaTamaño getTamaño() {
        return tamaño;
    }

    public void setTamaño(JpaTamaño tamaño) {
        this.tamaño = tamaño;
    }
}
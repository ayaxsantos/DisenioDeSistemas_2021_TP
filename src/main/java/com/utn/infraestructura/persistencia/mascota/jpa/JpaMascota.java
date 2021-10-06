package com.utn.infraestructura.persistencia.mascota.jpa;

import com.utn.dominio.animal.Animal;
import com.utn.dominio.animal.Sexo;
import com.utn.dominio.animal.Tamaño;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "mascota")
public class JpaMascota
{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "animal")
    private BigInteger animal;

    @Column(name = "apodo")
    private String apodo;

    @Column(name = "edad")
    private BigInteger edad;

    @Column(name = "descripcion_fisica")
    private String descripcionFisica;

    @Column(name = "id_animal")
    private BigInteger idAnimal;

    @Column(name = "id_sexo")
    private BigInteger idSexo;

    @Column(name = "id_tamaño")
    private BigInteger idTamaño;

    @Column(name = "id_persona")
    private BigInteger idPersona;

    public JpaMascota(BigInteger id, String nombre, BigInteger animal, String apodo, BigInteger edad, String descripcionFisica, BigInteger idAnimal, BigInteger idSexo, BigInteger idTamaño, BigInteger idPersona) {
        this.id = id;
        this.nombre = nombre;
        this.animal = animal;
        this.apodo = apodo;
        this.edad = edad;
        this.descripcionFisica = descripcionFisica;
        this.idAnimal = idAnimal;
        this.idSexo = idSexo;
        this.idTamaño = idTamaño;
        this.idPersona = idPersona;
    }

    //Generar accessors porfa



}
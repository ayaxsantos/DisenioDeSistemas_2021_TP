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

    @Column(name = "descrpicion_fisica")
    private String descripcionFisica;

    @Column(name = "id_animal")
    private BigInteger idAnimal;

    @Column(name = "id_sexo")
    private BigInteger idSexo;

    @Column(name = "id_tamaño")
    private BigInteger idTamaño;

    //Generar accessors porfa

}
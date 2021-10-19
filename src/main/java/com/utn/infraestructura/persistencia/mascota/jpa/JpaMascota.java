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
    private Integer id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "animal")
    private Integer animal;

    @Column(name = "apodo")
    private String apodo;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "descripcion_fisica")
    private String descripcionFisica;

    @Column(name = "id_animal")
    private Integer idAnimal;

    @Column(name = "id_sexo")
    private Integer idSexo;

    @Column(name = "id_tamaño")
    private Integer idTamaño;

    @Column(name = "id_persona")
    private Integer idPersona;

    //Generar accessors porfa



}
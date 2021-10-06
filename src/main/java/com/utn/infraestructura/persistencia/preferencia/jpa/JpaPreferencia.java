package com.utn.infraestructura.persistencia.preferencia.jpa;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "preferencia")
public class JpaPreferencia {

    @Id
    @Column(name = "id_preferencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idPreferencia;

    @Id
    @Column(name = "id_animal")
    private BigInteger idAnimal;

    @Id
    @Column(name = "id_sexo")
    private BigInteger idSexo;

    @Id
    @Column(name = "id_tamaño")
    private BigInteger idTamaño;

}
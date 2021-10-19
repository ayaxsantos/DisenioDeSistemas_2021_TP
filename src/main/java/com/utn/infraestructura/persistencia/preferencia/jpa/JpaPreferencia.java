package com.utn.infraestructura.persistencia.preferencia.jpa;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "preferencia")
public class JpaPreferencia {

    @Id
    @Column(name = "id_preferencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPreferencia;

    @Column(name = "id_animal")
    private Integer idAnimal;

    @Column(name = "id_sexo")
    private Integer idSexo;

    @Column(name = "id_tamaño")
    private Integer idTamaño;

}
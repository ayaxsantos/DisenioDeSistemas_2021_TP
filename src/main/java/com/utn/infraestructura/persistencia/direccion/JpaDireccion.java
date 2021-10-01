package com.utn.infraestructura.persistencia.direccion;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "direccion")
public class JpaDireccion {

    @Id
    @Column(name = "id_direccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idDireccion;

    @Column(name = "latitud", nullable = false)
    private double latitud;

    @Column(name = "longitud", nullable = false)
    private double longitud;

}
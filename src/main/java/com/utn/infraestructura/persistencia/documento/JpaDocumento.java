package com.utn.infraestructura.persistencia.documento;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "documento")
public class JpaDocumento {

    @Id
    @Column(name = "id_documento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idDocumento;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "numero")
    private BigInteger numero;

}
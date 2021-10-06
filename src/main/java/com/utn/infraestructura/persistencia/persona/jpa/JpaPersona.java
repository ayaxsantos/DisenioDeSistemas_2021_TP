package com.utn.infraestructura.persistencia.persona.jpa;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;


@Entity
@Table(name = "persona")
public class JpaPersona {

    @Id
    @Column(name = "id_persona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idPersona;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDateTime fechaNacimiento;

    @Column(name = "id_documento")
    private BigInteger idDocumento;

    @Column(name = "id_direccion")
    private BigInteger idDireccion;

    @Column(name = "id_preferencia")
    private BigInteger idPreferencia;

    @Column(name = "id_usuario")
    private BigInteger idUsuario;

    public LocalDateTime fechaNacimiento() {
        return this.fechaNacimiento;
    }


}
package com.utn.infraestructura.persistencia.contacto.jpa;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "contacto")
public class JpaContacto{

    @Id
    @Column(name = "id_contacto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContacto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "mail")
    private String mail;

    public String nombre(){
        return this.nombre;
    }

    public String apellido(){
        return this.apellido;
    }

    public String telefono(){
        return this.telefono;
    }

    public String mail(){
        return this.mail;
    }
}

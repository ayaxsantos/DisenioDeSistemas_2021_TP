package com.utn.dominio.persona;

import com.utn.dominio.EntidadPersistencia;

import javax.persistence.*;

@Entity
@Table(name = "documento")
public class Documento extends EntidadPersistencia {

    @Column
    private String tipo;

    @Column
    private Integer numero;

    public Documento(String tipo, Integer numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public Documento() {

    }

    public Integer numero() {
        return this.numero;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getNumero() {
        return numero;
    }
}
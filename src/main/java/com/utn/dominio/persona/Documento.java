package com.utn.dominio.persona;

import com.utn.dominio.EntidadPersistencia;

import javax.persistence.*;

@Entity
@Table(name = "documento")
public class Documento extends EntidadPersistencia {

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipo;

    @Column
    private Integer numero;

    public Documento(TipoDocumento tipo, Integer numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public Documento() {

    }

    public Integer numero() {
        return this.numero;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public Integer getNumero() {
        return numero;
    }
}
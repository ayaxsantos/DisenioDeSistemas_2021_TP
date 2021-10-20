package com.utn.infraestructura.persistencia.documento;

import com.utn.infraestructura.persistencia.persona.JpaPersona;

import javax.persistence.*;

@Entity
@Table(name = "documento")
public class JpaDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String tipo;

    @Column
    private Integer numero;

    public JpaDocumento(Integer id, String tipo, Integer numero) {
        this.id = id;
        this.tipo = tipo;
        this.numero = numero;
    }

    public JpaDocumento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
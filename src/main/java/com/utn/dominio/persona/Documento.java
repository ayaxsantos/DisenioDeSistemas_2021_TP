package com.utn.dominio.persona;

public class Documento {

    private final String tipo;
    private final Integer numero;

    public Documento(String tipo, Integer numero) {
        this.tipo = tipo;
        this.numero = numero;
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
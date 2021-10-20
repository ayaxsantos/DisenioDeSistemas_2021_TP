package com.utn.dominio.persona;

import com.utn.dominio.EntidadPersistencia;

import javax.persistence.*;

@Entity
@Table(name="direccion")
public class Direccion extends EntidadPersistencia{

    @Column
    private double latitud;
    @Column
    private double longitud;

    public Direccion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Direccion() {

    }

    public double latitud(){
        return this.latitud;
    }

    public double longitud(){
        return this.longitud;
    }

}
package com.utn.dominio;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntidadPersistencia {
    @Id
    @GeneratedValue
    private int id;

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

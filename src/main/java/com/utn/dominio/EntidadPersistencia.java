package com.utn.dominio;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntidadPersistencia {
    @Id
    @GeneratedValue
    private int id;

}

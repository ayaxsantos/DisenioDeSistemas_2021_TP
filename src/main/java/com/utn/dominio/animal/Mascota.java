package com.utn.dominio.animal;

import com.utn.dominio.EntidadPersistente;
import com.utn.infraestructura.normalizador.NormalizadorGraphics2D;

import javax.persistence.*;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

@Entity
@Table(name = "mascota")
public class Mascota extends EntidadPersistente {

    @Column
    private String nombre;

    @Column
    private String apodo;

    @Column
    private int edad;

    @Enumerated(EnumType.STRING)
    private Animal animal;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private Tamaño tamaño;

    @Column
    private String descripcionFisica;

    @ElementCollection()
    @Column(columnDefinition = "MEDIUMTEXT")
    private List<String> fotosNormalizadas;

    @ElementCollection
    private Map<String, String> caracteristicas;

    public Mascota(String nombre, String apodo, int edad, Animal animal, Sexo sexo, Tamaño tamaño, String descripcionFisica) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.edad = edad;
        this.animal = animal;
        this.sexo = sexo;
        this.tamaño = tamaño;
        this.descripcionFisica = descripcionFisica;
        this.fotosNormalizadas = new ArrayList<>();
        this.caracteristicas = new HashMap<>();

    }

    public Mascota() {

    }

    public String getNombre() {
        return nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public int getEdad() {
        return edad;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Tamaño getTamaño() {
        return tamaño;
    }

    public String getDescripcionFisica() {
        return descripcionFisica;
    }

    public List<String> getFotosNormalizadas() {
        return fotosNormalizadas;
    }

    public Map<String, String> getCaracteristicas() {
        return caracteristicas;
    }

    public void añadirFoto(String rutaFoto)
    {
        this.fotosNormalizadas.add(rutaFoto);
    }

    public void añadirCaracteristica(String unaCaracteristica, String unaRespuesta)
    {
        this.caracteristicas.put(unaCaracteristica,unaRespuesta);
    }
}
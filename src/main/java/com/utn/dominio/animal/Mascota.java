package com.utn.dominio.animal;

import com.utn.dominio.EntidadPersistente;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.persona.Persona;
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

    @ManyToOne(cascade = CascadeType.ALL)
    private Organizacion organizacion;

    @ElementCollection()
    @Column(columnDefinition = "MEDIUMTEXT")
    private List<String> fotosNormalizadas;

    @ElementCollection
    private Map<String, String> caracteristicas;

    @ManyToOne(cascade = CascadeType.ALL)
    private Persona duenio;

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

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public Persona getDuenio() {
        return duenio;
    }

    public void setDuenio(Persona duenio) {
        this.duenio = duenio;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setTamaño(Tamaño tamaño) {
        this.tamaño = tamaño;
    }
}
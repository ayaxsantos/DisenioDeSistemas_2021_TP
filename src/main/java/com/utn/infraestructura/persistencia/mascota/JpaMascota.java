package com.utn.infraestructura.persistencia.mascota;

import com.utn.infraestructura.persistencia.animal.JpaAnimal;
import com.utn.infraestructura.persistencia.sexo.JpaSexo;
import com.utn.infraestructura.persistencia.tamaño.JpaTamaño;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "mascota")
public class JpaMascota
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer idChapita;

    @Column
    private String nombre;

    @Column
    private String apodo;

    @Column
    private Integer edad;

    @Enumerated(EnumType.STRING)
    private JpaAnimal animalJPA;

    @Enumerated(EnumType.STRING)
    private JpaSexo sexoJPA;

    @Enumerated(EnumType.STRING)
    private JpaTamaño tamañoJPA;

    @Column
    private String descripcionFisica;

    @ElementCollection
    private List<String> fotosNormalizadas;

    @ElementCollection
    private Map<String, String> caracteristicas;

    public JpaMascota(Integer id, Integer idChapita, String nombre, String apodo, Integer edad, JpaAnimal animalJPA, JpaSexo sexoJPA, JpaTamaño tamañoJPA, String descripcionFisica, List<String> fotosNormalizadas, Map<String, String> caracteristicas) {
        this.id = id;
        this.idChapita = idChapita;
        this.nombre = nombre;
        this.apodo = apodo;
        this.edad = edad;
        this.animalJPA = animalJPA;
        this.sexoJPA = sexoJPA;
        this.tamañoJPA = tamañoJPA;
        this.descripcionFisica = descripcionFisica;
        this.fotosNormalizadas = fotosNormalizadas;
        this.caracteristicas = caracteristicas;
    }

    public JpaMascota() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdChapita() {
        return idChapita;
    }

    public void setIdChapita(Integer idChapita) {
        this.idChapita = idChapita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public JpaAnimal getAnimalJPA() {
        return animalJPA;
    }

    public void setAnimalJPA(JpaAnimal animalJPA) {
        this.animalJPA = animalJPA;
    }

    public JpaSexo getSexoJPA() {
        return sexoJPA;
    }

    public void setSexoJPA(JpaSexo sexoJPA) {
        this.sexoJPA = sexoJPA;
    }

    public JpaTamaño getTamañoJPA() {
        return tamañoJPA;
    }

    public void setTamañoJPA(JpaTamaño tamañoJPA) {
        this.tamañoJPA = tamañoJPA;
    }

    public String getDescripcionFisica() {
        return descripcionFisica;
    }

    public void setDescripcionFisica(String descripcionFisica) {
        this.descripcionFisica = descripcionFisica;
    }

    public List<String> getFotosNormalizadas() {
        return fotosNormalizadas;
    }

    public void setFotosNormalizadas(List<String> fotosNormalizadas) {
        this.fotosNormalizadas = fotosNormalizadas;
    }

    public Map<String, String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Map<String, String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
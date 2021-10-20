package com.utn.infraestructura.persistencia.organizacion;

import com.utn.infraestructura.persistencia.calidadFoto.JpaCalidadFoto;
import com.utn.infraestructura.persistencia.direccion.JpaDireccion;
import com.utn.infraestructura.persistencia.persona.JpaPersona;
import com.utn.infraestructura.persistencia.tamañoFoto.JpaTamañoFoto;
import com.utn.infraestructura.persistencia.voluntario.JpaVoluntario;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organizacion")
public class JpaOrganizacion
{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    @OneToOne
    private JpaDireccion direccionJPA;

    @Enumerated(EnumType.STRING)
    private JpaTamañoFoto tamañoFotoJPA;

    @Enumerated(EnumType.STRING)
    private JpaCalidadFoto calidadFotoJPA;

    @OneToMany
    private List<JpaVoluntario> voluntariosJPA;

    @ManyToMany
    private List<JpaPersona> personasJPA;

    @ManyToMany
    private List<JpaPersona> adoptantesActivosJPA;

    @ElementCollection
    private List<String> caracteristicas;

    @ElementCollection
    private List<String> preguntasAdopcion;

    @ElementCollection
    private List<String> preguntasQuieroAdoptar;

    /* Todo implementar y elegir Inheritance strategy table
    private List<JpaPublicacionMascotaEncontrada> publicacionesMascotaEncontradaJPA;

    private List<JpaPublicacionesMascotaEnAdopcion> publicacionesMascotaEnAdopcionJPA;

    private List<JpaPublicacionesBusquedaAdopcion> publicacionesBusquedaAdopcionJPA;*/

    public JpaOrganizacion(Integer id, String nombre, JpaDireccion direccionJPA, JpaTamañoFoto tamañoFotoJPA, JpaCalidadFoto calidadFotoJPA, List<JpaVoluntario> voluntariosJPA, List<JpaPersona> personasJPA, List<JpaPersona> adoptantesActivosJPA, List<String> caracteristicas, List<String> preguntasAdopcion, List<String> preguntasQuieroAdoptar) {
        this.id = id;
        this.nombre = nombre;
        this.direccionJPA = direccionJPA;
        this.tamañoFotoJPA = tamañoFotoJPA;
        this.calidadFotoJPA = calidadFotoJPA;
        this.voluntariosJPA = voluntariosJPA;
        this.personasJPA = personasJPA;
        this.adoptantesActivosJPA = adoptantesActivosJPA;
        this.caracteristicas = caracteristicas;
        this.preguntasAdopcion = preguntasAdopcion;
        this.preguntasQuieroAdoptar = preguntasQuieroAdoptar;
    }

    public JpaOrganizacion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public JpaDireccion getDireccionJPA() {
        return direccionJPA;
    }

    public void setDireccionJPA(JpaDireccion direccionJPA) {
        this.direccionJPA = direccionJPA;
    }

    public JpaTamañoFoto getTamañoFotoJPA() {
        return tamañoFotoJPA;
    }

    public void setTamañoFotoJPA(JpaTamañoFoto tamañoFotoJPA) {
        this.tamañoFotoJPA = tamañoFotoJPA;
    }

    public JpaCalidadFoto getCalidadFotoJPA() {
        return calidadFotoJPA;
    }

    public void setCalidadFotoJPA(JpaCalidadFoto calidadFotoJPA) {
        this.calidadFotoJPA = calidadFotoJPA;
    }

    public List<JpaVoluntario> getVoluntariosJPA() {
        return voluntariosJPA;
    }

    public void setVoluntariosJPA(List<JpaVoluntario> voluntariosJPA) {
        this.voluntariosJPA = voluntariosJPA;
    }

    public List<JpaPersona> getPersonasJPA() {
        return personasJPA;
    }

    public void setPersonasJPA(List<JpaPersona> personasJPA) {
        this.personasJPA = personasJPA;
    }

    public List<JpaPersona> getAdoptantesActivosJPA() {
        return adoptantesActivosJPA;
    }

    public void setAdoptantesActivosJPA(List<JpaPersona> adoptantesActivosJPA) {
        this.adoptantesActivosJPA = adoptantesActivosJPA;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<String> getPreguntasAdopcion() {
        return preguntasAdopcion;
    }

    public void setPreguntasAdopcion(List<String> preguntasAdopcion) {
        this.preguntasAdopcion = preguntasAdopcion;
    }

    public List<String> getPreguntasQuieroAdoptar() {
        return preguntasQuieroAdoptar;
    }

    public void setPreguntasQuieroAdoptar(List<String> preguntasQuieroAdoptar) {
        this.preguntasQuieroAdoptar = preguntasQuieroAdoptar;
    }
}

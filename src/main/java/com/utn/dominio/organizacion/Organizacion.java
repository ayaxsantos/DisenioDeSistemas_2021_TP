package com.utn.dominio.organizacion;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.utn.dominio.EntidadPersistencia;
import com.utn.dominio.foto.CalidadFoto;
import com.utn.dominio.foto.TamañoFoto;
import com.utn.dominio.persona.Direccion;
import com.utn.dominio.persona.Persona;
import com.utn.dominio.publicacion.PublicacionBusquedaAdopcion;
import com.utn.dominio.publicacion.PublicacionMascotaEnAdopcion;
import com.utn.dominio.publicacion.PublicacionMascotaEncontrada;

import javax.persistence.*;

@Entity
@Table(name = "organizacion")
public class Organizacion extends EntidadPersistencia {

    @Column
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    private Direccion direccion;

    @Enumerated(EnumType.STRING)
    private TamañoFoto tamañoFoto;

    @Enumerated(EnumType.STRING)
    private CalidadFoto calidadFoto;

    @OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL)
    private List<Voluntario> voluntarios = new ArrayList<>();

    @OneToMany(mappedBy = "organizacion",cascade = CascadeType.ALL)
    private List<Administrador> administradores = new ArrayList<>();

    @ManyToMany
    private List<Persona> personas = new ArrayList<>();

    @ElementCollection
    private List<String> caracteristicas;

    @ElementCollection
    private List<String> preguntasAdopcion;

    @ElementCollection
    private List<String> preguntasQuieroAdoptar;

    //Todo: Consultar como evitar la generacion de tablas automaticas,

    @OneToMany(cascade = CascadeType.ALL)
    private List<PublicacionMascotaEncontrada> publicacionesMascotaEncontrada;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PublicacionMascotaEnAdopcion> publicacionesMascotaEnAdopcion;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PublicacionBusquedaAdopcion> publicacionesBusquedaAdopcion;


    public Organizacion(String nombre, Direccion direccion, TamañoFoto tamañoFoto, CalidadFoto calidadFoto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tamañoFoto = tamañoFoto;
        this.calidadFoto = calidadFoto;
        this.caracteristicas = new ArrayList<>();
        this.preguntasAdopcion = new ArrayList<>();
        this.preguntasQuieroAdoptar = new ArrayList<>();
        this.publicacionesMascotaEncontrada = new ArrayList<>();
        this.publicacionesMascotaEnAdopcion = new ArrayList<>();
        this.publicacionesBusquedaAdopcion = new ArrayList<>();
    }

    public Organizacion() {

    }

    public void añadirCaracteristica(String unaCaracteristica) {
        this.caracteristicas.add(unaCaracteristica);
    }

    public void quitarCaracteristica(String unaCaracteristica) {
        this.caracteristicas.remove(unaCaracteristica);
    }

    public void agregarPreguntaAdopcion(String unaPregunta) {
        this.preguntasAdopcion.add(unaPregunta);
    }

    public void eliminarPreguntaAdopcion(String unaPregunta) {
        this.preguntasAdopcion.remove(unaPregunta);
    }

    public void agregarPreguntaQuieroAdoptar(String unaPregunta) {
        this.preguntasQuieroAdoptar.add(unaPregunta);
    }

    public void añadirAdministrador(Administrador unAdministrador) {
        this.administradores.add(unAdministrador);
    }

    public void quitarAdministrador(Administrador unAdministrador) {
        this.administradores.remove(unAdministrador);
    }

    public void añadirVoluntario(Voluntario unVoluntario) {
        this.voluntarios.add(unVoluntario);
    }

    public void eliminarVoluntario(Voluntario unVoluntario) {
        this.voluntarios.remove(unVoluntario);
    }

    public void añadirPersona(Persona unaPersona) {
        this.personas.add(unaPersona);
    }

    public void añadirPublicacionBusquedaAdopcion(PublicacionBusquedaAdopcion publicacion) {
        this.publicacionesBusquedaAdopcion.add(publicacion);
    }

    public void añadirPublicacionMascotaEnAdopcion(PublicacionMascotaEnAdopcion publicacion) {
        this.publicacionesMascotaEnAdopcion.add(publicacion);
    }

    public void añadirPublicacionMascotaEncontrada(PublicacionMascotaEncontrada publicacion) {
        this.publicacionesMascotaEncontrada.add(publicacion);
    }

    public void tamañoFoto(TamañoFoto unTamaño) {
        this.tamañoFoto = unTamaño;
    }

    public void calidadFoto(String calidad) {
        this.calidadFoto = CalidadFoto.obtener(calidad);
    }

    public TamañoFoto tamañoFoto() {
        return this.tamañoFoto;
    }

    public CalidadFoto calidadFoto() {
        return this.calidadFoto;
    }

    public List<PublicacionMascotaEnAdopcion> publicacionesMascotaEnAdopcion() {
        return this.publicacionesMascotaEnAdopcion;
    }

    public List<Persona> adoptantesActivos() {
        return personas.stream().filter(unaPersona -> unaPersona.isEsAdoptante()).collect(Collectors.toList());
    }
}
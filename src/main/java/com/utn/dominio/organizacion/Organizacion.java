package com.utn.dominio.organizacion;

import java.util.List;
import java.util.ArrayList;
import com.utn.dominio.foto.CalidadFoto;
import com.utn.dominio.foto.TamañoFoto;
import com.utn.dominio.persona.Direccion;
import com.utn.dominio.persona.Persona;
import com.utn.dominio.publicacion.PublicacionBusquedaAdopcion;
import com.utn.dominio.publicacion.PublicacionMascotaEnAdopcion;
import com.utn.dominio.publicacion.PublicacionMascotaEncontrada;

public class Organizacion {

    private String nombre;
    private Direccion direccion;
    private TamañoFoto tamañoFoto;
    private CalidadFoto calidadFoto;

    private final List<Administrador> administradores = new ArrayList<>();
    private final List<Voluntario> voluntarios = new ArrayList<>();
    private final List<Persona> personas = new ArrayList<>();
    private final List<Persona> adoptantesActivos = new ArrayList<>();
    private final List<String> caracteristicas = new ArrayList<>();
    private final List<String> preguntasAdopcion = new ArrayList<>();
    private final List<String> preguntasQuieroAdoptar = new ArrayList<>();
    private final List<PublicacionMascotaEncontrada> publicacionesMascotaEncontrada = new ArrayList<>();
    private final List<PublicacionMascotaEnAdopcion> publicacionesMascotaEnAdopcion = new ArrayList<>();
    private final List<PublicacionBusquedaAdopcion> publicacionesBusquedaAdopcion = new ArrayList<>();


    public Organizacion(String nombre, Direccion direccion, TamañoFoto tamañoFoto, CalidadFoto calidadFoto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tamañoFoto = tamañoFoto;
        this.calidadFoto = calidadFoto;
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

    public void añadirPersona(Persona unaPersona){this.personas.add(unaPersona);}

    public void añadirPublicacionBusquedaAdopcion(PublicacionBusquedaAdopcion publicacion) {
        this.publicacionesBusquedaAdopcion.add(publicacion);
    }

    public void añadirPublicacionMascotaEnAdopcion(PublicacionMascotaEnAdopcion publicacion) {
        this.publicacionesMascotaEnAdopcion.add(publicacion);
    }

    public void añadirPublicacionMascotaEncontrada(PublicacionMascotaEncontrada publicacion) {
        this.publicacionesMascotaEncontrada.add(publicacion);
    }

    public void añadirAdoptanteActivo(Persona personaAdoptante) {
        this.adoptantesActivos.add(personaAdoptante);
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
        return this.adoptantesActivos;
    }
}
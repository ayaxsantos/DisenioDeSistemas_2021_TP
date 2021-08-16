package dominio.organizacion;

import dominio.persona.Persona;
import dominio.publicacion.Publicacion;
import dominio.sistema.Administrador;
import dominio.persona.rol.Dueño;
import dominio.persona.rol.Rescatista;
import dominio.persona.rol.Voluntario;

import java.util.List;
import java.util.ArrayList;

public class Organizacion {

    private final List<Administrador> administradores = new ArrayList<>();
    private final List<Dueño> dueños = new ArrayList<>();
    private final List<Rescatista> rescatistas = new ArrayList<>();
    private final List<Voluntario> voluntarios = new ArrayList<>();
    private final List<Caracteristica> caracteristicas = new ArrayList<>();
    private final List<String> preguntasAdopcion = new ArrayList<>();
    private final List<String> preguntasQuieroAdoptar = new ArrayList<>();

    private final List<Publicacion> publicacionesMascotaEncontrada = new ArrayList<>();
    private final List<Publicacion> publicacionesMascotaEnAdopcion = new ArrayList<>();
    private final List<Publicacion> publicacionesBusquedaAdopcion = new ArrayList<>();

    private int tamañoFoto;
    private int calidadFoto;

    public Organizacion(int tamañoFoto, int calidadFoto) {
        this.tamañoFoto = tamañoFoto;
        this.calidadFoto = calidadFoto;
    }

    public void tamañoFoto(int tamaño) {
        this.tamañoFoto = tamaño;
    }

    public void calidadFoto(int calidad) {
        this.calidadFoto = calidad;
    }

    public void añadirCaracteristica(Caracteristica unaCaracteristica) {
        this.caracteristicas.add(unaCaracteristica);
    }

    public void quitarCaracteristica(Caracteristica unaCaracteristica) {
        this.caracteristicas.remove(unaCaracteristica);
    }

    public void agregarPreguntaAdopcion(String unaPregunta){
        this.preguntasAdopcion.add(unaPregunta);
    }

    public void eliminarPreguntaAdopcion(String unaPregunta){
        this.preguntasAdopcion.remove(unaPregunta);
    }

    public void agregarPreguntaQuieroAdoptar(String unaPregunta){
        this.preguntasQuieroAdoptar.add(unaPregunta);
    }

    public void añadirAdministrador(Administrador unAdministrador) {
        this.administradores.add(unAdministrador);
    }

    public void quitarAdministrador(Administrador unAdministrador) {
        this.administradores.remove(unAdministrador);
    }

    public void añadirRescatista(Rescatista unRescatista) {
        this.rescatistas.add(unRescatista);
    }

    public void quitarRescatista(Rescatista unRescatista) {
        this.rescatistas.remove(unRescatista);
    }

    public void añadirDueño(Dueño unDueño) {
        dueños.add(unDueño);
    }

    public void sacarDueño(Dueño unDueño) {
        dueños.remove(unDueño);
    }

    public void añadirVoluntario(Voluntario unVoluntario) {
        this.voluntarios.add(unVoluntario);
    }

    public void sacarVoluntario(Voluntario unVoluntario) {
        this.voluntarios.remove(unVoluntario);
    }

    public void normalizar(String rutaFoto) {
        //TODO: en entrega más adelante
    }

    private void generarVoluntario(Persona persona){
        this.añadirVoluntario(persona.voluntario());
    }

    public void añadirPublicacionBusquedaAdopcion(Publicacion publicacion) {
        this.publicacionesBusquedaAdopcion.add(publicacion);
    }

    public void añadirPublicacionMascotaEnAdopcion(Publicacion publicacion) {
        this.publicacionesMascotaEnAdopcion.add(publicacion);
    }

    public void añadirPublicacionMascotaEncontrada(Publicacion publicacion) {
        this.publicacionesMascotaEncontrada.add(publicacion);
    }
}
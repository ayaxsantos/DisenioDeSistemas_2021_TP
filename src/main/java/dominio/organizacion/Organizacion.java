package dominio.organizacion;

import dominio.foto.CalidadFoto;
import dominio.foto.TamañoFoto;
import dominio.persona.Persona;
import dominio.persona.rol.Adoptante;
import dominio.publicacion.Publicacion;
import dominio.publicacion.PublicacionMascotaEnAdopcion;
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
    private final List<Persona> adoptantes = new ArrayList();
    private final List<Persona> adoptantesActivos = new ArrayList<>();
    private final List<Caracteristica> caracteristicas = new ArrayList<>();
    private final List<String> preguntasAdopcion = new ArrayList<>();
    private final List<String> preguntasQuieroAdoptar = new ArrayList<>();

    private final List<Publicacion> publicacionesMascotaEncontrada = new ArrayList<>();
    private final List<PublicacionMascotaEnAdopcion> publicacionesMascotaEnAdopcion = new ArrayList<>();
    private final List<Publicacion> publicacionesBusquedaAdopcion = new ArrayList<>();

    private TamañoFoto tamañoFoto;
    private CalidadFoto calidadFoto;

    public Organizacion(TamañoFoto tamañoFoto, CalidadFoto calidadFoto) {
        this.tamañoFoto = tamañoFoto;
        this.calidadFoto = calidadFoto;
    }

    public void tamañoFoto(int alto, int ancho) {
        this.tamañoFoto = new TamañoFoto(alto, ancho);
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

    private void generarVoluntario(dominio.persona.Persona persona){
        this.añadirVoluntario(persona.voluntario());
    }

    public void añadirPublicacionBusquedaAdopcion(Publicacion publicacion) {
        this.publicacionesBusquedaAdopcion.add(publicacion);
    }

    public void añadirPublicacionMascotaEnAdopcion(PublicacionMascotaEnAdopcion publicacion) {
        this.publicacionesMascotaEnAdopcion.add(publicacion);
    }

    public void añadirPublicacionMascotaEncontrada(Publicacion publicacion) {
        this.publicacionesMascotaEncontrada.add(publicacion);
    }

    public List<PublicacionMascotaEnAdopcion> publicacionesMascotaEnAdopcion() {
        return this.publicacionesMascotaEnAdopcion;
    }

    public List<Persona> adoptantesActivos() {
        return this.adoptantesActivos;
    }

    public void añadirAdoptanteActivo(Persona personaAdoptante) {
        this.adoptantesActivos.add(personaAdoptante);
    }

}
package accion.organizacion;

import dominio.Organizaciones;
import dominio.organizacion.Organizacion;

public class GenerarPreguntaDarAdopcion {

    private final Organizaciones organizaciones;

    public GenerarPreguntaDarAdopcion(Organizaciones organizaciones) {
        this.organizaciones = organizaciones;
    }

    public void ejecutar(int idOrganizacion, String preguntaAdopcion) {
        Organizacion organizacion = organizaciones.obtenerPorId(idOrganizacion);
        organizacion.agregarPreguntaAdopcion(preguntaAdopcion);
        organizaciones.guardar(organizacion);
    }

}
package accion.organizacion;

import dominio.Organizaciones;
import dominio.organizacion.Organizacion;

public class EliminarPreguntaDarAdopcion {

    private final Organizaciones organizaciones;

    public EliminarPreguntaDarAdopcion(Organizaciones organizaciones) {
        this.organizaciones = organizaciones;
    }

    public void ejecutar(int idOrganizacion, String preguntaAdopcion){
        Organizacion organizacion = organizaciones.obtenerPorId(idOrganizacion);
        organizacion.eliminarPreguntaAdopcion(preguntaAdopcion);
        organizaciones.guardar(organizacion);
    }

}
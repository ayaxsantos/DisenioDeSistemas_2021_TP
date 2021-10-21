package com.utn.casodeuso.organizacion;

import com.utn.dominio.Organizaciones;
import com.utn.dominio.organizacion.Organizacion;

public class EliminarPreguntaDarAdopcion {

    private final Organizaciones organizaciones;

    public EliminarPreguntaDarAdopcion(Organizaciones organizaciones) {
        this.organizaciones = organizaciones;
    }

    public void ejecutar(String nombreOrganizacion, String preguntaAdopcion){
        Organizacion organizacion = organizaciones.obtenerPorNombre(nombreOrganizacion);
        organizacion.eliminarPreguntaAdopcion(preguntaAdopcion);
        organizaciones.guardar(organizacion);
    }

}
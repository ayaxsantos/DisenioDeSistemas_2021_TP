package com.utn.dominio.publicacion;

import java.util.List;
import java.util.ArrayList;

public class PublicacionBusquedaAdopcion extends Publicacion {

    private final Preferencia preferencia;
    private final List<String> comodidades = new ArrayList<>();

    public PublicacionBusquedaAdopcion(int numeroDocumentoAdoptante, Preferencia preferencia, List<String> comodidades) {
        super(numeroDocumentoAdoptante);
        this.preferencia = preferencia;
        this.comodidades.addAll(comodidades);
    }

}
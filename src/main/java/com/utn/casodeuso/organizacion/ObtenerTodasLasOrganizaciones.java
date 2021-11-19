package com.utn.casodeuso.organizacion;

import com.utn.dominio.Organizaciones;
import com.utn.dominio.organizacion.Organizacion;
import sun.awt.X11.XSystemTrayPeer;

import java.util.List;

public class ObtenerTodasLasOrganizaciones {
    private final Organizaciones organizaciones;

    public ObtenerTodasLasOrganizaciones(Organizaciones organizaciones) {
        this.organizaciones = organizaciones;
    }

    public List<Organizacion> ejecutar() {
        return organizaciones.obtenerTodas();
    }
}

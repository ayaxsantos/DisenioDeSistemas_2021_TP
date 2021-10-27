package com.utn.casodeuso.usuario;

import com.utn.dominio.Usuarios;
import com.utn.dominio.organizacion.Organizacion;

import java.util.List;

public class ObtenerOrganizaciones {

    private final Usuarios usuarios;

    public ObtenerOrganizaciones(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public List<Organizacion> ejecutar(String nombreUsuario) {
        return usuarios.obtenerPorNombreUsuario(nombreUsuario).organizacionesPertenecientes();
    }

}
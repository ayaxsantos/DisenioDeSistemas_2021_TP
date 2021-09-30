package com.utn.dominio;

import com.utn.dominio.organizacion.Organizacion;

import java.util.List;

public interface Organizaciones {
    List<Organizacion> obtenerTodas();
    Organizacion obtenerPorId(int idOrganizacion);
    void guardar(Organizacion organizacion);
}

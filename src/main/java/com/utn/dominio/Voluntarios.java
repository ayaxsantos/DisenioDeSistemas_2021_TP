package com.utn.dominio;

import com.utn.dominio.organizacion.Voluntario;

public interface Voluntarios {
    Voluntario obtenerPorNombreUsuario(String nombreUsuario);
    Voluntario obtenerPorNumeroDNI(int numeroDNI);
    void guardar(Voluntario voluntario);
}

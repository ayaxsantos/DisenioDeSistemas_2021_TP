package com.utn.dominio;

import com.utn.dominio.persona.Persona;

public interface Personas {
    Persona obtenerPorNombreDeUsuario(String nombreUsuario);
    Persona obtenerPorNumeroDocumento(int numeroDocumento);
    void guardar(Persona persona);
}
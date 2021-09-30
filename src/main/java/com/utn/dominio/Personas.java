package com.utn.dominio;

import com.utn.dominio.persona.Persona;

public interface Personas {
    Persona obtenerPorNumeroDocumento(int numeroDocumento);
    void guardar(Persona persona);
}
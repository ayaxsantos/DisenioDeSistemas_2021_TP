package com.utn.dominio;

import com.utn.dominio.persona.Persona;

public interface Personas {
    Persona obtenerPorNombreDeUsuario(String nombreUsuario);
    Persona obtenerPorNumeroDocumento(int numeroDocumento, String tipoDocumento);
    void guardar(Persona persona);
}
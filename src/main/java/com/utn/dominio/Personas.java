package com.utn.dominio;

import com.utn.dominio.persona.Persona;
import com.utn.dominio.persona.TipoDocumento;

public interface Personas {
    Persona obtenerPorNombreDeUsuario(String nombreUsuario);
    Persona obtenerPorNumeroDocumento(int numeroDocumento, TipoDocumento tipoDocumento);
    void guardar(Persona persona);
}
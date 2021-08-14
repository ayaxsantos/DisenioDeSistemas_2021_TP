package dominio;

import dominio.persona.Persona;

public interface Personas {
    Persona obtenerPorNumeroDocumento(int numeroDocumento);
    void guardar(Persona persona);
}
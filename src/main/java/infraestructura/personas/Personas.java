package infraestructura.personas;

import dominio.persona.Persona;

public interface Personas {
    Persona obtenerPorNumeroDocumento(int numeroDocumento);
}
package infraestructura.personas;

import dominio.persona.Persona;
import dominio.Personas;

import java.util.ArrayList;
import java.util.List;

public class PersonasEnMemoria implements Personas {

    private List<Persona> personas = new ArrayList<>();

    @Override
    public Persona obtenerPorNumeroDocumento(int numeroDocumento) {
        return personas.stream()
            .filter(persona -> persona.numeroDocumento() == numeroDocumento)
            .findFirst()
            .orElseThrow(RuntimeException::new);
    }

}
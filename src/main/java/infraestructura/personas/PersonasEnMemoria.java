package infraestructura.personas;

import dominio.Personas;
import dominio.persona.Persona;

import java.util.List;
import java.util.ArrayList;

public class PersonasEnMemoria implements Personas {

    private List<Persona> personas = new ArrayList<>();

    @Override
    public Persona obtenerPorNumeroDocumento(int numeroDocumento) {
        return personas.stream()
            .filter(persona -> persona.numeroDocumento() == numeroDocumento)
            .findFirst()
            .orElseThrow(RuntimeException::new);
    }

    @Override
    public void guardar(Persona persona) {
        personas.add(persona);
    }

}
package infraestructura.hogares.criterios;

import dominio.animal.Mascota;
import dominio.persona.Persona;
import infraestructura.hogares.Hogar;

public interface ValidacionHogar {
    boolean ejecutar(Hogar hogar, Persona personaRescatista, Mascota mascota);
}
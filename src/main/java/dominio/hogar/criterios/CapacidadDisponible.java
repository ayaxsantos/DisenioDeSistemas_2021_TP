package dominio.hogar.criterios;

import dominio.animal.Mascota;
import dominio.persona.Persona;
import dominio.hogar.ValidacionHogar;
import infraestructura.hogares.Hogar;

public class CapacidadDisponible implements ValidacionHogar {

    @Override
    public boolean ejecutar(Hogar hogar, Persona personaRescatista, Mascota mascota) {
        return hogar.lugares_disponibles > 0;
    }

}
package infraestructura.hogares.criterios;

import dominio.animal.Mascota;
import dominio.persona.Persona;
import infraestructura.hogares.Hogar;

import java.util.ArrayList;
import java.util.List;

public class CumpleCaracteristicas implements ValidacionHogar {

    @Override
    public boolean ejecutar(Hogar hogar, Persona personaRescatista, Mascota mascota) {
        List<String> unasCaracteristicas = new ArrayList(mascota.caracteristicas().values());
        return hogar.caracteristicas.containsAll(unasCaracteristicas);
    }

}
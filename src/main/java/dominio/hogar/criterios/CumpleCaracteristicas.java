package dominio.hogar.criterios;

import java.util.List;
import java.util.ArrayList;
import dominio.animal.Mascota;
import dominio.persona.Persona;
import dominio.hogar.ValidacionHogar;
import infraestructura.hogares.Hogar;

public class CumpleCaracteristicas implements ValidacionHogar {

    @Override
    public boolean ejecutar(Hogar hogar, Persona personaRescatista, Mascota mascota) {
        List<String> unasCaracteristicas = new ArrayList<>(mascota.caracteristicas().values());
        return !unasCaracteristicas.isEmpty() && hogar.caracteristicas.containsAll(unasCaracteristicas);
    }

}
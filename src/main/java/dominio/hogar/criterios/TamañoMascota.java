package dominio.hogar.criterios;

import dominio.animal.Mascota;
import dominio.animal.Tamaño;
import dominio.persona.Persona;
import dominio.hogar.ValidacionHogar;
import infraestructura.hogares.Hogar;

public class TamañoMascota implements ValidacionHogar {

    @Override
    public boolean ejecutar(Hogar hogar, Persona personaRescatista, Mascota mascota) {
        return (mascota.tamaño() == Tamaño.CHICO) != hogar.patio;
    }

}
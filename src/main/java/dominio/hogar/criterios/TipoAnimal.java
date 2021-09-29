package dominio.hogar.criterios;

import dominio.animal.Animal;
import dominio.animal.Mascota;
import dominio.persona.Persona;
import dominio.hogar.ValidacionHogar;

import infraestructura.hogares.Hogar;

public class TipoAnimal implements ValidacionHogar {

    @Override
    public boolean ejecutar(Hogar hogar, Persona personaRescatista, Mascota mascota) {
        return mascota.animal() == Animal.GATO ? hogar.admisiones.gatos : hogar.admisiones.perros;
    }

}
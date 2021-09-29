package dominio.hogar.criterios;

import dominio.animal.Mascota;
import dominio.persona.Persona;
import dominio.hogar.ValidacionHogar;

import infraestructura.hogares.Hogar;

public class Cercania implements ValidacionHogar {

    @Override
    public boolean ejecutar(Hogar hogar, Persona personaRescatista, Mascota mascota) {
        double latitudRescatista = personaRescatista.domicilio().latitud();
        double longitudRescatista = personaRescatista.domicilio().longitud();
        double latitudHogar = hogar.ubicacion.latitud;
        double longitudHogar = hogar.ubicacion.longitud;
        double diferenciaLatitud = latitudHogar - latitudRescatista;
        if(diferenciaLatitud < 0)
            diferenciaLatitud = diferenciaLatitud * (-1);
        double diferenciaLongitud = longitudHogar - longitudRescatista;
        if(diferenciaLongitud < 0)
            diferenciaLongitud = diferenciaLongitud * (-1);
        return diferenciaLatitud <= personaRescatista.radioHogares() &&
            diferenciaLongitud <= personaRescatista.radioHogares();
    }

}
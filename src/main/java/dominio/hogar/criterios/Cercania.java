package dominio.hogar.criterios;

import dominio.animal.Mascota;
import dominio.hogar.ValidacionHogar;
import dominio.persona.Persona;

import infraestructura.hogares.Hogar;

public class Cercania implements ValidacionHogar {

    @Override
    public boolean ejecutar(Hogar hogar, Persona personaRescatista, Mascota mascota) {
        Double latitudRescatista = personaRescatista.domicilio().latitud();
        Double longitudRescatista = personaRescatista.domicilio().longitud();
        Double latitudHogar = hogar.ubicacion.latitud;
        Double longitudHogar = hogar.ubicacion.longitud;
        Double diferenciaLatitud = latitudHogar - latitudRescatista;
        if(diferenciaLatitud < 0)
            diferenciaLatitud = diferenciaLatitud * (-1);
        Double diferenciaLongitud = longitudHogar - longitudRescatista;
        if(diferenciaLongitud < 0)
            diferenciaLongitud = diferenciaLongitud * (-1);
        return diferenciaLatitud <= personaRescatista.rescatista().radioDeHogares() &&
            diferenciaLongitud <= personaRescatista.rescatista().radioDeHogares();
    }

}
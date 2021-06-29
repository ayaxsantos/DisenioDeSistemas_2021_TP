package infraestructura.hogares.criterios;

import dominio.persona.Persona;
import infraestructura.hogares.Hogar;
import infraestructura.hogares.HogaresResponse;

import java.util.List;

public class Cercania implements ValidacionHogar
{
    //El rescatista podrá elegir el radio de cercanía de los hogares de tránsito.
    private List<Hogar> criterioCercania(Persona rescatista, int radio, HogaresResponse hogaresRespuesta){
        return (List<Hogar>) hogaresRespuesta.hogares.stream()
                .filter(hogar -> estaCerca(radio, hogar, rescatista));
    }

    private Boolean estaCerca(Double radio, Hogar hogar, Persona rescatista){
        Double latitudRescatista = rescatista.domicilio().latitud;
        Double longitudRescatista = rescatista.domicilio().longitud;
        Double latitudHogar = rescatista.domicilio().latitud;
        Double longitudHogar = rescatista.domicilio().longitud;
        Double diferenciaLatitud = latitudHogar -latitudRescatista;
        if(diferenciaLatitud < 0){diferenciaLatitud = diferenciaLatitud * (-1);}
        Double diferenciaLongitud = longitudHogar - longitudRescatista;
        if(diferenciaLongitud < 0){diferenciaLongitud = diferenciaLongitud * (-1);}

        return diferenciaLatitud <= radio && diferenciaLongitud <= radio;
    }
}

package infraestructura.hogares.criterios;

import dominio.animal.Mascota;
import infraestructura.hogares.Hogar;
import infraestructura.hogares.HogaresResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CumpleCaracteristicas implements ValidacionHogar
{
    //o Algunos hogares son más específicos para la admisión de mascotas y deben considerarse
    //características puntuales.
    private List<Hogar> hogareQueCumplenCaracteristicas(Mascota unaMascota, HogaresResponse hogaresRespuesta)
    {
        List<String> unasCaracteristicas =  new ArrayList<String>(unaMascota.caracteristicas().values());
        return hogaresRespuesta.hogares.stream().filter(unHogar -> unHogar.caracteristicas.containsAll(unasCaracteristicas)).collect(Collectors.toList());
    }
}

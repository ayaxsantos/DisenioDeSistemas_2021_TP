package infraestructura.hogares.criterios;

import infraestructura.hogares.Hogar;
import infraestructura.hogares.HogaresResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CapacidadDisponible implements ValidacionHogar {


    private List<Hogar> hogaresConCapacidadDisponible(HogaresResponse hogaresRespuesta) {
        return hogaresRespuesta.hogares.stream()
                .filter(hogar -> hogar.capacidad > 0).collect(Collectors.toList());
    }
}

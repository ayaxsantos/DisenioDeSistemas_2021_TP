package infraestructura.hogares.criterios;

import dominio.animal.Mascota;
import dominio.animal.Tamaño;
import infraestructura.hogares.Hogar;
import infraestructura.hogares.HogaresResponse;

import java.util.List;

public class Tamanio implements ValidacionHogar
{
    //Algunos hogares poseen patios y otros no. Si poseen patio, aceptan mascotas medianas o
    private List<Hogar> criterioTamanio(HogaresResponse hogaresRespuesta, Mascota mascota) {
        if (mascota.tamaño() == Tamaño.CHICO) {
            return (List<Hogar>) hogaresRespuesta.hogares.stream().filter(hogar -> !hogar.patio);
        } else {
            return (List<Hogar>) hogaresRespuesta.hogares.stream().filter(hogar ->hogar.patio);
        }
    }
}

package infraestructura.hogares.criterios;

import dominio.animal.Animal;
import dominio.animal.Mascota;
import infraestructura.hogares.Hogar;
import infraestructura.hogares.HogaresResponse;

import java.util.List;

public class TipoAnimal implements ValidacionHogar
{
    //Algunos hogares solamente aceptan perros, otros solamente gatos y a otros les da lo mismo. cele
    private List<Hogar> criterioTipoAnimal(HogaresResponse hogares, Mascota mascota){
        if(mascota.animal() == Animal.GATO){
            return (List<Hogar>) hogares.hogares.stream().filter(hogar -> hogar.admisiones.gatos);
        } else {
            return (List<Hogar>) hogares.hogares.stream().filter(hogar -> hogar.admisiones.perros);
        }
    }
}

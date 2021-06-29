package accion;

import dominio.animal.Animal;
import dominio.animal.Mascota;
import dominio.animal.Tamaño;
import dominio.organizacion.Caracteristica;
import dominio.persona.Persona;
import dominio.persona.Rescatista;
import infraestructura.Mascotas;
import infraestructura.hogares.Hogar;
import infraestructura.hogares.HogaresResponse;
import infraestructura.hogares.ServicioHogares;
import infraestructura.personas.Personas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BuscarHogarTransito {

    private Personas personas;
    private Mascotas mascotas;
    private ServicioHogares servicioHogares;

    public BuscarHogarTransito(Personas personas, Mascotas mascotas, ServicioHogares servicioHogares) {
        this.personas = personas;
        this.servicioHogares = servicioHogares;
        this.mascotas = mascotas;
    }

    public List<Hogar> ejecutar(int numeroDocumentoRescatista, int idMascota) {
        Persona persona = personas.obtenerPorNumeroDocumento(numeroDocumentoRescatista);
        Mascota mascota = mascotas.obtenerPorId(idMascota);
        HogaresResponse respuesta = servicioHogares.hogares(1);

        return new ArrayList<>();
    }

    /*
        //interfaz
        public interface ValidacionHogar {
            boolean validarHogar(Hogar hogar, Mascota mascota, Rescatista rescatista);
        }
        // cada metodito de criterio es una implementacion (clase nueva por cada una) de esta interfaz
        me fui a la reunion :)
     */

    //Algunos hogares solamente aceptan perros, otros solamente gatos y a otros les da lo mismo. cele
    private List<Hogar> criterioTipoAnimal(HogaresResponse hogaresRespuesta, Mascota mascota){
        if(mascota.animal() == Animal.GATO){
            return (List<Hogar>) hogares.hogares.stream().filter(hogar -> hogar.admisiones.gatos);
        } else {
            return (List<Hogar>) hogares.hogares.stream().filter(hogar -> hogar.admisiones.perros);
        }
    }

    //El rescatista podrá elegir el radio de cercanía de los hogares de tránsito.
    private List<Hogar> criterioCercania(Persona rescatista, int radio, HogaresResponse hogaresRespuesta){
        return (List<Hogar>) hogaresRespuesta.hogares.stream()
                .filter(hogar -> estaCerca(radio, hogar, rescatista));
    }

    private Boolean estaCerca(int radio, Hogar hogar, Persona rescatista){
        Double latitudRescatista = rescatista.domicilio().latitud;
        Double longitudRescatista = rescatista.domicilio().longitud;
        Double latitudHogar = rescatista.domicilio().latitud;
        Double longitudHogar = rescatista.domicilio().longitud;

        return latitudHogar - latitudRescatista <= radio && longitudHogar - longitudRescatista <= radio;
    }

    //Algunos hogares poseen patios y otros no. Si poseen patio, aceptan mascotas medianas o
   private List<Hogar> criterioTamanio(HogaresResponse hogaresRespuesta, Mascota mascota) {
       if (mascota.tamaño() == Tamaño.CHICA) {
           return (List<Hogar>) hogaresRespuesta.hogares.stream().filter(hogar -> !hogar.patio);
       } else {
           return (List<Hogar>) hogaresRespuesta.hogares.stream().filter(hogar ->Ohogar.patio);
       }
   }


    //o Algunos hogares son más específicos para la admisión de mascotas y deben considerarse
    //características puntuales.
    private List<Hogar> hogareQueCumplenCaracteristicas(Mascota unaMascota, HogaresResponse hogaresRespuesta)
    {
        List<String> unasCaracteristicas =  new ArrayList<String>(unaMascota.caracteristicas().values());
        return hogaresRespuesta.hogares.stream().filter(unHogar -> unHogar.caracteristicas.containsAll(unasCaracteristicas)).collect(Collectors.toList());
    }

    //Puede que un hogar no tenga disponibilidad por estar con su capacidad completa.
    private List<Hogar> hogaresConCapacidadDisponible(HogaresResponse hogaresRespuesta) {
        return hogaresRespuesta.hogares.stream()
            .filter(hogar -> hogar.capacidad > 0).collect(Collectors.toList());
    }

}
/*
• Buscar un hogar de tránsito adecuado: puede darse el caso de que el rescatista no posea el lugar
adecuado para alojar a la mascota mientras espera que aparezca su dueño. Siendo este el escenario,
el sistema deberá mostrarle diferentes posibilidades de hogares de tránsito teniendo en cuenta que:

 */

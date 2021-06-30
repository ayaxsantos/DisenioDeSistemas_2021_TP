package accion;

import dominio.animal.Mascota;

import dominio.persona.Persona;
import infraestructura.Mascotas;
import infraestructura.hogares.Hogar;
import infraestructura.hogares.criterios.*;
import infraestructura.personas.Personas;
import infraestructura.hogares.ServicioHogares;
import infraestructura.hogares.HogaresResponse;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BuscarHogarTransito {

    private final Personas personas;
    private final Mascotas mascotas;
    private final ServicioHogares servicioHogares;

    private final List<ValidacionHogar> validacionesHogar = new ArrayList() {{
       add(new CapacidadDisponible());
       add(new TamañoMascota());
       add(new CumpleCaracteristicas());
       add(new TipoAnimal());
       add(new Cercania());
    }};

    public BuscarHogarTransito(Personas personas, Mascotas mascotas, ServicioHogares servicioHogares) {
        this.personas = personas;
        this.mascotas = mascotas;
        this.servicioHogares = servicioHogares;
    }

    public List<Hogar> ejecutar(int numeroDocumentoRescatista, int idMascota) {
        Persona persona = personas.obtenerPorNumeroDocumento(numeroDocumentoRescatista);
        Mascota mascota = mascotas.obtenerPorId(idMascota);
        HogaresResponse respuesta = servicioHogares.hogares(1);
        List<Hogar> hogares = new ArrayList<>();
        for(ValidacionHogar validacionHogar: validacionesHogar) {
            hogares.addAll(respuesta.hogares.stream().filter(hogar -> validacionHogar.ejecutar(hogar, persona, mascota)).collect(Collectors.toList()));
        }
        return hogares;
    }

}
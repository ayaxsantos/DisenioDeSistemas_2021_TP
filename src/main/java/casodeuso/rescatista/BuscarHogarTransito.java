package casodeuso.rescatista;

import dominio.Hogares;
import dominio.Personas;
import dominio.Mascotas;
import dominio.animal.Mascota;
import dominio.persona.Persona;
import dominio.hogar.ValidacionHogar;

import infraestructura.hogares.Hogar;
import infraestructura.hogares.HogaresResponse;

import java.util.List;
import java.util.stream.Collectors;

public class BuscarHogarTransito {

    private final Personas personas;
    private final Mascotas mascotas;
    private final Hogares hogares;
    private final List<ValidacionHogar> validacionesHogar;

    public BuscarHogarTransito(Personas personas, Mascotas mascotas, Hogares hogares, List<ValidacionHogar> validacionesHogar) {
        this.personas = personas;
        this.mascotas = mascotas;
        this.hogares = hogares;
        this.validacionesHogar = validacionesHogar;
    }

    public List<Hogar> ejecutar(int numeroDocumentoRescatista, int idMascota) {
        Persona persona = personas.obtenerPorNumeroDocumento(numeroDocumentoRescatista);
        Mascota mascota = mascotas.obtenerPorId(idMascota);
        HogaresResponse respuesta = hogares.obtener();
        return respuesta.hogares.stream().filter(hogar ->
            validacionesHogar.stream().allMatch(validacionHogar ->
                validacionHogar.ejecutar(hogar, persona, mascota))).collect(Collectors.toList());
    }

}
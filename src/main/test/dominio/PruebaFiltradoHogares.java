package dominio;

import infraestructura.hogares.Hogar;
import infraestructura.hogares.ServicioHogares;
import infraestructura.hogares.criterios.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static accion.FixtureNotificarMascotaEncontrada.*;

public class PruebaFiltradoHogares {

    private final ServicioHogares servicioHogares = new ServicioHogares();

    private final List<ValidacionHogar> validacionesHogar = new ArrayList() {{
        add(new CapacidadDisponible());
        add(new TamañoMascota());
        add(new CumpleCaracteristicas());
        add(new TipoAnimal());
        add(new Cercania());
    }};

    @Test
    public void filtra_hogares() {
        inicializarMascota();
        inicializarRescatista();
        List<Hogar> hogares = servicioHogares.hogares(1).hogares;

        List<Hogar> hogaresFiltrados = hogares.stream().filter(hogar ->
                validacionesHogar.stream().allMatch(validacionHogar ->
                    validacionHogar.ejecutar(hogar, personaRescatista, mascota))).collect(Collectors.toList());

        System.out.println(hogaresFiltrados.size());

    }

}

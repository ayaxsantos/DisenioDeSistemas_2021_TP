package dominio;

import dominio.hogar.ValidacionHogar;
import infraestructura.hogares.Hogar;
import infraestructura.hogares.ServicioHogares;

import dominio.hogar.criterios.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static accion.FixtureNotificarMascotaEncontrada.*;

public class PruebaFiltradoHogares {

    private ServicioHogares servicioHogares;
    private List<ValidacionHogar> validacionesHogar;
    private final int offset = 1;

    @BeforeEach
    void inicializar() {
        servicioHogares = new ServicioHogares();
        validacionesHogar = new ArrayList() {{
            add(new CapacidadDisponible());
            add(new TamañoMascota());
            add(new CumpleCaracteristicas());
            add(new TipoAnimal());
            add(new Cercania());
        }};
    }

    @Test
    public void filtra_hogares_correctamente() {
        inicializarMascota();
        inicializarRescatista();
        List<Hogar> hogares = servicioHogares.hogares(offset).hogares;
        List<Hogar> hogaresFiltrados =
            hogares.stream().filter(hogar -> validacionesHogar.stream().allMatch(validacionHogar ->
                validacionHogar.ejecutar(hogar, personaRescatista, mascota))).collect(Collectors.toList());
        Assertions.assertEquals(hogaresFiltrados.size(), 0);
    }

}
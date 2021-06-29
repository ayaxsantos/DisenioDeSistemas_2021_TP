package infraestructura;

import dominio.excepcion.HogaresNoObtenidosException;
import infraestructura.hogares.HogaresResponse;
import infraestructura.hogares.ServicioHogares;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import static infraestructura.FixtureHogares.offsetValido;
import static infraestructura.FixtureHogares.offsetInvalido;

public class PruebaHogares {

    private ServicioHogares servicioHogares;

    @BeforeEach
    void inicializar() {
        servicioHogares = new ServicioHogares();
    }

    @Test
    public void se_obtienen_los_hogares_enviando_un_offset_valido_correctamente()  {
        HogaresResponse respuesta = servicioHogares.hogares(offsetValido);
        Assertions.assertTrue(respuesta.hogares.size() > 0);
    }

    @Test
    public void error_al_obtener_los_hogares_enviando_un_offset_erroneo()  {
        Assertions.assertThrows(HogaresNoObtenidosException.class, () -> servicioHogares.hogares(offsetInvalido));
    }

}
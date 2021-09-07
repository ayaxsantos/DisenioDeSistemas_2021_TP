package dominio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import dominio.foto.Foto;

public class PruebaNormalizado {

    @Test
    public void normaliza_foto_correctamente() {
        Foto unaFoto = new Foto();
        unaFoto.normalizar();
    }

}

package dominio.persona;

import dominio.animal.Mascota;
import dominio.excepcion.MascotaNoEncontradaException;

import java.util.List;
import java.util.ArrayList;

public class Dueño {

    private int idDuenio;
    private final List<Mascota> mascotas = new ArrayList<>();

    public void añadirMascota(Mascota mascota){
        mascotas.add(mascota);
    }

    public Mascota buscarMascota(int idMascota) {
        return mascotas.stream()
            .filter(unaMascota -> unaMascota.id() == idMascota)
            .findFirst().orElseThrow(MascotaNoEncontradaException::new);
    }

    public Integer getIdDuenio()
    {
        return this.idDuenio;
    }

}
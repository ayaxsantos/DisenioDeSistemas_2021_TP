package dominio.roles;

import dominio.Mascota;

import java.util.ArrayList;
import java.util.List;

public class DueñoMascota extends Rol{
    private List<Mascota> mascotas;

    public DueñoMascota() {
        this.mascotas = new ArrayList<Mascota>();
    }

    public void añadirMascota(Mascota unaMascota){
        mascotas.add(unaMascota);
    }

}

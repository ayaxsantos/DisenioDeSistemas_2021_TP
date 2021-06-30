package infraestructura.mascotas;

import dominio.animal.Mascota;

public interface Mascotas {
    Mascota obtenerPorId(int id);
}
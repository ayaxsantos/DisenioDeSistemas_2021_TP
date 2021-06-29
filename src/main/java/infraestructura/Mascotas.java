package infraestructura;

import dominio.animal.Mascota;

public interface Mascotas {
    Mascota obtenerPorId(int id);
}
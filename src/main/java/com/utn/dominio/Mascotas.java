package com.utn.dominio;

import com.utn.dominio.animal.Mascota;
import com.utn.infraestructura.persistencia.mascota.jpa.JpaMascota;

public interface Mascotas {
    Mascota obtenerPorId(int idMascota);
    void guardar(Mascota mascota);
}
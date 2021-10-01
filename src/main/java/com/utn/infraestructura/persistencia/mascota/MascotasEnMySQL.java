package com.utn.infraestructura.persistencia.mascota;

import com.utn.dominio.Mascotas;
import com.utn.dominio.animal.Mascota;
import com.utn.infraestructura.persistencia.mascota.jpa.JpaMascota;
import com.utn.infraestructura.persistencia.mascota.jpa.JpaRepositorioMascotas;

public class MascotasEnMySQL implements Mascotas
{
    private final JpaRepositorioMascotas jpaRepositorioMascotas;

    public MascotasEnMySQL(JpaRepositorioMascotas jpaRepositorioMascotas)
    {
        this.jpaRepositorioMascotas = jpaRepositorioMascotas;
    }

    @Override
    public Mascota obtenerPorId(int idMascota) {
        JpaMascota jpaMascota = jpaRepositorioMascotas.obtenerPorId(idMascota);
        return null;
    }
}
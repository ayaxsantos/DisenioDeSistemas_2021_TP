package com.utn.infraestructura.persistencia;

import com.utn.dominio.Mascotas;
import com.utn.dominio.animal.Mascota;

import com.utn.dominio.animal.Animal;
import com.utn.dominio.animal.Tamaño;
import com.utn.dominio.animal.Sexo;

import com.utn.infraestructura.persistencia.EntityManagerHelper;
import org.springframework.stereotype.Repository;

@Repository
public class MascotasEnMySQL implements Mascotas {
    public Mascota obtenerPorId(int idMascota) {

        EntityManagerHelper.beginTransaction();
        Mascota jpaMascota = (Mascota) EntityManagerHelper.getEntityManager()
                .createQuery( "from JpaMascota mas where mas.id = " + idMascota).getSingleResult();
        EntityManagerHelper.commit();

        return null;
    }

    @Override
    public void guardar(Mascota mascota) {

    }

}
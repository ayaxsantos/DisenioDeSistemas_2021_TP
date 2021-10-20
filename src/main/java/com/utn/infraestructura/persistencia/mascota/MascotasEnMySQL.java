package com.utn.infraestructura.persistencia.mascota;

import com.utn.dominio.Mascotas;
import com.utn.dominio.animal.Mascota;

import com.utn.dominio.animal.Animal;
import com.utn.dominio.animal.Tamaño;
import com.utn.dominio.animal.Sexo;

import com.utn.infraestructura.persistencia.EntityManagerHelper;
import com.utn.infraestructura.persistencia.animal.JpaAnimal;
import com.utn.infraestructura.persistencia.tamaño.JpaTamaño;
import com.utn.infraestructura.persistencia.sexo.JpaSexo;
import org.springframework.stereotype.Repository;

@Repository
public class MascotasEnMySQL implements Mascotas {
    public Mascota obtenerPorId(int idMascota) {

        EntityManagerHelper.beginTransaction();
        JpaMascota jpaMascota = (JpaMascota) EntityManagerHelper.getEntityManager()
                .createQuery( "from JpaMascota mas where mas.id = " + idMascota).getSingleResult();
        EntityManagerHelper.commit();

        return null;
    }


    //Converters enum
    public Tamaño conversionToCalidadFoto(JpaTamaño tamañoObtenido)
    {
        return Tamaño.values()[tamañoObtenido.ordinal()];
    }

    public Sexo conversionToCalidadFoto(JpaSexo sexoObtenido)
    {
        return Sexo.values()[sexoObtenido.ordinal()];
    }

    public Animal conversionToCalidadFoto(JpaAnimal animalObtenido)
    {
        return Animal.values()[animalObtenido.ordinal()];
    }

    @Override
    public void guardar(Mascota mascota) {

    }

}
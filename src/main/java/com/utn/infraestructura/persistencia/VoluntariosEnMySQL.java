package com.utn.infraestructura.persistencia;

import com.utn.dominio.Voluntarios;
import com.utn.dominio.organizacion.Voluntario;


public class VoluntariosEnMySQL implements Voluntarios {

    public Voluntario obtenerPorNombreUsuario(String nombreUsuario) {
        EntityManagerHelper.beginTransaction();

        Voluntario voluntario = (Voluntario) EntityManagerHelper.getEntityManager()
            .createQuery("FROM Voluntario vol WHERE EXISTS (FROM vol.usuario usr WHERE usr.usuario = '"
                    + nombreUsuario +"')").getSingleResult();

        EntityManagerHelper.commit();
        return voluntario;
    }

    @Override
    public void guardar(Voluntario voluntario) {
        EntityManagerHelper.beginTransaction();

        EntityManagerHelper.persist(voluntario);

        EntityManagerHelper.commit();
    }
}

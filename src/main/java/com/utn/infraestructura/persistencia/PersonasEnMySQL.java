package com.utn.infraestructura.persistencia;

import com.utn.dominio.Personas;
import com.utn.dominio.persona.Persona;


public class PersonasEnMySQL implements Personas {

    @Override
    public Persona obtenerPorNombreDeUsuario(String nombreUsuario) {
        EntityManagerHelper.beginTransaction();

        Persona unaPersona = (Persona) EntityManagerHelper.getEntityManager()
                .createQuery("FROM Persona per WHERE EXISTS (FROM Usuario usr WHERE usr.usuario = '"
                        + nombreUsuario +"' AND per.usuario = usr)").getSingleResult();

        EntityManagerHelper.commit();
        return unaPersona;
    }

    @Override
    public Persona obtenerPorNumeroDocumento(int numeroDocumento) {
        EntityManagerHelper.beginTransaction();

        Persona persona = (Persona) EntityManagerHelper.getEntityManager()
                .createQuery("FROM Persona per WHERE per.documento.numero = " + numeroDocumento).getSingleResult();

        EntityManagerHelper.commit();
        return persona;
    }

    @Override
    public void guardar(Persona persona) {
        EntityManagerHelper.beginTransaction();

        EntityManagerHelper.persist(persona);

        EntityManagerHelper.commit();
    }


}

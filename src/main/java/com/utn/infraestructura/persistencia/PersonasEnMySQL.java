
package com.utn.infraestructura.persistencia;

import com.utn.dominio.Personas;
import com.utn.dominio.organizacion.Voluntario;
import com.utn.dominio.persona.Persona;
import com.utn.infraestructura.persistencia.EntityManagerHelper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonasEnMySQL implements Personas {

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

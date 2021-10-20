
package com.utn.infraestructura.persistencia.persona;

import com.utn.dominio.Personas;
import com.utn.dominio.persona.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonasEnMySQL implements Personas {

    @Override
    public Persona obtenerPorNumeroDocumento(int numeroDocumento) {
        return null;
    }

    @Override
    public void guardar(Persona persona) {

    }

}

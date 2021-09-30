package com.utn.infraestructura.persistencia.persona;

import com.utn.dominio.Personas;
import com.utn.dominio.persona.Persona;
import com.utn.infraestructura.persistencia.persona.jpa.JpaPersona;
import com.utn.infraestructura.persistencia.persona.jpa.JpaRepositorioPersonas;

public class PersonasEnMySQL implements Personas {

    private final JpaRepositorioPersonas jpaRepositorioPersonas;

    public PersonasEnMySQL(JpaRepositorioPersonas jpaRepositorioPersonas) {
        this.jpaRepositorioPersonas = jpaRepositorioPersonas;
    }

    @Override
    public Persona obtenerPorNumeroDocumento(int numeroDocumento) {
        JpaPersona jpaPersona = jpaRepositorioPersonas.obtenerPorNumeroDocumento(numeroDocumento);
        return null;
    }

    @Override
    public void guardar(Persona persona) {
        JpaPersona jpaPersona = new JpaPersona();
        jpaRepositorioPersonas.guardar(jpaPersona);
    }

}
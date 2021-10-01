package com.utn.infraestructura.persistencia.voluntario.jpa;

import com.utn.dominio.Voluntarios;
import com.utn.dominio.organizacion.Voluntario;

public class VoluntariosEnMySQL implements Voluntarios
{
    private final JpaRepositorioVoluntario jpaRepositorioVoluntario;

    public VoluntariosEnMySQL(JpaRepositorioVoluntario jpaRepositorioVoluntario)
    {
        this.jpaRepositorioVoluntario = jpaRepositorioVoluntario;
    }

    public Voluntario obtenerPorNombreUsuario(String nombreUsuario)
    {
      JpaVoluntario jpaVoluntario = jpaRepositorioVoluntario.obtenerPorNombreDeUsuario(nombreUsuario);
      return null;
    }

    public void guardar(Voluntario voluntario)
    {
        JpaVoluntario jpaVoluntario = new JpaVoluntario();
        jpaRepositorioVoluntario.guardar(jpaVoluntario);
    }
}

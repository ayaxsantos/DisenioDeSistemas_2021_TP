package com.utn.infraestructura.persistencia.voluntario.jpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepositorioVoluntario extends JpaRepository<JpaVoluntario, Long>
{
    JpaVoluntario obtenerPorNombreDeUsuario(String nombreUsuario);
    void guardar(JpaVoluntario jpaVoluntario);
}

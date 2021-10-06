package com.utn.infraestructura.persistencia.voluntario.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaRepositorioVoluntario extends JpaRepository<JpaVoluntario, Long>
{

    @Query("select vol.id from JpaVoluntario vol inner join " +
            "JpaUsuario usu on vol.idUsuario = usu.idUsuario where usu.nombreUsuario = :nombreUsuario")
    JpaVoluntario obtenerPorNombreDeUsuario(String nombreDeUsuario);

    @Modifying
    @Query(
            value =" insert into voluntario (id_voluntario,id_usuario,id_organizacion) " +
            "values(:id_voluntario,:id_usuario,:id_organizacion)", nativeQuery = true )
    void guardar(JpaVoluntario jpaVoluntario);
}

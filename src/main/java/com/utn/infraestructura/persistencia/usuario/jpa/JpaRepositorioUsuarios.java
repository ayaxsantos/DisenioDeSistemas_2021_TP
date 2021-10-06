package com.utn.infraestructura.persistencia.usuario.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaRepositorioUsuarios extends JpaRepository<JpaUsuario, Long> {

    @Query("select usu.id from JpaUsuario usu where usu.id =: idUsuario")
    JpaUsuario obtenerPorId(int idUsuario);
}

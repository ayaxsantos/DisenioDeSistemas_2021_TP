package com.utn.infraestructura.persistencia.usuario.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaRepositorioUsuarios extends JpaRepository<JpaUsuario, Long> {

    @Query("select usu from JpaUsuario usu where usu.nombreUsuario =: nombreDeUsuario")
    JpaUsuario obtenerPorNombreUsuario(String nombreDeUsuario);
}

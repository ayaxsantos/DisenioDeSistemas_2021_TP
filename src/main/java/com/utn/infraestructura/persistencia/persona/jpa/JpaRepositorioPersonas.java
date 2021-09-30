package com.utn.infraestructura.persistencia.persona.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepositorioPersonas extends JpaRepository<JpaPersona, Long> {
    JpaPersona obtenerPorNumeroDocumento(int numeroDocumento);
    void guardar(JpaPersona jpaPersona);
}
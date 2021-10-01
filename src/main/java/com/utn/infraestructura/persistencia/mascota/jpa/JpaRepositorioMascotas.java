package com.utn.infraestructura.persistencia.mascota.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepositorioMascotas extends JpaRepository<JpaMascota, Long> {
    JpaMascota obtenerPorId(int idMascota);

}
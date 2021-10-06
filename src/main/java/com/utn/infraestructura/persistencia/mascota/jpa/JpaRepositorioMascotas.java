package com.utn.infraestructura.persistencia.mascota.jpa;

import com.utn.infraestructura.persistencia.organizacion.jpa.JpaOrganizacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepositorioMascotas extends JpaRepository<JpaMascota, Long> {

    @Query("select mas.id from JpaMascota mas where mas.id =: idMascota")
    JpaMascota obtenerPorId(int idMascota);

    @Query(
            value = "insert into mascota (id_mascota, nombre_mascota, apodo, edad, descripcion_fisica, id_animal, id_sexo, id_tamaño, id_persona) " +
                    "values(:id_mascota,:nombre_mascota,:apodo, :edad, :descripcion_fisica, :id_animal, :id_sexo, :id_tamaño, :id_persona)", nativeQuery = true )
    void guardar(JpaMascota jpaMascota);

}
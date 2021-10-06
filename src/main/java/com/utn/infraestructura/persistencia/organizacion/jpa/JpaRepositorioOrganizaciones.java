package com.utn.infraestructura.persistencia.organizacion.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaRepositorioOrganizaciones extends JpaRepository<JpaOrganizacion, Long>{

    @Query("select org.id from JpaOrganizacion org where org.id =: id")
    JpaOrganizacion obtenerPorId(int id);

    @Query(
            value = "insert into organizacion (id_organizacion, nombre_organizacion, id_direccion, id_tamaño_foto, id_calidad_foto) " +
                    "values(:id_organizacion,:nombre_organizacion,:id_direccion, :id_tamaño_foto, :id_calidad_foto)", nativeQuery = true )
    void guardar(JpaOrganizacion jpaOrganizacion);

    @Query("select org.id, org.idDireccion, org.idCalidadFoto, org.idTamañoFoto, org.nombreOrganizacion" +
            " from JpaOrganizacion org")
    List<JpaOrganizacion> obtenerTodos();
    
}


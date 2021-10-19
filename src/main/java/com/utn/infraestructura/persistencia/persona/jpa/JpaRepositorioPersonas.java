
package com.utn.infraestructura.persistencia.persona.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import com.utn.infraestructura.persistencia.persona.jpa.JpaPersona;

public interface JpaRepositorioPersonas extends JpaRepository<JpaPersona, Long> {

    @Query(
        /*"select per.fechaNacimiento, doc.tipo , doc.numero, dir.latitud , dir.longitud \n" +
        "from JpaPersona per\n" +
        "inner join JpaDocumento doc on per.idDocumento = doc.idDocumento \n" +
        "inner join JpaDireccion dir on per.idDireccion = dir.idDireccion \n" +
        "inner join JpaPreferencia pre on per.idPreferencia = pre.idPreferencia \n" +
        "where doc.numero = :numeroDocumento"*/)
    JpaPersona obtenerPorNumeroDocumento(int numeroDocumento);

    @Query(
            value = "insert into persona (id_persona, fecha_nacimiento, id_documento, id_direccion,id_preferencia) " +
                    "values(:id_persona,:fecha_nacimiento,:id_documento, :id_direccion, :id_preferencia)", nativeQuery = true )
    void guardar(JpaPersona jpaPersona);
}

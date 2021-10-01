package com.utn.infraestructura.persistencia.organizacion.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JpaRepositorioOrganizaciones extends JpaRepository<JpaOrganizacion, Long>{
    JpaOrganizacion obtenerPorId(int id);
    void guardar(JpaOrganizacion jpaOrganizacion);
    List<JpaOrganizacion> obtenerTodos();
    
}


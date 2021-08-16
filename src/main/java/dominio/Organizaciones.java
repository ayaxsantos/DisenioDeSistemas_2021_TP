package dominio;

import dominio.organizacion.Organizacion;

import java.util.List;

public interface Organizaciones {
    List<Organizacion> obtenerTodas();
    Organizacion obtenerPorId(int idOrganizacion);
    void guardar(Organizacion organizacion);
}

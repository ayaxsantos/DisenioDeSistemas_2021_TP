package dominio;

import dominio.organizacion.Organizacion;

public interface Organizaciones {
    Organizacion obtenerPorId(int idOrganizacion);
    void guardar(Organizacion organizacion);
}

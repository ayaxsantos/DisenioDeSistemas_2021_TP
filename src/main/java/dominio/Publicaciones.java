package dominio;

import dominio.publicacion.Publicacion;

public interface Publicaciones {

    void guardar(Publicacion publicacion);

    Publicacion obtenerPorId(int idPublicacion);
}



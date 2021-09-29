package dominio;

import dominio.organizacion.Voluntario;

public interface Voluntarios {
    Voluntario obtenerPorNombreUsuario(String nombreUsuario);
    void guardar(Voluntario voluntario);
}

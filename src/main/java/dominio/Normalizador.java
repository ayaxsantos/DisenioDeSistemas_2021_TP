package dominio;

import dominio.foto.TamañoFoto;
import dominio.foto.CalidadFoto;

public interface Normalizador {
    String ejecutar(String fotoOriginal, CalidadFoto calidadFoto, TamañoFoto tamaño);
}
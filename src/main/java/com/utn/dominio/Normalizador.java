package com.utn.dominio;

import com.utn.dominio.foto.TamañoFoto;
import com.utn.dominio.foto.CalidadFoto;

public interface Normalizador {
    String ejecutar(String fotoOriginal, CalidadFoto calidadFoto, TamañoFoto tamaño);
}
package casodeuso.organizacion;

import dominio.Normalizador;
import dominio.Organizaciones;
import dominio.organizacion.Organizacion;

public class NormalizarFoto {

    private final Normalizador normalizador;
    private final Organizaciones organizaciones;

    public NormalizarFoto(Normalizador normalizador, Organizaciones organizaciones) {
        this.normalizador = normalizador;
        this.organizaciones = organizaciones;
    }

    public String ejecutar(int idOrganizacion, String fotoOriginal) {
        Organizacion organizacion = organizaciones.obtenerPorId(idOrganizacion);
        return normalizador.ejecutar(fotoOriginal, organizacion.calidadFoto(), organizacion.tamañoFoto());
    }

}

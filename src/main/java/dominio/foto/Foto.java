package dominio.foto;

import dominio.Normalizador;
import infraestructura.normalizador.NormalizadorGraphics2D;

public class Foto {

    private Integer tamanio;
    private Integer calidad;
    private String rutaFoto;
    private Normalizador normalizador = new NormalizadorGraphics2D();

    public Foto(Integer tamanio, Integer calidad, String rutaFoto) {
        this.tamanio = tamanio;
        this.calidad = calidad;
        this.rutaFoto = rutaFoto;
    }

    public void normalizar(CalidadFoto unaCalidad, TamañoFoto tamañoFoto){
        this.normalizador.ejecutar(this.rutaFoto, unaCalidad, tamañoFoto);
    }

}
package dominio.foto;

public class TamañoFoto {

    private final int alto;
    private final int ancho;

    public TamañoFoto(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    public int alto() {
        return this.alto;
    }

    public int ancho() {
        return this.ancho;
    }

}
package dominio.publicacion;

import java.time.LocalDateTime;

public abstract class Publicacion {

    private final int numeroDocumento;
    private boolean estaVisible;
    private final LocalDateTime fecha;

    public Publicacion(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
        this.estaVisible = false;
        this.fecha = LocalDateTime.now();
    }

    public void estaVisible(boolean estaVisible){
        this.estaVisible = estaVisible;
    }

}
package dominio.publicacion;

import java.time.LocalDateTime;

public class Publicacion {

    private boolean estaVisible;
    private final LocalDateTime fecha;

    public Publicacion() {
        this.estaVisible = false;
        this.fecha = LocalDateTime.now();
    }

    public void estaVisible(boolean estaVisible){
        this.estaVisible = estaVisible;
    }

}
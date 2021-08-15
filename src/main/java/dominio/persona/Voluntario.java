package dominio.persona;

import dominio.publicacion.Publicacion;

public class Voluntario {

    public void aprobarPublicacion(Publicacion publicacion){
        publicacion.estaVisible(true);
    }

    public void rechazarPublicacion(Publicacion publicacion) {
        publicacion.estaVisible(false);
    }

}
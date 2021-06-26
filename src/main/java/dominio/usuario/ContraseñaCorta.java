package dominio.usuario;

import dominio.excepciones.ContraseñaCortaException;

public class ContraseñaCorta implements CriteriosValidacion {

    private final int longitudMinima = 8;

    public void validar(String contraseña) {
        if(contraseña.length() < longitudMinima)
            throw new ContraseñaCortaException();
    }

}
package dominio.autenticacion;

import dominio.excepcion.ContraseñaCortaException;

public class ContraseñaCorta implements Criterios {

    private final static int longitudMinima = 8;

    public void validar(String contraseña) {
        if(contraseña.length() < longitudMinima)
            throw new ContraseñaCortaException();
    }

}
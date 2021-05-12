package dominio;

import dominio.excepciones.ContraseñaCortaException;
import dominio.excepciones.ContraseñaDebilException;

import java.util.List;

public class Usuario {

    private final String usuario;
    private final String contraseña;

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.validarContraseña(contraseña);
        this.contraseña = contraseña;
    }

    private void validarContraseña(String contraseña) {
        if(contraseña.length() < 8)
            throw new ContraseñaCortaException();

        List<String> contraseñasInseguras = Archivo.obtenerContraseñasInseguras();
        boolean esContraseñaDebil = contraseñasInseguras.stream()
            .anyMatch(contraseñaInsegura -> contraseñaInsegura.equals(contraseña));

        if(esContraseñaDebil)
            throw new ContraseñaDebilException();
    }

}
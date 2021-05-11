package dominio;

import dominio.excepciones.ContraseniaCortaException;
import dominio.excepciones.ContraseniaDebilException;

import java.util.List;

public class Usuario {
    private final String usuario;
    private String contrasenia;

    public Usuario(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.validarContrasenia(contrasenia);
        this.contrasenia = contrasenia;
    }

    private void validarContrasenia(String contrasenia){
        List<String> contraseniasInseguras = Archivo.obtenerContraseniasInseguras();

        boolean esContraseniaDebil = contraseniasInseguras.stream().
                anyMatch(unaContrasenia -> unaContrasenia.equals(contrasenia));

        if(esContraseniaDebil){
            throw new ContraseniaDebilException();
        }
        else if(contrasenia.length() < 8) {
            throw new ContraseniaCortaException();
        }
    }



}

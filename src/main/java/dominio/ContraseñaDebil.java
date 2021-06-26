package dominio;

import dominio.excepciones.ContraseñaDebilException;

import java.util.List;

public class ContraseñaDebil implements CriteriosValidacion {

    private final String rutaArchivo = "src/main/resources/contraseñasInseguras.txt";

    public void validar(String contraseña) {
        List<String> contraseñasInseguras = Archivo.leer(rutaArchivo);
        boolean esContraseñaDebil = contraseñasInseguras.stream()
            .anyMatch(contraseñaInsegura -> contraseñaInsegura.equals(contraseña));
        if (esContraseñaDebil)
            throw new ContraseñaDebilException();
    }

}
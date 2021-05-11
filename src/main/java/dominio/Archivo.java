package dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivo {
    private static final String rutaArchivo = "src/main/resources/contraseniasInseguras.txt";

    public static List<String> obtenerContraseniasInseguras(){
        Scanner escaner = null;
        try {
            escaner = new Scanner(new File(rutaArchivo));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> contraseniasInseguras = new ArrayList<>();
        while (escaner.hasNext()){
            contraseniasInseguras.add(escaner.next());
        }
        escaner.close();

        return contraseniasInseguras;
    }
}

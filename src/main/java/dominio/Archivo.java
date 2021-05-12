package dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivo {

    private static final String rutaArchivo = "src/main/resources/contraseñasInseguras.txt";

    public static List<String> obtenerContraseñasInseguras(){
        List<String> contraseñasInseguras = new ArrayList<>();
        try {
            Scanner escaner = new Scanner(new File(rutaArchivo));
            while(escaner.hasNext())
                contraseñasInseguras.add(escaner.next());
            escaner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return contraseñasInseguras;
    }
}

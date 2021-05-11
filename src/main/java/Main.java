import dominio.Usuario;
import dominio.excepciones.ContraseniaCortaException;
import dominio.excepciones.ContraseniaDebilException;

public class Main {

    public static void main(String[] args) {
        generarUsuario("Usuario1", "12345");
        generarUsuario("Usuario2", "Cont321Ho@13");
        generarUsuario("Usuario3", "password");
        generarUsuario("Usuario4", "kj2@3");
        generarUsuario("Usuario4", "Ho23@·Hola");
    }

    public static void generarUsuario(String usuario, String contrasenia) {
        try {
            new Usuario(usuario, contrasenia);
            System.out.println("Se genero correctamente: " + usuario);
        } catch (ContraseniaDebilException e) {
            System.out.println("No se pudo generar el usuario: " + usuario + ", contrasenia debil");
        } catch (ContraseniaCortaException e) {
            System.out.println("No se pudo generar el usuario: " + usuario + ", contrasenia corta");
        }

    }

}

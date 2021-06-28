import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;

import dominio.autenticacion.Usuario;
import dominio.excepcion.ContraseñaCortaException;
import dominio.excepcion.ContraseñaDebilException;
import infraestructura.hogares.ServicioHogares;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        pruebaApiHogares();
        pruebasTwilio();
        generarUsuario("Usuario1", "12345"); //Debil
        generarUsuario("Usuario2", "Cont321Ho@13");
        generarUsuario("Usuario3", "password"); //Debil
        generarUsuario("Usuario4", "kj2@3"); //Corta
        generarUsuario("Usuario4", "Ho23@·Hola");
    }

    private static void pruebaApiHogares() throws IOException {
        ServicioHogares sh = new ServicioHogares();
        System.out.println(sh.hogares(1));
    }

    public static void pruebasTwilio() {
        final String ACCOUNT_SID = "ACf25d0dc84e759ee44aabaae28289e897";
        final String AUTH_TOKEN = "427b2790814830815dc832a4168d47bc";
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        PhoneNumber from = new PhoneNumber("+12252247262");
        PhoneNumber to = new PhoneNumber("+5491131148430");
        Message message = Message.creator(to, from, "hola").create();
        System.out.println(message.getSid());
    }

    public static void generarUsuario(String usuario, String contraseña) {
        try {
            new Usuario(usuario, contraseña);
            System.out.println("Se genero correctamente: " + usuario);
        } catch (ContraseñaDebilException e) {
            System.out.println("No se pudo generar el usuario: " + usuario + ", contrasenia debil");
        } catch (ContraseñaCortaException e) {
            System.out.println("No se pudo generar el usuario: " + usuario + ", contrasenia corta");
        }

    }

}
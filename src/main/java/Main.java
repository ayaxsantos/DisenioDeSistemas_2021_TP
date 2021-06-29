import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;

import dominio.animal.Mascota;
import dominio.autenticacion.Usuario;
import dominio.excepcion.ContraseñaCortaException;
import dominio.excepcion.ContraseñaDebilException;
import dominio.excepcion.MascotaNoCorrespondeADueñoException;
import infraestructura.hogares.ServicioHogares;

import java.io.IOException;
import java.util.List;
import dominio.persona.*;
import dominio.animal.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Main {

    private static List<Dueño> dueños = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        pruebaFalopa();
     //   pruebaApiHogares();
     //   pruebasTwilio();
      /*  generarUsuario("Usuario1", "12345"); //Debil
        generarUsuario("Usuario2", "Cont321Ho@13");
        generarUsuario("Usuario3", "password"); //Debil
        generarUsuario("Usuario4", "kj2@3"); //Corta
        generarUsuario("Usuario4", "Ho23@·Hola");*/
    }

    private static void pruebaFalopa() {

        Persona unaPersona = new Persona("cami", "berro", LocalDateTime.now(), 42156512, "Calle Falsa 123", "1557342093", "hola@gmail.com");
        Persona otraPersona = new Persona("cris", "calvo", LocalDateTime.now(), 39561928, "Avenida Siempre Viva 742", "1134561101", "tengosueño@gmail.com");

        Usuario unUsuario = new Usuario("cami", "berro", unaPersona);
        Usuario otroUsuario = new Usuario("cris", "calvo", otraPersona);

        Dueño unDueño = new Dueño(unUsuario);
        Dueño otroDueño = new Dueño(otroUsuario);

        Mascota unaMascota = new Mascota(10, "Ayudante de Santa 10", Animal.PERRO , "", 10, Sexo.MACHO, "");
        Mascota otraMascota = new Mascota(20, "Ayudante de Santa 20", Animal.GATO , "", 10, Sexo.HEMBRA, "");
        Mascota terceraMascota = new Mascota(30, "Ayudante de Santa 30", Animal.PERRO , "", 10, Sexo.MACHO, "");

        unDueño.añadirMascota(unaMascota);
        unDueño.añadirMascota(otraMascota);
        otroDueño.añadirMascota(terceraMascota);

        dueños.add(unDueño);
        dueños.add(otroDueño);

        System.out.println(dueños);

    }

    public static Mascota buscarMascota(int idMascota) {
        return dueños.stream().map(dueño -> dueño.buscarMascota(idMascota)).findFirst().orElseThrow(MascotaNoCorrespondeADueñoException::new);
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
            new Usuario(usuario, contraseña, new Persona("cami", "berro", LocalDateTime.now(), 42156512, "Calle Falsa 123", "1557342093", "hola@gmail.com"));
            System.out.println("Se genero correctamente: " + usuario);
        } catch (ContraseñaDebilException e) {
            System.out.println("No se pudo generar el usuario: " + usuario + ", contrasenia debil");
        } catch (ContraseñaCortaException e) {
            System.out.println("No se pudo generar el usuario: " + usuario + ", contrasenia corta");
        }

    }

}
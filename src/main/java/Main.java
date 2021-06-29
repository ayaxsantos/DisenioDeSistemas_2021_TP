import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;

import dominio.animal.Mascota;
import dominio.excepcion.MascotaNoEncontradaException;
import infraestructura.hogares.Hogar;
import infraestructura.hogares.ServicioHogares;

import java.io.IOException;
import java.util.List;
import dominio.persona.*;
import infraestructura.hogares.Ubicacion;

import java.util.ArrayList;

public class Main {

    private static List<Dueño> dueños = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        pruebasTwilio();
    }

    public static Mascota buscarMascota(int idMascota) {
        return dueños.stream()
            .map(dueño -> dueño.buscarMascota(idMascota))
            .findFirst()
            .orElseThrow(MascotaNoEncontradaException::new);
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


}
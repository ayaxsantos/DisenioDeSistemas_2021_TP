package infraestructura.notificador;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;

public class NotificadorTwilio implements Notificador {

    private final String idServicio = "ACf25d0dc84e759ee44aabaae28289e897";
    private final String claveServicio = "427b2790814830815dc832a4168d47bc";

    @Override
    public void enviar(String origen, String destinatario, String asunto, String cuerpo) {
        Twilio.init(idServicio, claveServicio);
        Message mensaje = Message.creator(new PhoneNumber(destinatario), new PhoneNumber(origen), cuerpo).create();
        System.out.println(mensaje.getBody());
    }

}
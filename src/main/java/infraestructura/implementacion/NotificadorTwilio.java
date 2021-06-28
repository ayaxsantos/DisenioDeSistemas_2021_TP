package infraestructura.implementacion;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import infraestructura.Notificador;

public class NotificadorTwilio implements Notificador {

    public static final String ACCOUNT_SID = "ACf25d0dc84e759ee44aabaae28289e897";
    public static final String AUTH_TOKEN = "427b2790814830815dc832a4168d47bc";

    @Override
    public void enviar(String origen, String destinatario, String asunto, String cuerpo) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message mensaje = Message.creator(new PhoneNumber(destinatario), new PhoneNumber(origen), cuerpo).create();
        System.out.println(mensaje.getBody());
    }

}
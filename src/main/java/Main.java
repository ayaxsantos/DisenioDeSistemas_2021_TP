import casodeuso.recomendacion.EnviarRecomendacionAdopcion;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;

import java.util.Calendar;

import dominio.notificacion.estrategia.Email;
import infraestructura.notificador.NotificadorEmail;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        planificador();
        pruebasTwilio();
    }

    private static void planificador() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Timer time = new Timer();

        // Start running the task on Monday at 10:00:00, period is set to 8 hours
        // if you want to run the task immediately, set the 2nd parameter to 0
        time.schedule(new EnviarRecomendacionAdopcion(null, new Email(new NotificadorEmail())), calendar.getTime(), TimeUnit.DAYS.toMillis(7));
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
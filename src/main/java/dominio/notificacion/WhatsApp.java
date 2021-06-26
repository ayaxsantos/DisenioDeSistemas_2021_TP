package dominio.notificacion;

public class WhatsApp extends MedioDeComunicacion {

    public WhatsApp(boolean esPreferido) {
        super(esPreferido);
    }

    @Override
    public void notificar(Mensaje mensaje) {
        System.out.println("Mensaje enviado por WhatsApp!");
    }

}

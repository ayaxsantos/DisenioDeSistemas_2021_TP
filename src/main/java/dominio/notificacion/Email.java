package dominio.notificacion;

public class Email extends MedioDeComunicacion {

    public Email(boolean esPreferido) {
        super(esPreferido);
    }

    @Override
    public void notificar(Mensaje mensaje) {
        System.out.println("Mensaje enviado por email!");
    }

}

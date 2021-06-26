package dominio.notificacion;

public class SMS extends MedioDeComunicacion {

    public SMS(boolean esPreferido) {
        super(esPreferido);
    }

    @Override
    public void notificar(Mensaje mensaje) {
        System.out.println("Mensaje enviado por correo SMS!");
    }

}
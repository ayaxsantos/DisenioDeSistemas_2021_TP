package dominio.notificacion;

public class Mensaje {

    private final String email;
    private final String telefono;
    private final String cuerpo;
    private final String asunto;

    public Mensaje(String email, String telefono, String cuerpo, String asunto) {
        this.email = email;
        this.telefono = telefono;
        this.cuerpo = cuerpo;
        this.asunto = asunto;
    }

}
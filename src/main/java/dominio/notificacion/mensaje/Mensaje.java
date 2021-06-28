package dominio.notificacion.mensaje;

public class Mensaje {

    private String emailDestino;
    private final String telefonoOrigen;
    private String telefonoDestino;
    private final String cuerpo;
    private final String asunto;

    public Mensaje(String cuerpo, String asunto, String telefonoOrigen) {
        this.cuerpo = cuerpo;
        this.asunto = asunto;
        this.telefonoOrigen = telefonoOrigen;
    }

    public void agregarEmailDestino(String emailDestino) {
        this.emailDestino = emailDestino;
    }

    public void agregarTelefonoDestino(String telefonoDestino) {
        this.telefonoDestino = telefonoDestino;
    }

    public String cuerpo() {
        return this.cuerpo;
    }

    public String telefonoDestino(){
        return this.telefonoDestino;
    }

    public String telefonoOrigen(){
        return this.telefonoOrigen;
    }

    public String emailDestino() {
        return this.emailDestino;
    }

    public String asunto() {
        return this.asunto;
    }
}
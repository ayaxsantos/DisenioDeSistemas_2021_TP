package dominio.notificacion.mensaje;

public class Mensaje {

    private String email;
    private final String telefonoOrigen;
    private String telefonoDestino;
    private final String cuerpo;
    private final String asunto;

    public Mensaje(String cuerpo, String asunto, String telefonoOrigen) {
        this.cuerpo = cuerpo;
        this.asunto = asunto;
        this.telefonoOrigen = telefonoOrigen;
    }

    public void agregarEmail(String email) {
        this.email = email;
    }

    public void agregarTelefonoDestino(String telefono) {
        this.telefonoDestino = telefono;
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
}
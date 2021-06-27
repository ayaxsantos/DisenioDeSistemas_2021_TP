package infraestructura;

public interface Notificador {
    void enviar(String numeroOrigen, String numeroDestino, String cuerpo);
}
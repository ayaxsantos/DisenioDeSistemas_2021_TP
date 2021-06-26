package dominio;

import dominio.notificacion.*;

import java.util.List;
import java.util.ArrayList;

import dominio.notificacion.MedioDeComunicacion;

public class Contacto {
    
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private final List<MedioDeComunicacion> mediosDeComunicacion = new ArrayList<>();

    public void notificar(Mensaje mensaje) {
        mediosDeComunicacion.stream()
            .filter(medioDeComunicacion -> medioDeComunicacion.esPreferido())
            .forEach(medioDeComunicacion -> medioDeComunicacion.notificar(mensaje));
    }

    public String telefono() {
        return this.telefono;
    }

    public String email() {
        return this.email;
    }

}
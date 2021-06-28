package dominio.persona;

import java.time.LocalDateTime;

public class Rescatista extends Persona {

    public Rescatista(String nombre, String apellido, LocalDateTime fechaNacimiento, int numeroDocumento, String domicilio) {
        super(nombre, apellido, fechaNacimiento, numeroDocumento, domicilio);
    }
    
}
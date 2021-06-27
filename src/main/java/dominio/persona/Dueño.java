package dominio.persona;

import dominio.animal.Mascota;
import dominio.notificacion.mensaje.Mensaje;
import dominio.excepcion.MascotaNoCorrespondeADueñoException;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Dueño extends Persona {

    private final List<Mascota> mascotas = new ArrayList<>();

    public Dueño(String nombre, String apellido, LocalDateTime fechaNacimiento, int numeroDocumento, String domicilio) {
        super(nombre, apellido, fechaNacimiento, numeroDocumento, domicilio);
    }

    public void añadirMascota(Mascota mascota){
        mascotas.add(mascota);
    }

    public void notificar(Mensaje mensaje) {
        this.contactos().forEach(contacto -> contacto.notificar(mensaje));
    }

    public Mascota buscarMascota(int idMascota) {
        return mascotas.stream()
            .filter(unaMascota -> unaMascota.id() == idMascota)
            .findFirst().orElseThrow(MascotaNoCorrespondeADueñoException::new);
    }

}
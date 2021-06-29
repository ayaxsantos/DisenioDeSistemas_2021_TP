package dominio.persona;

import dominio.animal.Mascota;
import dominio.autenticacion.Usuario;
import dominio.notificacion.mensaje.Mensaje;
import dominio.excepcion.MascotaNoCorrespondeADueñoException;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Dueño extends Rol{

    private Usuario usuario;
    private final List<Mascota> mascotas = new ArrayList<>();

    public Dueño(Usuario unUsuario) {
        this.usuario = unUsuario;
    }

    public void añadirMascota(Mascota mascota){
        mascotas.add(mascota);
    }

    public void notificar(Mensaje mensaje) {
        this.usuario.persona().contactos().forEach(contacto -> contacto.notificar(mensaje));
    }

    public Mascota buscarMascota(int idMascota) {
        return mascotas.stream()
            .filter(unaMascota -> unaMascota.id() == idMascota)
            .findFirst().orElseThrow(MascotaNoCorrespondeADueñoException::new);
    }

    public String nombre() {
        return this.usuario.nombrePersona();
    }

}
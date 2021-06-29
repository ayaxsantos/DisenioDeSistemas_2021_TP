package dominio.persona;



import dominio.autenticacion.Usuario;
import dominio.notificacion.Contacto;

public abstract class Rol {
    private String nombreUsuario;

    public String nombre(){
        return this.usuario().persona().nombre();
    }

    public Contacto contactoPersonal(){
        return this.usuario().persona().contactoPersonal();
    }

    private Usuario usuario(){
        sistema.buscarUsuario(this.nombreUsuario);
    }
}

package dominio;

import dominio.autenticacion.Usuario;
import dominio.excepcion.UsuarioNoEncontrado;
import dominio.organizacion.Organizacion;

import java.util.List;

public class Sistema {
    private List<Usuario> usuariosRegistrados;
    private List<Organizacion> organizacionesRegistradas;

    public Usuario buscarUsuario(String unUsuario){
        return usuariosRegistrados.stream().filter(usuario -> usuario.nombreUsuario().equals(unUsuario)).findFirst().orElseThrow(UsuarioNoEncontrado::new);
    }
}

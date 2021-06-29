package dominio;

import dominio.autenticacion.Usuario;
import dominio.excepcion.UsuarioNoEncontradoException;
import dominio.organizacion.Organizacion;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Organizacion> organizaciones = new ArrayList<>();

    public Usuario buscarUsuario(String unUsuario){
        return usuarios.stream()
            .filter(usuario -> usuario.existe(unUsuario))
            .findFirst()
            .orElseThrow(UsuarioNoEncontradoException::new);
    }

}
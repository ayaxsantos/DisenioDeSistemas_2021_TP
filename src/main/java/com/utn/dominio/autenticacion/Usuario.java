package com.utn.dominio.autenticacion;

import com.utn.dominio.EntidadPersistente;
import com.utn.dominio.excepcion.CredencialesInvalidasException;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario extends EntidadPersistente {

    @Column
    private String usuario;

    @Column
    private String contrasenia;

    public Usuario() {}

    public Usuario(String usuario, String contrasenia) {
        ValidadorContraseña.ejecutar(contrasenia);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public void iniciarSesion(String usuario, String contraseña) {
        if(!this.usuario.equals(usuario) || !this.contrasenia.equals(contraseña))
            throw new CredencialesInvalidasException();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
package com.utn.dominio.persona;

import java.util.List;
import java.util.ArrayList;

import com.utn.dominio.EntidadPersistencia;
import com.utn.dominio.notificacion.mensaje.Mensaje;
import com.utn.dominio.notificacion.MedioDeComunicacion;
import com.utn.dominio.notificacion.estrategia.EstrategiaDeComunicacion;

import javax.persistence.*;

@Entity
@Table(name = "contacto")
public class Contacto extends EntidadPersistencia {

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String telefono;

    @Column
    private String email;

    @Transient //Todo realizar la correcta relación
    private List<MedioDeComunicacion> mediosDeComunicacion = new ArrayList<>();

    public Contacto(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public Contacto() {

    }

    public void notificar(Mensaje mensaje) {
        mensaje.agregarEmailDestino(this.email);
        mensaje.agregarTelefonoDestino(this.telefono);
        mediosDeComunicacion.stream()
                .filter(MedioDeComunicacion::esPreferido)
                .forEach(medioDeComunicacion -> medioDeComunicacion.enviar(mensaje));
    }

    public void añadirMedioDeComunicacion(EstrategiaDeComunicacion estrategiaDeComunicacion, boolean esPreferido) {
        mediosDeComunicacion.add(new MedioDeComunicacion(estrategiaDeComunicacion, esPreferido));
    }

    public String nombre() {
        return this.nombre;
    }

    public String telefono() {
        return this.telefono;
    }

    public String email() {
        return this.email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public List<MedioDeComunicacion> getMediosDeComunicacion() {
        return mediosDeComunicacion;
    }
}
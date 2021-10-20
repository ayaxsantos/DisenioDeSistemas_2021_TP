package com.utn.dominio.persona;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

import com.utn.dominio.animal.Mascota;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.publicacion.Preferencia;
import com.utn.dominio.notificacion.mensaje.Mensaje;
import com.utn.dominio.excepcion.MascotaNoEncontradaException;

public class Persona {

    private final Usuario usuario;
    private final Contacto contactoPersonal;
    private final LocalDate fechaNacimiento;
    private final Documento documento;
    private final Direccion domicilio;
    private final List<Contacto> contactos = new ArrayList<>();
    private final List<Mascota> mascotas = new ArrayList<>();
    private int radioHogares;
    private Preferencia preferencia;

    public Persona(Contacto contactoPersonal, LocalDate fechaNacimiento, Documento documento,
                   Direccion domicilio, Contacto otroContacto, Usuario usuario, int radioHogares) {
        this.contactoPersonal = contactoPersonal;
        this.fechaNacimiento = fechaNacimiento;
        this.documento = documento;
        this.domicilio = domicilio;
        this.contactos.add(otroContacto);
        this.usuario = usuario;
        this.radioHogares = radioHogares;
    }

    public void notificar(Mensaje mensaje) {
        this.contactoPersonal.notificar(mensaje);
        this.contactos.forEach(unContacto -> unContacto.notificar(mensaje));
    }

    public Mascota buscarMascota(int idMascota) {
        return mascotas.stream()
            .filter(unaMascota -> unaMascota.id() == idMascota)
            .findFirst().orElseThrow(MascotaNoEncontradaException::new);
    }

    public void añadirContacto(Contacto contacto){
        contactos.add(contacto);
    }

    public void añadirMascota(Mascota mascota){
        mascotas.add(mascota);
    }

    public void radioHogares(int radioDeHogares){
        this.radioHogares = radioDeHogares;
    }

    public String nombre() {
        return this.contactoPersonal.nombre();
    }

    public String telefono() {
        return this.contactoPersonal.telefono();
    }

    public String email() {
        return this.contactoPersonal.email();
    }

    public int numeroDocumento() {
        return this.documento.numero();
    }

    public Direccion domicilio() {
        return this.domicilio;
    }

    public int radioHogares() {
        return this.radioHogares;
    }

    public Preferencia preferencia() {
        return this.preferencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Contacto getContactoPersonal() {
        return contactoPersonal;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Documento getDocumento() {
        return documento;
    }

    public Direccion getDomicilio() {
        return domicilio;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public int getRadioHogares() {
        return radioHogares;
    }

    public void setRadioHogares(int radioHogares) {
        this.radioHogares = radioHogares;
    }

    public Preferencia getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Preferencia preferencia) {
        this.preferencia = preferencia;
    }
}
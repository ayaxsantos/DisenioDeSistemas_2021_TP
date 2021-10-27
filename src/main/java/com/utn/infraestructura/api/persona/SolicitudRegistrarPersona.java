package com.utn.infraestructura.api.persona;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.utn.dominio.persona.TipoDocumento;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class SolicitudRegistrarPersona
{
    @JsonProperty
    private String nombreUsuario;

    @JsonProperty
    private TipoDocumento tipoDocumento;

    @JsonProperty
    private int numeroDocumento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaNacimiento;

    @JsonProperty
    private int latitud;

    @JsonProperty
    private int longitud;

    @JsonProperty
    private List<String> mediosPreferidos;

    @JsonProperty
    private List<DatosContacto> unosContactos;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public List<String> getMediosPreferidos() {
        return mediosPreferidos;
    }

    public void setMediosPreferidos(List<String> mediosPreferidos) {
        this.mediosPreferidos = mediosPreferidos;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public List<DatosContacto> getUnosContactos() {
        return unosContactos;
    }

    public void setUnosContactos(List<DatosContacto> unosContactos) {
        this.unosContactos = unosContactos;
    }
}

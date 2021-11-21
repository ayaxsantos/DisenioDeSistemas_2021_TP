package com.utn.dominio.notificacion;

import com.utn.dominio.EntidadPersistente;
import com.utn.dominio.Notificador;
import com.utn.dominio.notificacion.mensaje.Mensaje;

import javax.persistence.*;

@Entity
@Table(name = "medioDeComunicacion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class MedioDeComunicacion extends EntidadPersistente {

    @Transient
    protected Notificador notificador;

    @Column
    private boolean esPreferido;

    public MedioDeComunicacion(Notificador notificador, boolean esPreferido) {
        this.notificador = notificador;
        this.esPreferido = esPreferido;
    }

    public MedioDeComunicacion() {

    }

    public boolean esPreferido() {
        return this.esPreferido;
    }

    public abstract void enviar(Mensaje mensaje);
}
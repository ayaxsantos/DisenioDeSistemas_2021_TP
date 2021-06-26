package casodeuso;

import dominio.Contacto;
import dominio.notificacion.Mensaje;

public class NotificarMascotaEncontrada {

    public void ejecutar(){
        //TODO Acá nos falta de donde sale el contacto
        Contacto contacto = new Contacto();
        Mensaje mensaje = new Mensaje(contacto.email(), contacto.telefono(), "", "");
        contacto.notificar(mensaje);
    }

}
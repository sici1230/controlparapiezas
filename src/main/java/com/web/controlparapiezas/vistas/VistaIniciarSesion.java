/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.vistas;

import com.web.controlparapiezas.entidades.Usuarios;
import com.web.controlparapiezas.servicios.ServicioVerificacioAutenticacion;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HP
 */
@Named("vistaIniciarSesion")
@ViewScoped
@Getter
@Setter
public class VistaIniciarSesion implements Serializable{
    
    @Inject
    private Usuarios sesion;
    @Inject
    private ServicioVerificacioAutenticacion verificarAutenticacion;

    @PostConstruct
    public void init() {

    }

    public void iniciarSesion() {
        String redireccion = verificarAutenticacion.verificarAutenticacion(sesion.getUsuario(), sesion.getContrasenia());

        if (redireccion.equals("inicio")) {
            //Ir a la pagina de inicio
        } else if (redireccion.equals("error")) {
            //Hay que agregar al usuario al sistema
        }
    }
}

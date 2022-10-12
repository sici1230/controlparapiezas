/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.vistas;

import com.web.controlparapiezas.entidades.Usuarios;
import com.web.controlparapiezas.servicios.ServicioUsuarios;
import java.io.Serializable;
import java.util.List;
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
@Named(value = "vistaUsuarios")
@ViewScoped
public class VistaUsuarios implements Serializable {

    @Inject
    private ServicioUsuarios servicioUsuarios;

    @Getter
    @Setter
    private List<Usuarios> listaUsuarios;

    @PostConstruct
    public void init() {
        listaUsuarios = servicioUsuarios.listaUsuarios();
    }

    public String agregarUsuario(){
        try {
            return "agregarusuario.xhtml";
        } catch (Exception e) {
            System.out.println("Error en agregar usuario");
        }
        return "usuarios.xhtml";
    }
}

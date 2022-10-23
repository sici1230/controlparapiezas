/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.vistas;

import com.web.controlparapiezas.entidades.Usuarios;
import com.web.controlparapiezas.seguridad.CifradoContrasenia;
import com.web.controlparapiezas.servicios.ServicioUsuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HP
 */
@Named(value = "vistaAgregarUsuario")
@ViewScoped
public class VistaAgregarUsuario implements Serializable {

    @Getter
    @Setter
    @Inject
    private Usuarios nuevoUsuario;

    @Inject
    private ServicioUsuarios servicioUsuarios;

    private CifradoContrasenia cifrado = new CifradoContrasenia();

    private List<String> listaUsuarios = new ArrayList<>();

    @PostConstruct
    public void init() {
        //Iniciar datos de la pagina
        System.out.println("Hola!!!");
        nuevoUsuario.setEstado(false);
        listaUsuarios = servicioUsuarios.listaDeUsuarios();
    }

    public String crearUsuario() {
        try {
            String cifrada = cifrado.cifrar(nuevoUsuario.getContrasenia());
            nuevoUsuario.setContrasenia(cifrada);
            nuevoUsuario.setFechaCreado(new Date());
            if (servicioUsuarios.crearUsuario(nuevoUsuario)) {
                System.out.println("Usuario creado correctamente!!!");
                return "usuarios.xhtml?faces-redirect=true";
            } else {
                System.out.println("Error al crear el usuario");
                return "";
            }
        } catch (Exception e) {
            System.out.println("Error al agregar el usuario" + e.getMessage());
            return "";
        }
    }

    public void validarUsuario(FacesContext context, UIComponent comp, Object value) {
        System.out.println("Dentro del metodo de validacion");
        String valor = (String) value;
        if (valor != null || valor != "") {
            if (listaUsuarios.stream().filter(usuario -> usuario.equalsIgnoreCase(value.toString())).findAny().isPresent()) {
                ((UIInput) comp).setValid(false);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","El usuario ya existe");
                context.addMessage(comp.getClientId(context), message);
            }
        }
    }

    public String regresar() {
        return "usuarios.xhtml?faces-redirect=true";
    }

}

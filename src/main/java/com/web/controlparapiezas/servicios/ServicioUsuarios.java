/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.servicios;

import com.web.controlparapiezas.beans.UsuariosFacadeLocal;
import com.web.controlparapiezas.entidades.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author HP
 */
@Named
@RequestScoped
public class ServicioUsuarios {
    
    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    
    public List<Usuarios> listaUsuarios(){
        List<Usuarios> usuarios = new ArrayList<>();
        try {
            usuarios = usuariosFacade.findAll();
        } catch (Exception e) {
            System.out.println("Error en la lista de usuarios");
        }
        return usuarios;
    }
    
    public boolean crearUsuario(Usuarios crearUsuario){
        try {
            usuariosFacade.create(crearUsuario);
            return true;
        } catch (Exception e) {
            System.out.println("Error en crear el usuario!!!" + e.getMessage());
            return false;
        }
    }
    
    public boolean verificarUsuario(Object nombreUsuario){
        try {
            System.out.println("datos " + nombreUsuario);
            if(usuariosFacade.buscarPorUsuario(nombreUsuario).isPresent()){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error en buscar usuario");
            return false;
        }
    }
    
    public List<String> listaDeUsuarios(){
        try {
            List<String> usuarios = new ArrayList<>();
            usuariosFacade.findAll().forEach(usuario -> usuarios.add(usuario.getUsuario()));
            System.out.println("Lista de usuarios");
            return usuarios;
        } catch (Exception e) {
            System.out.println("Error al buscar los usuarios");
            return new ArrayList<>();
        }
    }
}

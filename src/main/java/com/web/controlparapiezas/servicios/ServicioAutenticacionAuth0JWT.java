/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.servicios;

import com.web.controlparapiezas.beans.UsuariosxrolesFacadeLocal;
import com.web.controlparapiezas.entidades.Usuarios;
import com.web.controlparapiezas.entidades.Usuariosxroles;
import java.util.Optional;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import com.web.controlparapiezas.beans.UsuariosFacadeLocal;

/**
 *
 * @author HP
 */
@Named
@RequestScoped
public class ServicioAutenticacionAuth0JWT {

    @Inject
    private Pbkdf2PasswordHash passwordHash;

    @EJB
    private UsuariosxrolesFacadeLocal usuariosxrolesFacade;
    @EJB
    private UsuariosFacadeLocal iniciarSesionFacade;

    public Usuariosxroles buscarPorToken(String nombreUsuario, String contrasenia) {
        //Si no se encuentra el usuario o no coincide la contraseña 
        try {
            Optional<Usuariosxroles> usuarioToken = usuariosxrolesFacade.buscarPorUsuario(nombreUsuario);
//                .orElseThrow(() -> new UserNotAuthorizedException());

            if (usuarioToken.isPresent() && passwordHash.verify(contrasenia.toCharArray(), usuarioToken.get().getUsuario().getContrasenia())) {
                return usuarioToken.get();
            } else {
                System.out.println("Error al buscar usuarios por token --------");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el token");
        }
        return null;
//        throw new UserNotAuthorizedException();
    }

    public Optional<Usuarios> buscarPorUsuario(String nombreUsuario, String contrasenia) {
        try {
            Optional<Usuarios> usuario = iniciarSesionFacade.buscarPorUsuario(nombreUsuario);

            if (usuario.isPresent() && passwordHash.verify(contrasenia.toCharArray(), usuario.get().getContrasenia())) {
                return usuario;
            } else {
                System.out.println("Error al buscar usuario------");
            }
        } catch (Exception e) {
            System.out.println("Error en buscar al usuario " + e.getMessage());
        }
            return Optional.empty();
    }

    public void guardarToken() {

    }
}

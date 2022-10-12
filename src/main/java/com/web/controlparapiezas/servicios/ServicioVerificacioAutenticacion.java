/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.servicios;

import com.web.controlparapiezas.VariablesDeEntorno;
import com.web.controlparapiezas.beans.UsuariosxrolesFacadeLocal;
import com.web.controlparapiezas.entidades.Usuarios;
import com.web.controlparapiezas.entidades.Usuariosxroles;
import com.web.controlparapiezas.seguridad.Token;
import com.web.controlparapiezas.seguridad.UsuarioJWT;
import java.time.Duration;
import java.util.Date;
import java.util.Optional;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author HP
 */
@Named
@RequestScoped
public class ServicioVerificacioAutenticacion {
    
    private static final VariablesDeEntorno variables = new VariablesDeEntorno();
    
    static final int EXPIRE_IN = variables.getEXPIRE_IN();

    static final Duration EXPIRES = Duration.ofSeconds(EXPIRE_IN);

    @EJB
    private UsuariosxrolesFacadeLocal usuariosporrolesFacade;
    @Inject
    private ServicioAutenticacionAuth0JWT autenticacion;

    public String verificarAutenticacion(String nombreUsuario, String contrasenia) {
        //Hya que agregar la parte donde no se encuentra el usuario y se agrega al sistema
        UsuarioJWT usuarioJWT = new UsuarioJWT();
//        String redireccion = "";
        final Usuariosxroles usuarioToken = autenticacion.buscarPorToken(nombreUsuario, contrasenia);
        if (usuarioToken != null) {
            Optional<UsuarioJWT> usuarioJWTConvertido = usuarioJWT.convertir(usuarioToken.getJwtSecreto(), new Token(usuarioToken.getToken()));
            if (usuarioJWTConvertido.isPresent() && usuarioJWTConvertido.get().getFechaExpiracion().before(new Date())) {
                //cambiar el token
                crearActualizarAutenticacion(usuarioToken.getUsuario(), true);
                return "inicio";
            }
        } else {
            //Buscar solo el usuario en otra tabla
            final Optional<Usuarios> usuario = autenticacion.buscarPorUsuario(nombreUsuario, contrasenia);
            if (usuario.isPresent()) {
                crearActualizarAutenticacion(usuario.get(), false);
                System.out.println("El usuario no existe en los token, pero se crea el token exitosamente");
                return "inicio";
            }
        }
        return "error";
    }

    private void crearActualizarAutenticacion(Usuarios usuario, boolean actualizar) {
        UsuarioJWT usuarioJWT = new UsuarioJWT();
        final Token token = Token.generate();
        final String jwt = usuarioJWT.actualizarToken(usuario, token, EXPIRES);
        Usuariosxroles accesoToken = new Usuariosxroles(jwt, token.get(), usuario);
        if (actualizar) {
            usuariosporrolesFacade.edit(accesoToken);
        } else {
            usuariosporrolesFacade.create(accesoToken);
        }
    }
}

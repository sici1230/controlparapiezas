/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.seguridad;

import com.web.controlparapiezas.entidades.Usuarios;
import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author HP
 */
public class CifradoContrasenia {

    @Inject
    private Usuarios usuario;

    private Pbkdf2PasswordHash passwordHash;

    public Usuarios build(Usuarios usuariosincifrar) {
        usuario.setContrasenia(passwordHash.generate(usuariosincifrar.getContrasenia().toCharArray()));
        return usuariosincifrar;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.web.controlparapiezas.beans;

import com.web.controlparapiezas.entidades.Usuarios;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios iniciarSesion);

    void edit(Usuarios iniciarSesion);

    void remove(Usuarios iniciarSesion);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();
    
    Optional<Usuarios> buscarPorUsuario(Object nombreUsuario);
}

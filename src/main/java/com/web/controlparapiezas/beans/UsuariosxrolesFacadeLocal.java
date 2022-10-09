/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.web.controlparapiezas.beans;

import com.web.controlparapiezas.entidades.Usuariosxroles;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface UsuariosxrolesFacadeLocal {

    void create(Usuariosxroles usuariosxroles);

    void edit(Usuariosxroles usuariosxroles);

    void remove(Usuariosxroles usuariosxroles);

    Usuariosxroles find(Object id);

    List<Usuariosxroles> findAll();

    List<Usuariosxroles> findRange(int[] range);

    int count();
    
    Optional<Usuariosxroles> buscarPorUsuario(Object nombreUsuario);
}

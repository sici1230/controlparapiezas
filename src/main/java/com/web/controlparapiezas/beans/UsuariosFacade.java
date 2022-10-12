/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.beans;

import com.web.controlparapiezas.entidades.Usuarios;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author HP
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    @Override
    public Optional<Usuarios> buscarPorUsuario(Object nombreUsuario){
        Optional<Usuarios> usuario;
        Usuarios usuarioConsulta;
        try {
            TypedQuery<Usuarios> consultaUsuario = em.createNamedQuery("Usuarios.findByUsuario", Usuarios.class);
            consultaUsuario.setParameter("usuario", nombreUsuario);
            usuarioConsulta = consultaUsuario.getSingleResult();
            usuario = Optional.of(usuarioConsulta);
        } catch (Exception e) {
            System.out.println("Error en consultar los usuarios" + e.getMessage());
            return Optional.empty();
//            throw e;
        }
        return usuario;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.beans;

import com.web.controlparapiezas.entidades.Usuariosxroles;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author HP
 */
@Stateless
public class UsuariosxrolesFacade extends AbstractFacade<Usuariosxroles> implements UsuariosxrolesFacadeLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosxrolesFacade() {
        super(Usuariosxroles.class);
    }
    
    @Override
    public Optional<Usuariosxroles> buscarPorUsuario(Object nombreUsuario) {
        String consulta;
        Usuariosxroles usuarioConsulta;
        Optional<Usuariosxroles> usuario;
        try {
            consulta = "FROM Usuariosxroles usuarioporrol WHERE usuarioporrol.usuario.usuario = ?1";
//            consulta = "FROM Usuariosxroles usuarioporrol WHERE usuarioporrol.usuario.usuario = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, nombreUsuario);
            usuarioConsulta = (Usuariosxroles) query.getSingleResult();
            usuario = Optional.of(usuarioConsulta);
        } catch (Exception e) {
            System.out.println("Error al buscar usuario por rol");
            return Optional.empty();
//            throw e;
        }
        return usuario;
    }
}

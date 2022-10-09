/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "usuariosxroles", catalog = "control_de_piezas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariosxroles.findAll", query = "SELECT u FROM Usuariosxroles u"),
    @NamedQuery(name = "Usuariosxroles.findByIdusuarioxroles", query = "SELECT u FROM Usuariosxroles u WHERE u.idusuarioxroles = :idusuarioxroles"),
    @NamedQuery(name = "Usuariosxroles.findByToken", query = "SELECT u FROM Usuariosxroles u WHERE u.token = :token"),
    @NamedQuery(name = "Usuariosxroles.findByJwtSecreto", query = "SELECT u FROM Usuariosxroles u WHERE u.jwtSecreto = :jwtSecreto")})
public class Usuariosxroles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuarioxroles")
    private Integer idusuarioxroles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "jwtSecreto")
    private String jwtSecreto;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne(optional = false)
    private Usuarios usuario;

    public Usuariosxroles() {
    }

    public Usuariosxroles(Integer idusuarioxroles) {
        this.idusuarioxroles = idusuarioxroles;
    }

    public Usuariosxroles(Integer idusuarioxroles, String token, String jwtSecreto) {
        this.idusuarioxroles = idusuarioxroles;
        this.token = token;
        this.jwtSecreto = jwtSecreto;
    }
    
    public Usuariosxroles(String jwtSecreto, String token, Usuarios usuario) {
        this.jwtSecreto = jwtSecreto;
        this.token = token;
        this.usuario = usuario;
    }

    public Integer getIdusuarioxroles() {
        return idusuarioxroles;
    }

    public void setIdusuarioxroles(Integer idusuarioxroles) {
        this.idusuarioxroles = idusuarioxroles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getJwtSecreto() {
        return jwtSecreto;
    }

    public void setJwtSecreto(String jwtSecreto) {
        this.jwtSecreto = jwtSecreto;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuarioxroles != null ? idusuarioxroles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariosxroles)) {
            return false;
        }
        Usuariosxroles other = (Usuariosxroles) object;
        if ((this.idusuarioxroles == null && other.idusuarioxroles != null) || (this.idusuarioxroles != null && !this.idusuarioxroles.equals(other.idusuarioxroles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.controlparapiezas.entidades.Usuariosxroles[ idusuarioxroles=" + idusuarioxroles + " ]";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "iniciar_sesion", catalog = "control_de_piezas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT i FROM Usuarios i"),
    @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT i FROM Usuarios i WHERE i.usuario = :usuario"),
    @NamedQuery(name = "Usuarios.findByContrasenia", query = "SELECT i FROM Usuarios i WHERE i.contrasenia = :contrasenia"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT i FROM Usuarios i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByApellidos", query = "SELECT i FROM Usuarios i WHERE i.apellidos = :apellidos"),
    @NamedQuery(name = "Usuarios.findByRol", query = "SELECT i FROM Usuarios i WHERE i.rol = :rol"),
    @NamedQuery(name = "Usuarios.findByEstado", query = "SELECT i FROM Usuarios i WHERE i.estado = :estado")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "contrasenia")
    private String contrasenia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rol")
    private String rol;
    @Column(name = "estado")
    private Boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Usuariosxroles> usuariosxrolesList;

    public Usuarios() {
    }

    public Usuarios(String usuario) {
        this.usuario = usuario;
    }

    public Usuarios(String usuario, String contrasenia, String nombre, String apellidos, String rol) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Usuariosxroles> getUsuariosxrolesList() {
        return usuariosxrolesList;
    }

    public void setUsuariosxrolesList(List<Usuariosxroles> usuariosxrolesList) {
        this.usuariosxrolesList = usuariosxrolesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.controlparapiezas.entidades.Usuarios[ usuario=" + usuario + " ]";
    }
    
}

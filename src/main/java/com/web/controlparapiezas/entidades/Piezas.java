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
@Table(name = "piezas", catalog = "control_de_piezas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Piezas.findAll", query = "SELECT p FROM Piezas p"),
    @NamedQuery(name = "Piezas.findByIdPieza", query = "SELECT p FROM Piezas p WHERE p.idPieza = :idPieza"),
    @NamedQuery(name = "Piezas.findByNombre", query = "SELECT p FROM Piezas p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Piezas.findByDescripcion", query = "SELECT p FROM Piezas p WHERE p.descripcion = :descripcion")})
public class Piezas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pieza")
    private Integer idPieza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;

    public Piezas() {
    }

    public Piezas(Integer idPieza) {
        this.idPieza = idPieza;
    }

    public Piezas(Integer idPieza, String nombre) {
        this.idPieza = idPieza;
        this.nombre = nombre;
    }

    public Integer getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(Integer idPieza) {
        this.idPieza = idPieza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPieza != null ? idPieza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Piezas)) {
            return false;
        }
        Piezas other = (Piezas) object;
        if ((this.idPieza == null && other.idPieza != null) || (this.idPieza != null && !this.idPieza.equals(other.idPieza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.controlparapiezas.entidades.Piezas[ idPieza=" + idPieza + " ]";
    }
    
}

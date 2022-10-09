/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "maquina", catalog = "control_de_piezas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maquina.findAll", query = "SELECT m FROM Maquina m"),
    @NamedQuery(name = "Maquina.findBySerieMaquina", query = "SELECT m FROM Maquina m WHERE m.serieMaquina = :serieMaquina"),
    @NamedQuery(name = "Maquina.findByMarca", query = "SELECT m FROM Maquina m WHERE m.marca = :marca"),
    @NamedQuery(name = "Maquina.findByModelo", query = "SELECT m FROM Maquina m WHERE m.modelo = :modelo"),
    @NamedQuery(name = "Maquina.findBySede", query = "SELECT m FROM Maquina m WHERE m.sede = :sede"),
    @NamedQuery(name = "Maquina.findByFechaIngreso", query = "SELECT m FROM Maquina m WHERE m.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Maquina.findByDescripcion", query = "SELECT m FROM Maquina m WHERE m.descripcion = :descripcion")})
public class Maquina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "serie_maquina")
    private String serieMaquina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 200)
    @Column(name = "sede")
    private String sede;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;

    public Maquina() {
    }

    public Maquina(String serieMaquina) {
        this.serieMaquina = serieMaquina;
    }

    public Maquina(String serieMaquina, String marca, String modelo, Date fechaIngreso) {
        this.serieMaquina = serieMaquina;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaIngreso = fechaIngreso;
    }

    public String getSerieMaquina() {
        return serieMaquina;
    }

    public void setSerieMaquina(String serieMaquina) {
        this.serieMaquina = serieMaquina;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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
        hash += (serieMaquina != null ? serieMaquina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maquina)) {
            return false;
        }
        Maquina other = (Maquina) object;
        if ((this.serieMaquina == null && other.serieMaquina != null) || (this.serieMaquina != null && !this.serieMaquina.equals(other.serieMaquina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.controlparapiezas.entidades.Maquina[ serieMaquina=" + serieMaquina + " ]";
    }
    
}

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "pieza_maquina", catalog = "control_de_piezas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PiezaMaquina.findAll", query = "SELECT p FROM PiezaMaquina p"),
    @NamedQuery(name = "PiezaMaquina.findByIdPiezaMaquina", query = "SELECT p FROM PiezaMaquina p WHERE p.idPiezaMaquina = :idPiezaMaquina"),
    @NamedQuery(name = "PiezaMaquina.findBySerieMaquina", query = "SELECT p FROM PiezaMaquina p WHERE p.serieMaquina = :serieMaquina"),
    @NamedQuery(name = "PiezaMaquina.findByIdPieza", query = "SELECT p FROM PiezaMaquina p WHERE p.idPieza = :idPieza"),
    @NamedQuery(name = "PiezaMaquina.findByMarca", query = "SELECT p FROM PiezaMaquina p WHERE p.marca = :marca"),
    @NamedQuery(name = "PiezaMaquina.findByModelo", query = "SELECT p FROM PiezaMaquina p WHERE p.modelo = :modelo"),
    @NamedQuery(name = "PiezaMaquina.findByEstadoPieza", query = "SELECT p FROM PiezaMaquina p WHERE p.estadoPieza = :estadoPieza"),
    @NamedQuery(name = "PiezaMaquina.findByTicket", query = "SELECT p FROM PiezaMaquina p WHERE p.ticket = :ticket"),
    @NamedQuery(name = "PiezaMaquina.findByFechaSalidaPieza", query = "SELECT p FROM PiezaMaquina p WHERE p.fechaSalidaPieza = :fechaSalidaPieza")})
public class PiezaMaquina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pieza_maquina")
    private Integer idPiezaMaquina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "serie_maquina")
    private String serieMaquina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pieza")
    private int idPieza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "estado_pieza")
    private String estadoPieza;
    @Size(max = 50)
    @Column(name = "ticket")
    private String ticket;
    @Column(name = "fecha_salida_pieza")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalidaPieza;

    public PiezaMaquina() {
    }

    public PiezaMaquina(Integer idPiezaMaquina) {
        this.idPiezaMaquina = idPiezaMaquina;
    }

    public PiezaMaquina(Integer idPiezaMaquina, String serieMaquina, int idPieza, String marca, String modelo, String estadoPieza) {
        this.idPiezaMaquina = idPiezaMaquina;
        this.serieMaquina = serieMaquina;
        this.idPieza = idPieza;
        this.marca = marca;
        this.modelo = modelo;
        this.estadoPieza = estadoPieza;
    }

    public Integer getIdPiezaMaquina() {
        return idPiezaMaquina;
    }

    public void setIdPiezaMaquina(Integer idPiezaMaquina) {
        this.idPiezaMaquina = idPiezaMaquina;
    }

    public String getSerieMaquina() {
        return serieMaquina;
    }

    public void setSerieMaquina(String serieMaquina) {
        this.serieMaquina = serieMaquina;
    }

    public int getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(int idPieza) {
        this.idPieza = idPieza;
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

    public String getEstadoPieza() {
        return estadoPieza;
    }

    public void setEstadoPieza(String estadoPieza) {
        this.estadoPieza = estadoPieza;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Date getFechaSalidaPieza() {
        return fechaSalidaPieza;
    }

    public void setFechaSalidaPieza(Date fechaSalidaPieza) {
        this.fechaSalidaPieza = fechaSalidaPieza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPiezaMaquina != null ? idPiezaMaquina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PiezaMaquina)) {
            return false;
        }
        PiezaMaquina other = (PiezaMaquina) object;
        if ((this.idPiezaMaquina == null && other.idPiezaMaquina != null) || (this.idPiezaMaquina != null && !this.idPiezaMaquina.equals(other.idPiezaMaquina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.controlparapiezas.entidades.PiezaMaquina[ idPiezaMaquina=" + idPiezaMaquina + " ]";
    }
    
}

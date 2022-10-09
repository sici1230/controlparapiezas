/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.web.controlparapiezas.beans;

import com.web.controlparapiezas.entidades.Piezas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface PiezasFacadeLocal {

    void create(Piezas piezas);

    void edit(Piezas piezas);

    void remove(Piezas piezas);

    Piezas find(Object id);

    List<Piezas> findAll();

    List<Piezas> findRange(int[] range);

    int count();
    
}

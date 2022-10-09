/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.web.controlparapiezas.beans;

import com.web.controlparapiezas.entidades.PiezaMaquina;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface PiezaMaquinaFacadeLocal {

    void create(PiezaMaquina piezaMaquina);

    void edit(PiezaMaquina piezaMaquina);

    void remove(PiezaMaquina piezaMaquina);

    PiezaMaquina find(Object id);

    List<PiezaMaquina> findAll();

    List<PiezaMaquina> findRange(int[] range);

    int count();
    
}

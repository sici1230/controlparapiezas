/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.web.controlparapiezas.beans;

import com.web.controlparapiezas.entidades.Maquina;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface MaquinaFacadeLocal {

    void create(Maquina maquina);

    void edit(Maquina maquina);

    void remove(Maquina maquina);

    Maquina find(Object id);

    List<Maquina> findAll();

    List<Maquina> findRange(int[] range);

    int count();
    
}

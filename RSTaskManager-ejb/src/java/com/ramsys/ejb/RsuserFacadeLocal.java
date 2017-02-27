/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.ejb;

import com.ramsys.persistence.Rsuser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author emaramirez1306
 */
@Local
public interface RsuserFacadeLocal {
    
    public void create(Rsuser rsuser);

    void edit(Rsuser rsuser);

    void remove(Rsuser rsuser);

    Rsuser find(Object id);

    List<Rsuser> findAll();

    List<Rsuser> findRange(int[] range);

    int count();
    
}

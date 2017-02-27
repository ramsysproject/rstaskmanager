/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.ejb;

import com.ramsys.persistence.Rsgroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author emaramirez1306
 */
@Local
public interface RsgroupFacadeLocal {

    void create(Rsgroup rsgroup);

    void edit(Rsgroup rsgroup);

    void remove(Rsgroup rsgroup);

    Rsgroup find(Object id);

    List<Rsgroup> findAll();

    List<Rsgroup> findRange(int[] range);

    int count();
    
}

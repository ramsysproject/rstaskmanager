/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.ejb;

import com.ramsys.persistence.Tasktype;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author emaramirez1306
 */
@Local
public interface TasktypeFacadeLocal {

    void create(Tasktype tasktype);

    void edit(Tasktype tasktype);

    void remove(Tasktype tasktype);

    Tasktype find(Object id);

    List<Tasktype> findAll();

    List<Tasktype> findRange(int[] range);

    int count();
    
}

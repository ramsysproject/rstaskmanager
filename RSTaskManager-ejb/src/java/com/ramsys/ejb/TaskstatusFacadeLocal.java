/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.ejb;

import com.ramsys.persistence.Taskstatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author emaramirez1306
 */
@Local
public interface TaskstatusFacadeLocal {

    void create(Taskstatus taskstatus);

    void edit(Taskstatus taskstatus);

    void remove(Taskstatus taskstatus);

    Taskstatus find(Object id);

    List<Taskstatus> findAll();

    List<Taskstatus> findRange(int[] range);

    int count();
    
}

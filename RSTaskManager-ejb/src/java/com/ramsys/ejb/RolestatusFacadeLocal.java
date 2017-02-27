/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.ejb;

import com.ramsys.persistence.Rolestatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author emaramirez1306
 */
@Local
public interface RolestatusFacadeLocal {

    void create(Rolestatus rolestatus);

    void edit(Rolestatus rolestatus);

    void remove(Rolestatus rolestatus);

    Rolestatus find(Object id);

    List<Rolestatus> findAll();

    List<Rolestatus> findRange(int[] range);

    int count();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.ejb;

import com.ramsys.persistence.Rsuserroles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author emaramirez1306
 */
@Local
public interface RsuserrolesFacadeLocal {

    void create(Rsuserroles rsuserroles);

    void edit(Rsuserroles rsuserroles);

    void remove(Rsuserroles rsuserroles);

    Rsuserroles find(Object id);

    List<Rsuserroles> findAll();

    List<Rsuserroles> findRange(int[] range);

    int count();
    
}

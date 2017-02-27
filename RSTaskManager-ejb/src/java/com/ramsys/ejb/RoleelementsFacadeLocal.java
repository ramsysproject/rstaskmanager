/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.ejb;

import com.ramsys.persistence.Roleelements;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author emaramirez1306
 */
@Local
public interface RoleelementsFacadeLocal {

    void create(Roleelements roleelements);

    void edit(Roleelements roleelements);

    void remove(Roleelements roleelements);

    Roleelements find(Object id);

    List<Roleelements> findAll();

    List<Roleelements> findRange(int[] range);

    int count();
    
}

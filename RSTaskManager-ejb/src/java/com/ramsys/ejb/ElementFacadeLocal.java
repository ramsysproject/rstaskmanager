/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.ejb;

import com.ramsys.persistence.Element;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author emaramirez1306
 */
@Local
public interface ElementFacadeLocal {

    void create(Element element);

    void edit(Element element);

    void remove(Element element);

    Element find(Object id);

    List<Element> findAll();

    List<Element> findRange(int[] range);

    int count();
    
}

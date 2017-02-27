/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.ejb;

import com.ramsys.persistence.Taskstatus;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author emaramirez1306
 */
@Stateless
public class TaskstatusFacade extends AbstractFacade<Taskstatus> implements TaskstatusFacadeLocal {

    @PersistenceContext(unitName = "RSTaskManager-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TaskstatusFacade() {
        super(Taskstatus.class);
    }
    
}

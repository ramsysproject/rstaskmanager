/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.ejb;

import com.ramsys.persistence.Rsuser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author emaramirez1306
 */
@Stateless
@Path("/rsusers")
public class RsuserFacade extends AbstractFacade<Rsuser> implements RsuserFacadeLocal {

    @PersistenceContext(unitName = "RSTaskManager-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RsuserFacade() {
        super(Rsuser.class);
    }       
    
    @Override
    @GET
    @Produces("application/json")
    public List<Rsuser> findAll(){
        return em.createNamedQuery("Rsuser.findAll").getResultList();        
    };
}

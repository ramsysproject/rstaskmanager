/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.ejb;

import com.ramsys.persistence.Rsgroup;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author emaramirez1306
 */
@Stateless
@Path("/rsgroups")
public class RsgroupFacade extends AbstractFacade<Rsgroup> implements RsgroupFacadeLocal {

    @PersistenceContext(unitName = "RSTaskManager-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RsgroupFacade() {
        super(Rsgroup.class);
    }
    
    @Override
    @GET
    @Produces("application/json")
    public List<Rsgroup> findAll(){
        List<Rsgroup> results = em.createNamedQuery("Rsgroup.findAll").getResultList();
        return results;
    }
    
    @Override
    @POST
    public void create(Rsgroup rsgroup){
        System.out.println("Se llamo al post de rsgroup");
        getEntityManager().persist(rsgroup);
    }
}

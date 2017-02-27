/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.rest;

import com.ramsys.ejb.RsgroupFacade;
import com.ramsys.ejb.RsuserFacade;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author emaramirez1306
 */
@ApplicationPath("/rest")
public class RSTaskManagerRestApplication extends Application {

    private final Set<Object> singletons = new HashSet<>();
    private final Set<Class<?>> classes = new HashSet<>();

    public RSTaskManagerRestApplication() {
        classes.add(RsuserFacade.class);
        classes.add(RsgroupFacade.class);
        classes.add(CORSResponseFilter.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}

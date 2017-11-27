/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.simuladorbancario.rest.services;

import co.edu.sena.simuladorbancario.entities.Cdt;
import co.edu.sena.simuladorbancario.sessions.CdtFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1261718
 */
@Path("cdt")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CdtREST {
    @EJB
    private CdtFacade cdtEJB;
    
    @GET
    public List<Cdt> findAll(){
        return cdtEJB.findAll();
    }
    @GET
    @Path("{id}")
    public Cdt findBye(
    @PathParam("nombre")String nombre){
        return cdtEJB.find(nombre);
    
}
    @POST
    public void create(Cdt cdt){
        cdtEJB.create(cdt);
    }
    
}

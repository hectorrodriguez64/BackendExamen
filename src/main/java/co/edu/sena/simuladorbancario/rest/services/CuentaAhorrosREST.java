/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.simuladorbancario.rest.services;

import co.edu.sena.simuladorbancario.entities.CuentaAhorros;
import co.edu.sena.simuladorbancario.sessions.CuentaAhorrosFacade;
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
@Path("cuentaAhorros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CuentaAhorrosREST {
    @EJB
    private CuentaAhorrosFacade cuentaAhorrosEJB;
    
    @GET
    public List<CuentaAhorros> findAll(){
        return cuentaAhorrosEJB.findAll();
    }
    @GET
    @Path("{id}")
    public CuentaAhorros findBye(
    @PathParam("nombre")String nombre){
        return cuentaAhorrosEJB.find(nombre);
    
}
    @POST
    public void create(CuentaAhorros cuentaAhorros){
        cuentaAhorrosEJB.create(cuentaAhorros);
    }
}

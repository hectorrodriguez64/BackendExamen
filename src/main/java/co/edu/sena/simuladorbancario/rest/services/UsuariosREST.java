/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.simuladorbancario.rest.services;

import co.edu.sena.simuladorbancario.entities.Cdt;
import co.edu.sena.simuladorbancario.entities.CuentaAhorros;
import co.edu.sena.simuladorbancario.entities.CuentaCorriente;
import co.edu.sena.simuladorbancario.entities.Usuarios;
import co.edu.sena.simuladorbancario.sessions.CuentaCorrienteFacade;
import co.edu.sena.simuladorbancario.sessions.UsuariosFacade;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1261718
 */
@Path("usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuariosREST {
     @EJB
    private UsuariosFacade usuariosEJB;
     
    @EJB
    private CuentaCorrienteFacade cuentaCorrientaEJB;
    
    @GET
    @RolesAllowed({"ASESOR"})
    public List<Usuarios> findAll(){
        return usuariosEJB.findAll();
    }
    @GET
    @Path("{id}")
    public Usuarios findBye(
    @PathParam("nombre")String nombre){
        return usuariosEJB.find(nombre);
    
    }
   
    @POST
    public void create(Usuarios usuarios){
        
        Usuarios newUsuarios = new Usuarios();
        CuentaCorriente newCcorriente = new CuentaCorriente();
        CuentaAhorros newCahorros = new CuentaAhorros();
        Cdt newCdt = new Cdt();
        try {
            
             //Hallar el saldo total 
        newUsuarios.setSaldoTotal(newCcorriente.getSaldo() + newCahorros.getSaldo() + newCdt.getSaldo());
          
        } catch (Exception e) {
         
        }
        
       
        
    }
    
    
    
    
    
    
}

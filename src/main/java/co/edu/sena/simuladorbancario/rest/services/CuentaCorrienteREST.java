/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.simuladorbancario.rest.services;

import co.edu.sena.simuladorbancario.entities.CuentaCorriente;
import co.edu.sena.simuladorbancario.entities.Usuarios;
import co.edu.sena.simuladorbancario.sessions.CuentaCorrienteFacade;
import java.util.List;
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
@Path("cuentaCorriente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CuentaCorrienteREST {
      @EJB
    private CuentaCorrienteFacade cuentaCorrienteEJB;
    
    @GET
    public List<CuentaCorriente> findAll(){
        return cuentaCorrienteEJB.findAll();
    }
    @GET
    @Path("{id}")
    public CuentaCorriente findBye(
    @PathParam("nombre")String nombre){
        return cuentaCorrienteEJB.find(nombre);
    
}
    @POST
    public void create(
        @QueryParam("saldo") double saldo,
        @QueryParam("saldoTotal") double saldoTotal){
        
        CuentaCorriente newCcorriente = new CuentaCorriente();
        Usuarios newUsuarios = new Usuarios();
        
        try{
            newCcorriente.setRetirar(retirarValor(newUsuarios.getSaldoTotal(), saldo));
            newCcorriente.setConsignar(consignarValor(newUsuarios.getSaldoTotal(), saldo));
            newCcorriente.setSaldo(saldo);
            newCcorriente.setIdUsuarios(newUsuarios);
        }catch (Exception e) {
     
        }
    }
    
     private double saldo;

    /**
     * Inicializa la cuenta corriente
     */
    public void calcularValores(){
        //El saldo inicial de la cuenta corriente es cero
        saldo = 0;
    }

    /**
     * Consigna una cantidad de dinero en la cuenta del cliente
     * @param valor - el valor a consignar en la cuenta
     */
    private double consignarValor(double valor, double saldoTotal ){
        saldoTotal = saldoTotal + valor;
        return saldoTotal;
    }

    /**
     * Retira una cantidad de dinero de la cuenta del cliente
     * @param valor - el valor a retirar de la cuenta
     */
   private double retirarValor(double saldoTotal, double valor){
        saldoTotal = saldoTotal - valor;
        return saldoTotal;
    }

    /*
     * @return saldo
     */
    public double saldo(){
        return saldo;
    }
    
    
}

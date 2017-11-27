/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.simuladorbancario.rest.services;

import co.edu.sena.simuladorbancario.entities.CuentaAhorros;
import co.edu.sena.simuladorbancario.entities.Usuarios;
import co.edu.sena.simuladorbancario.sessions.CuentaAhorrosFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import javax.ws.rs.core.Response;

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
    public void create(
        @QueryParam("saldo") double saldo,
        @QueryParam("saldoTotal") double saldoTotal){
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        CuentaAhorros newCahorros = new CuentaAhorros();
        Usuarios newUsuarios = new Usuarios();
        
        try{
            newCahorros.setRetirar(retirarValor(newUsuarios.getSaldoTotal(), saldo));
            newCahorros.setConsignar(consignarValor(newUsuarios.getSaldoTotal(), saldo));
            newCahorros.setSaldo(saldo);
            newCahorros.setInteresMensual(interesMensual);
            newCahorros.setIdUsuarios(newUsuarios);
        }catch (Exception e) {
      
        }        
    }
    
    /**
     * Saldo actual de la cuenta de ahorro
     */
    private double saldo;
    /**
     * Interés mensual que paga la cuenta de ahorro: P. ej. 0.6% = 0,006
     */
    private double interesMensual;
    /**
     * Inicializa la cuenta de ahorro con el interés mensual que paga el banco
     */
    public void calcularValores(){
        //Saldo inicial de la cuenta de ahorro
        saldo = 0;
        interesMensual = interesMensual();
    }

    public double saldo(){
        return saldo;
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
     * Retira una cantidad de dinero de la cuenta de ahorro
     * @param valor - el valor a retirar de la cuenta
     */
    private double retirarValor(double saldoTotal, double valor){
        saldoTotal = saldoTotal - valor;
        return saldoTotal;
    }

    /**
     * Modifica el saldo, sumándole los intereses (ha pasado un mes). 
     * post: El saldo actual crece en el porcentaje de interés mensual 
     * respectivo
     */
    public void actualizarSaldoPorPasoMes( )
    {
        saldo = ( double ) ( saldo + ( saldo * interesMensual ) );
    }

    /**
     * Da el interés que paga el banco mensualmente por este tipo de cuentas 
     * post: Retorna el valor actual de la tasa de interés. 
     * 
     * @return interés mensual de la cuenta de ahorros
     */
    private double interesMensual(){
        return 0.006;
    }
    
}

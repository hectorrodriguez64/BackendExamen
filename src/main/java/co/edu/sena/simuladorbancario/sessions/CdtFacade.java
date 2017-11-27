/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.simuladorbancario.sessions;

import co.edu.sena.simuladorbancario.entities.Cdt;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adsi1261718
 */
@Stateless
public class CdtFacade extends AbstractFacade<Cdt> {

    @PersistenceContext(unitName = "co.edu.sena.simuladorBancario_SimuladorBancario_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CdtFacade() {
        super(Cdt.class);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.so.trening;

import rs.ac.bg.fon.ai.projekat_teretana.db.DBBroker;
import rs.ac.bg.fon.ai.projekat_teretana.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat_teretana.domain.Trening;
import rs.ac.bg.fon.ai.projekat_teretana.so.AbstractSO;



/**
 *
 * @author Stefan
 */
public class SOLoadTrening extends AbstractSO{

    private Trening trening;
    @Override
    protected void validate(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        if (!(ado instanceof Trening)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Trening!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        
        AbstractDomainObject object;
        object=DBBroker.getInstance().selectObject(ado);
        trening=(Trening) object;
    }

    public Trening getTrening() {
        return trening;
    }
    
    
}

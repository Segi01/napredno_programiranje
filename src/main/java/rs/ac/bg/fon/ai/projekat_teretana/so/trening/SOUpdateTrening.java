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
public class SOUpdateTrening extends AbstractSO{

   private int affectedRows;

    public int getAffectedRows() {
        return affectedRows;
    }
    
   
    
    @Override
    protected void validate(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        if (!(ado instanceof Trening)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Trening!");
        }
        
        Trening trening=(Trening) ado;
        
        
        if(trening.getTrener()==null)
            throw new Exception("Niste selektovali ni jednog trenera");
        
        
        if(trening.getTrajanjeUMin()<=0 || trening.getTrajanjeUMin()>90)
            throw new Exception("Trajanje treninga mora biti broj veci od nule i manje od 90 min");
        
    }

    @Override
    protected void execute(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        
        affectedRows=DBBroker.getInstance().update(ado);
        
        
    }
    
}

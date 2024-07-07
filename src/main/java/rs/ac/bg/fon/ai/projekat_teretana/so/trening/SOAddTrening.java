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
public class SOAddTrening extends AbstractSO{

    private int id;

    public int getId() {
        return id;
    }
    
    
    
    @Override
    protected void validate(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        
        if (!(ado instanceof Trening)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Trening!");
        }
        
//        Trening trening=(Trening) ado;
//        
//        if(trening.getTip()==null)
//            throw new Exception("Niste selektovali ni jedan tip");
//        if(trening.getTrener()==null)
//            throw new Exception("Niste selektovali ni jednog trenera");
//        
//        if(trening.getCena()<=0)
//            throw new Exception("Cena ne sme biti negativan broj ili jednaka nuli");
//        if(trening.getTrajanjeUMin()<=0 || trening.getTrajanjeUMin()>90)
//            throw new Exception("Trajanje treninga mora biti broj veci od nule i manje od 90 min");
//        
    }

    @Override
    protected void execute(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        
        id=DBBroker.getInstance().insert(ado);
    }
    
}

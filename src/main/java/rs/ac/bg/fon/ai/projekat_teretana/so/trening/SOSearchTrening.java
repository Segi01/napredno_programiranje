/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.so.trening;

import rs.ac.bg.fon.ai.projekat_teretana.db.DBBroker;
import rs.ac.bg.fon.ai.projekat_teretana.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat_teretana.domain.Trening;
import rs.ac.bg.fon.ai.projekat_teretana.so.AbstractSO;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Stefan
 */
public class SOSearchTrening extends AbstractSO {

    List<Trening> treninzi;
    
    @Override
    protected void validate(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        if (!(ado instanceof Trening)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Trening!");
        }
        Trening trening=(Trening) ado;
        
        
//        if(trening.getTip()==null)
//            throw new Exception("Niste selektovali ni jedan tip!!!");
        
//        if(trening.getCena()<=0)
//            throw new Exception("Cena ne sme biti negativan broj ili jednaka nuli");
    }

    @Override
    protected void execute(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        
        List<AbstractDomainObject> lista=DBBroker.getInstance().selectList(ado);
        treninzi=(ArrayList<Trening>)(ArrayList<?>)lista;
    }

    public List<Trening> getTreninzi() {
        return treninzi;
    }
    
    
}

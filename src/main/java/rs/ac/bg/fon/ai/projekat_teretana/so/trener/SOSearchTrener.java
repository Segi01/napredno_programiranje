/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.so.trener;

import rs.ac.bg.fon.ai.projekat_teretana.db.DBBroker;
import rs.ac.bg.fon.ai.projekat_teretana.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat_teretana.domain.Trener;
import rs.ac.bg.fon.ai.projekat_teretana.so.AbstractSO;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Stefan
 */
public class SOSearchTrener extends AbstractSO{

    private List<Trener> treneri;
    
    @Override
    protected void validate(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        
         if (ado==null || !(ado instanceof Trener)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Trener!");
        }
         Trener trener=(Trener) ado;
         
//         if (trener.getIme().isEmpty()){
//             throw new Exception("Niste popunili polje ime!!");
//         }
        
         if(!trener.getIme().isEmpty() &&(
                 !trener.getIme().matches("[a-zA-Z]+") || !Character.isUpperCase(trener.getIme().charAt(0))))
             throw new IllegalArgumentException("Ime nije u dobrom formatu!!!");
    }

    @Override
    protected void execute(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        
        
       List<AbstractDomainObject> lista=DBBroker.getInstance().selectList(ado);
       treneri=(ArrayList<Trener>)(ArrayList<?>)lista;
        
    }

    public List<Trener> getTreneri() {
        return treneri;
    }
    
    
    
}

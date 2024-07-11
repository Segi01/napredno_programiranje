/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.so.trener;

import rs.ac.bg.fon.ai.projekat_teretana.db.DBBroker;
import rs.ac.bg.fon.ai.projekat_teretana.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat_teretana.domain.Trener;
import rs.ac.bg.fon.ai.projekat_teretana.so.AbstractSO;



/**
 *
 * @author Stefan
 */
public class SOAddTrener extends AbstractSO{

    private int id;
    @Override
    protected void validate(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        
        if (ado==null || !(ado instanceof Trener)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Trener!");
        }
        
//        Trener trener=(Trener) ado;
//         if (trener.getIme().isEmpty() || trener.getPrezime().isEmpty() || trener.getKontakt().isEmpty()
//                    ) {
//                throw new Exception("Niste popunili sva polja!!!");
//            }
//         if(trener.getGodineIskustva()>50 || trener.getGodineIskustva()<0){
//             throw new Exception("Godine iskustva moraju biti manje od 50!!");
//         }
//        
//         if(!trener.getIme().matches("[a-zA-Z]+") || !Character.isUpperCase(trener.getIme().charAt(0)))
//             throw new Exception("Ime nije u dobrom formatu!!!");
//         
//         if(!trener.getPrezime().matches("[a-zA-Z]+") || !Character.isUpperCase(trener.getPrezime().charAt(0)))
//             throw new Exception("Prezime nije u dobrom formatu!!!");
//         
//         if(!trener.getKontakt().matches("[\\d]+") || !trener.getKontakt().startsWith("06") 
//               || (trener.getKontakt().length()!=9 && trener.getKontakt().length()!=10))
//             throw new Exception("Kontakt nije u dobrom formatu!!!");
         
        
          
        
    }

    @Override
    protected void execute(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        
        id=DBBroker.getInstance().insert(ado);
//        Trener t=(Trener) ado;
//        t.setIdTrenera(id);
        
        
        
        
        
    }

    public int getId() {
        return id;
    }
    
    
    
}

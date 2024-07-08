/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.so.rezultat_korisnika;

import rs.ac.bg.fon.ai.projekat_teretana.db.DBBroker;
import rs.ac.bg.fon.ai.projekat_teretana.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat_teretana.domain.RezultatiKorisnika;
import rs.ac.bg.fon.ai.projekat_teretana.domain.Statistika;
import rs.ac.bg.fon.ai.projekat_teretana.so.AbstractSO;



/**
 *
 * @author Stefan
 */
public class SOAddRezultat extends AbstractSO {

    private int idRez;
    private int idStat;

    public int getIdStat() {
        return idStat;
    }
    
    

    public int getIdRez() {
        return idRez;
    }
    
    
    
    @Override
    protected void validate(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        
        if (ado==null || !(ado instanceof RezultatiKorisnika)) {
            throw new Exception("Prosledjeni objekat nije instanca klase RezultatKorisnika!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        
        
        RezultatiKorisnika rezKor=(RezultatiKorisnika) obj;
        Statistika s=rezKor.getStatistika();
        AbstractDomainObject ado1=s;
        idStat=DBBroker.getInstance().insert(ado1);
        
        s.setId(idStat);
        rezKor.setStatistika(s);
        
        
        AbstractDomainObject ado2=rezKor;
        idRez=DBBroker.getInstance().insert(ado2);
        
    }
    
    
    
}

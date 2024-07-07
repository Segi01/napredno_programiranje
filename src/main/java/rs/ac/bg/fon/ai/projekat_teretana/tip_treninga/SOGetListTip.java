/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.tip_treninga;

import rs.ac.bg.fon.ai.projekat_teretana.db.DBBroker;
import rs.ac.bg.fon.ai.projekat_teretana.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat_teretana.domain.TipTreninga;
import rs.ac.bg.fon.ai.projekat_teretana.so.AbstractSO;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Stefan
 */
public class SOGetListTip extends AbstractSO{

    private List<TipTreninga> tipovi;

    
    
    @Override
    protected void validate(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        if (!(ado instanceof TipTreninga)) {
            throw new Exception("Prosledjeni objekat nije instanca klase TipTreninga!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        
        List<AbstractDomainObject> lista=DBBroker.getInstance().selectList(ado);
        tipovi=(ArrayList<TipTreninga>)(ArrayList<?>)lista;
        
        
        
    }

    public List<TipTreninga> getTipovi() {
        return tipovi;
    }
    
}

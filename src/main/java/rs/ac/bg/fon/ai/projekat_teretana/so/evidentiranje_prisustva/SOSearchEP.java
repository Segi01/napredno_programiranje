/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.so.evidentiranje_prisustva;

import rs.ac.bg.fon.ai.projekat_teretana.db.DBBroker;
import rs.ac.bg.fon.ai.projekat_teretana.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat_teretana.domain.EvidentiranjePrisustva;
import rs.ac.bg.fon.ai.projekat_teretana.so.AbstractSO;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Stefan
 */
public class SOSearchEP extends AbstractSO {

    List<EvidentiranjePrisustva> prisustva;

    public List<EvidentiranjePrisustva> getPrisustva() {
        return prisustva;
    }

    @Override
    protected void validate(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;
        if (ado == null || !(ado instanceof EvidentiranjePrisustva)) {
            throw new Exception("Prosledjeni objekat nije instanca klase EvidentiranjePrisustva!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;
        List<AbstractDomainObject> lista=DBBroker.getInstance().selectList(ado);
        prisustva=(ArrayList<EvidentiranjePrisustva>)(ArrayList<?>)lista;

    }

}

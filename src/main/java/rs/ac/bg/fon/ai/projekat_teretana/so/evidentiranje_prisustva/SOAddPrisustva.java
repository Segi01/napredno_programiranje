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
public class SOAddPrisustva extends AbstractSO {

    private int id;
    ArrayList<Integer> nizId = new ArrayList<>();

    public ArrayList<Integer> getNizId() {
        return nizId;
    }

    @Override
    protected void validate(Object obj) throws Exception {
        List<AbstractDomainObject> lista = (List<AbstractDomainObject>) obj;
        for (AbstractDomainObject abstractDomainObject : lista) {
            if (abstractDomainObject == null || !(abstractDomainObject instanceof EvidentiranjePrisustva)) {
                throw new Exception("Prosledjeni objekat nije instanca klase EvidentiranjePrisustva!");
            }
        }
        
         

    }

    @Override
    protected void execute(Object obj) throws Exception {

        List<AbstractDomainObject> lista = (List<AbstractDomainObject>) obj;
        for (AbstractDomainObject abstractDomainObject : lista) {
            id = DBBroker.getInstance().insert(abstractDomainObject);
            nizId.add(id);
        }

    }

}

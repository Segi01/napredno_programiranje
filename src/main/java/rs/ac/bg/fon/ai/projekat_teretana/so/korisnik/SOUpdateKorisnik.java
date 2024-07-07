/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.so.korisnik;

import rs.ac.bg.fon.ai.projekat_teretana.db.DBBroker;
import rs.ac.bg.fon.ai.projekat_teretana.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat_teretana.domain.KT;
import rs.ac.bg.fon.ai.projekat_teretana.domain.Korisnik;
import rs.ac.bg.fon.ai.projekat_teretana.domain.TipTreninga;
import rs.ac.bg.fon.ai.projekat_teretana.so.AbstractSO;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Stefan
 */
public class SOUpdateKorisnik extends AbstractSO {

    int affectedRowsUpdate;
    int affectedRowsDelete;
    int idTipa;
    private ArrayList<Integer> nizId = new ArrayList<>();

    public int getAffectedRowsUpdate() {
        return affectedRowsUpdate;
    }

    public int getAffectedRowsDelete() {
        return affectedRowsDelete;
    }

    public ArrayList<Integer> getNizId() {
        return nizId;
    }

    @Override
    protected void validate(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        if (ado == null || !(ado instanceof Korisnik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Korisnik!");
        }

        
    }

    @Override
    protected void execute(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        affectedRowsUpdate = DBBroker.getInstance().update(ado);
        Korisnik k = (Korisnik) ado;
        KT kt = new KT();
        kt.setKorisnik(k);
        AbstractDomainObject ado1 = kt;
        affectedRowsDelete = DBBroker.getInstance().delete(ado1);

        List<TipTreninga> tipovi = k.getTipovi();
        for (TipTreninga tipTreninga : tipovi) {
            kt.setTip(tipTreninga);
            AbstractDomainObject ado2 = kt;
            idTipa = DBBroker.getInstance().insert(ado2);
            nizId.add(idTipa);

        }

    }
}

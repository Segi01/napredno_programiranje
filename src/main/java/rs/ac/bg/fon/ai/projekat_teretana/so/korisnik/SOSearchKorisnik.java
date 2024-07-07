/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.so.korisnik;

import rs.ac.bg.fon.ai.projekat_teretana.db.DBBroker;
import rs.ac.bg.fon.ai.projekat_teretana.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat_teretana.domain.Korisnik;
import rs.ac.bg.fon.ai.projekat_teretana.so.AbstractSO;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Stefan
 */
public class SOSearchKorisnik extends AbstractSO {

    List<Korisnik> korisnici;

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    @Override
    protected void validate(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        if (ado == null || !(ado instanceof Korisnik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Korisnik!");
        }
        Korisnik k = (Korisnik) ado;

        if (k.getTipovi().isEmpty()) {
            if (!k.getIme().isEmpty() && (!k.getIme().matches("[a-zA-Z]+") || !Character.isUpperCase(k.getIme().charAt(0)))) {
                throw new IllegalArgumentException("Ime nije u dobrom formatu!!!");
            }

            if (!k.getPrezime().isEmpty() && (!k.getPrezime().matches("[a-zA-Z]+") || !Character.isUpperCase(k.getPrezime().charAt(0)))) {
                throw new IllegalArgumentException("Prezime nije u dobrom formatu!!!");
            }
        }

    }

    @Override
    protected void execute(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        List<AbstractDomainObject> lista = DBBroker.getInstance().selectList(ado);
        korisnici = (ArrayList<Korisnik>) (ArrayList<?>) lista;

    }

}

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
public class SOAddKorisnik extends AbstractSO {

    private int idKorisnik;
    private int idTipa;
    private ArrayList<Integer> nizId = new ArrayList<>();

    public int getIdKorisnik() {
        return idKorisnik;
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

//        Korisnik k = (Korisnik) ado;
//        if (k.getAdresa().isEmpty() || k.getKontakt().isEmpty() || k.getIme().isEmpty()
//                || k.getPrezime().isEmpty()) {
//            throw new Exception("Niste popunili sva polja!!!");
//        }
//        if (k.getGrad() == null) {
//            throw new Exception("Morate selektovati neki grad!!!");
//        }
//        if (k.getTipovi().isEmpty()) {
//            throw new Exception("Korisnik mora imati barem jedan tip!!");
//        }
//        if (!k.getIme().matches("[a-zA-Z]+") || !Character.isUpperCase(k.getIme().charAt(0))) {
//            throw new Exception("Ime nije u dobrom formatu!!!");
//        }

//        if (!k.getPrezime().matches("[a-zA-Z]+") || !Character.isUpperCase(k.getPrezime().charAt(0))) {
//            throw new Exception("Prezime nije u dobrom formatu!!!");
//        }
//
//        if (!k.getKontakt().matches("[\\d]+") || !k.getKontakt().startsWith("06")
//                || (k.getKontakt().length() != 9 && k.getKontakt().length() != 10)) {
//            throw new Exception("Kontakt nije u dobrom formatu!!!");
//        }
        

    }

    @Override
    protected void execute(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        idKorisnik = DBBroker.getInstance().insert(ado);
        Korisnik k = (Korisnik) ado;
        List<TipTreninga> tipovi = k.getTipovi();
        KT kt=new KT();
        kt.setKorisnik(k);
        kt.getKorisnik().setIdKorisnika(idKorisnik);
        
        
        
        for (TipTreninga tipTreninga : tipovi) {
            kt.setTip(tipTreninga);
            AbstractDomainObject ado1=kt;
//            idTipa = DBBroker.getInstance().insertTip(tipTreninga, idKorisnik);
            idTipa=DBBroker.getInstance().insert(ado1);
            nizId.add(idTipa);

        }

    }

}

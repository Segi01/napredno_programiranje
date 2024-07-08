/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Stefan
 */
public class EvidentiranjePrisustva extends AbstractDomainObject {

    private Trening trening;
    private Korisnik korisnik;
    private int potroseneKal;
    private int otkucajiSrca;
    private TipTreninga pomocna;
    

    public EvidentiranjePrisustva() {
    }

    public EvidentiranjePrisustva(Trening trening, Korisnik korisnik, int potroseneKal, int otkucajiSrca) {
        this.trening = trening;
        this.korisnik = korisnik;
        this.potroseneKal = potroseneKal;
        this.otkucajiSrca = otkucajiSrca;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        if(trening==null)
            throw new NullPointerException("Trening ne sme biti null");
        this.trening = trening;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        if(korisnik==null)
            throw new NullPointerException("Korisnik ne sme biti null");
        this.korisnik = korisnik;
    }

    public int getPotroseneKal() {
        return potroseneKal;
    }

    public void setPotroseneKal(int potroseneKal) {
        if(potroseneKal<0){
            throw new IllegalArgumentException("Potrosene kalorije ne mogu biti negativan broj");
        }
        this.potroseneKal = potroseneKal;
    }

    public int getOtkucajiSrca() {
        return otkucajiSrca;
    }

    public void setOtkucajiSrca(int otkucajiSrca) {
        if(otkucajiSrca<0)
            throw new IllegalArgumentException("Otkucaji srca moraju biti veci od nule");
        this.otkucajiSrca = otkucajiSrca;
    }

    @Override
    public String toString() {
        return "EvidentiranjePrisustva{" + "trening=" + trening + ", korisnik=" + korisnik + ", potroseneKal=" + potroseneKal + ", otkucajiSrca=" + otkucajiSrca + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EvidentiranjePrisustva other = (EvidentiranjePrisustva) obj;
        if (!Objects.equals(this.trening, other.trening)) {
            return false;
        }
        return Objects.equals(this.korisnik, other.korisnik);
    }
    
    

    @Override
    public String tableName() {
        return " evidentiranje_prisustva ";
    }

    @Override
    public String alies() {
        return " ep ";
    }

    @Override
    public String textJoin() {
        return " JOIN korisnik k ON ep.idKorisnika = k.idKorisnika "
                + "JOIN kt ON ep.idKorisnika = kt.idKorisnika "
                + "JOIN tip_treninga t ON kt.idTipa = t.idTipa "
                + "JOIN trening tr ON ep.idTreninga=tr.idTreninga "
                + "JOIN grad g ON k.idGrada=g.idGrada "
                + "JOIN trener trn ON tr.idTrenera=trn.idTrenera";
    }

    @Override
    public String insertColumns() {

        return " (idTreninga,idKorisnika,potroseneKalorije,otkucajiSrca)";
    }

    @Override
    public String insertValues() {

        return trening.getIdTreninga() + "," + korisnik.getIdKorisnika()
                + "," + potroseneKal + "," + otkucajiSrca;
    }

    @Override
    public String updateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String requiredCondition() {
        
        
        return " idTreninga="+trening.getIdTreninga();
    }

    @Override
    public String conditionForSelect() {
        
        pomocna=trening.getTip();
//        System.out.println(6);
//        System.out.println(trening.getIdTreninga());
        //System.out.println(trening.getTip());
        return " WHERE ep.idTreninga= " + trening.getIdTreninga();
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {

        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        Map<Integer, Korisnik> korisnici = new HashMap<>();
        Map<Integer, Trening> treninzi = new HashMap<>();
        Map<Integer, EvidentiranjePrisustva> prisustva = new HashMap<>();

        while (rs.next()) {

            int idK = rs.getInt("k.idKorisnika");
            String imeK = rs.getString("k.ime");
            String prezimeK = rs.getString("k.prezime");
            String adresaK = rs.getString("k.adresa");
            java.sql.Date datumSql = rs.getDate("k.datumRodjenja");
            java.util.Date datumRodjenjaK = new java.util.Date(datumSql.getTime());
            String kontaktK = rs.getString("k.kontakt");
            int idGrada = rs.getInt("g.idGrada");
            String nazivGrada = rs.getString("g.nazivGrada");
            Grad g = new Grad(idGrada, nazivGrada);

            int idTipa = rs.getInt("t.idTipa");
            String nazivTipa = rs.getString("t.nazivTipa");
            String opis = rs.getString("t.opis");
            TipTreninga tip = new TipTreninga(idTipa, nazivTipa, opis);

            int idTrn = rs.getInt("trn.idTrenera");
            String imeTrenera = rs.getString("trn.ime");
            String prezimeTrenera = rs.getString("trn.prezime");
            String kontaktTrenera = rs.getString("trn.kontakt");
            boolean sertifikat = rs.getBoolean("trn.sertifikat");
            int godinaIskustva = rs.getInt("trn.godinaIskustva");

            Trener t = new Trener(idTrn, imeTrenera, prezimeTrenera, kontaktTrenera,
                    sertifikat, godinaIskustva);

            int idTreninga = rs.getInt("tr.idTreninga");
            int cena = rs.getInt("tr.cena");
            java.sql.Date datumTrnSQL = rs.getDate("tr.datumTreninga");
            java.util.Date datumTreninga = new java.util.Date(datumTrnSQL.getTime());
            int trajanjeTr = rs.getInt("tr.trajanjeUMin");

            Trening tren = treninzi.get(idTreninga);
            if (tren == null) {
                tren = new Trening();
                tren.setCena(cena);
                tren.setDatumTreninga(datumTreninga);
                tren.setIdTreninga(idTreninga);
                tren.setTrener(t);
                tren.setTrajanjeUMin(trajanjeTr);
                tren.setTip(pomocna);  
                treninzi.put(idTreninga, tren);
            }

            Korisnik k = korisnici.get(idK);
            if (k == null) {
                k = new Korisnik();
                k.setIme(imeK);
                k.setPrezime(prezimeK);
                k.setAdresa(adresaK);
                k.setKontakt(kontaktK);
                k.setIdKorisnika(idK);
                k.setDatumRodjenja(datumRodjenjaK);
                k.setGrad(g);
                korisnici.put(idK, k);
            }

            //korisnik.getTipovi().add(tip);
            int potroseneKalorije = rs.getInt("ep.potroseneKalorije");
            int otkucajiS = rs.getInt("ep.otkucajiSrca");

            EvidentiranjePrisustva ep = prisustva.get(idK);
            if (ep == null) {

                ep = new EvidentiranjePrisustva();
                ep.setKorisnik(k);
                ep.setTrening(tren);
                ep.setOtkucajiSrca(otkucajiS);
                ep.setPotroseneKal(potroseneKalorije);
                prisustva.put(idK, ep);
            }
            ep.getKorisnik().getTipovi().add(tip);
        }
        lista.addAll(prisustva.values());
        return lista;
    }

    @Override
    public String getIdCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

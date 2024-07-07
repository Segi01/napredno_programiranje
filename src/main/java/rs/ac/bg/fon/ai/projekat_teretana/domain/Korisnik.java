/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Stefan
 */
public class Korisnik extends AbstractDomainObject {

    private int idKorisnika;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String adresa;
    private String kontakt;
    private Grad grad;
    private List<TipTreninga> tipovi = new ArrayList<>();
    private static final long serialVersionUID = 123456789;

    public Korisnik() {
    }

    public Korisnik(int idKorisnika, String ime, String prezime, Date datumRodjenja, String adresa, String kontakt, Grad grad, List<TipTreninga> tipovi) {
        this.idKorisnika = idKorisnika;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.adresa = adresa;
        this.kontakt = kontakt;
        this.grad = grad;
        this.tipovi = tipovi;

    }

    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {

        if (!validateIme(ime)) {
            throw new IllegalArgumentException("Ime nije u dobrom formatu");
        }

        if (ime == null) {
            throw new NullPointerException("Ime ne sme biti null");
        }
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {

        if (!validatePrezime(prezime)) {
            throw new IllegalArgumentException("Prezime nije u dobrom formatu");
        }

        if (prezime == null) {
            throw new NullPointerException("Prezime ne sme biti null");
        }
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        
         if(datumRodjenja==null)
            throw new NullPointerException("Datum ne sme biti null");
        
        if(datumRodjenja.after(new Date()))
            throw new IllegalArgumentException("Datum rodjenja se ne sme odnositi na buducnost");
        this.datumRodjenja = datumRodjenja;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        if(adresa==null)
            throw new NullPointerException("Adresa ne sme biti null");
        if(adresa.isEmpty()){
            throw new IllegalArgumentException("Adresa ne sme biti prazan string");
        }
        this.adresa = adresa;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {

        if (!validateKontakt(kontakt)) {
            throw new IllegalArgumentException("Kontakt nije u dobrom formatu");
        }

        if (kontakt == null) {
            throw new NullPointerException("Kontakt ne sme biti null");
        }
        this.kontakt = kontakt;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        if(grad==null){
            throw new NullPointerException("Ne sme grad biti null");
        }
        this.grad = grad;
    }

    public List<TipTreninga> getTipovi() {
        return tipovi;
    }

    public void setTipovi(List<TipTreninga> tipovi) {
        
        if(tipovi==null){
            throw new NullPointerException("Tipovi ne smeju biti null");
        }
        if(tipovi.isEmpty())
            throw new IllegalArgumentException("Korisnik mora imati barem jedan tip treninga");
        this.tipovi = tipovi;
    }

//    public List<RezultatiKorisnika> getRezultati() {
//        return rezultati;
//    }
//
//    public void setRezultati(List<RezultatiKorisnika> rezultati) {
//        this.rezultati = rezultati;
//    }
    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return Objects.equals(this.kontakt, other.kontakt);
    }

    

    @Override
    public String tableName() {
        return " korisnik ";
    }

    @Override
    public String alies() {
        return " k ";
    }

    @Override
    public String textJoin() {
        return " JOIN kt ON k.idKorisnika=kt.idKorisnika JOIN tip_treninga tt ON kt.idTipa=tt.idTipa "
                + "JOIN grad g ON k.idGrada=g.idGrada";
    }

    @Override
    public String insertColumns() {
        return " (ime,prezime,datumRodjenja,adresa,kontakt,idGrada) ";
    }

    @Override
    public String insertValues() {

        return "'" + ime + "', '" + prezime + "', '"
                + datumRodjenja + "', '" + adresa + "', '" + kontakt + "', "
                + grad.getIdGrada();
        //('stefan', 'segrt', '05.02.2001', 'hercegovacka',
    }

    @Override
    public String updateValues() {

        return " adresa= '" + adresa + "', kontakt = '" + kontakt + "'";
    }

    @Override
    public String requiredCondition() {

        return " idKorisnika=" + idKorisnika;
    }

    @Override
    public String conditionForSelect() {

        if (ime == null && prezime == null && kontakt == null && adresa == null && tipovi.isEmpty() && datumRodjenja == null) {
            return "";
        }

        if (!tipovi.isEmpty()) {
            return " WHERE tt.idTipa= " + tipovi.get(0).getIdTipa();
        }
        if ((ime == null || ime.isEmpty()) && prezime != null) {
            return " WHERE k.prezime LIKE '" + prezime + "%'";
        }
        if ((prezime == null || prezime.isEmpty()) && ime != null) {
            return " WHERE k.ime LIKE '" + ime + "%'";
        }
        return " WHERE k.ime LIKE '" + ime + "%' and k.prezime LIKE '" + prezime + "%'";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {

        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        Map<Integer, Korisnik> korisnici = new HashMap<>();

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

            Korisnik korisnik = korisnici.get(idK);
            if (korisnik == null) {
                korisnik = new Korisnik();
                korisnik.setIme(imeK);
                korisnik.setPrezime(prezimeK);
                korisnik.setAdresa(adresaK);
                korisnik.setKontakt(kontaktK);
                korisnik.setIdKorisnika(idK);
                korisnik.setDatumRodjenja(datumRodjenjaK);
                korisnik.setGrad(g);
                korisnici.put(idK, korisnik);
            }

            int idTipa = rs.getInt("tt.idTipa");
            String nazivTipa = rs.getString("tt.nazivTipa");
            String opis = rs.getString("tt.opis");
            TipTreninga tip = new TipTreninga(idTipa, nazivTipa, opis);

            korisnik.getTipovi().add(tip);

        }
        lista.addAll(korisnici.values());
        return lista;
    }

    @Override
    public String getIdCondition() {

        return " WHERE kt.idKorisnika= " + idKorisnika;
    }

    private boolean validateIme(String ime) {

        if (!ime.matches("[a-zA-Z]+") || !Character.isUpperCase(ime.charAt(0))) {
            return false;
        }
        return true;
    }

    private boolean validatePrezime(String prezime) {

        if (!prezime.matches("[a-zA-Z]+") || !Character.isUpperCase(prezime.charAt(0))) {
            return false;
        }
        return true;

    }

    private boolean validateKontakt(String kontakt) {

        if (!kontakt.matches("[\\d]+") || !kontakt.startsWith("06")
                || (kontakt.length() != 9 && kontakt.length() != 10)) {
            return false;
        }
        return true;
    }

}

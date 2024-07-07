/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Stefan
 */
public class RezultatiKorisnika extends AbstractDomainObject {
    
    
    private int idRez;
    private Korisnik korisnik;
    private double procenatMasti;
    private double procenatMisica;
    private double tezinaUKG;
    private Date datumRezultata;

    public RezultatiKorisnika() {
    }

    public RezultatiKorisnika(int idRez, Korisnik korisnik, double procenatMasti, double procenatMisica, double tezinaUKG, Date datumRezultata) {
        this.idRez = idRez;
        this.korisnik = korisnik;
        this.procenatMasti = procenatMasti;
        this.procenatMisica = procenatMisica;
        this.tezinaUKG = tezinaUKG;
        this.datumRezultata = datumRezultata;
    }

    public int getIdRez() {
        return idRez;
    }

    public void setIdRez(int idRez) {
        this.idRez = idRez;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public double getProcenatMasti() {
        return procenatMasti;
    }

    public void setProcenatMasti(double procenatMasti) {
        this.procenatMasti = procenatMasti;
    }

    public double getProcenatMisica() {
        return procenatMisica;
    }

    public void setProcenatMisica(double procenatMisica) {
        this.procenatMisica = procenatMisica;
    }

    public double getTezinaUKG() {
        return tezinaUKG;
    }

    public void setTezinaUKG(double tezinaUKG) {
        this.tezinaUKG = tezinaUKG;
    }

    public Date getDatumRezultata() {
        return datumRezultata;
    }

    public void setDatumRezultata(Date datumRezultata) {
        this.datumRezultata = datumRezultata;
    }

    @Override
    public String toString() {
        return "RezultatiKorisnika{" + "idRez=" + idRez + ", korisnik=" + korisnik + ", procenatMasti=" + procenatMasti + ", procenatMisica=" + procenatMisica + ", tezinaUKG=" + tezinaUKG + ", datumRezultata=" + datumRezultata + '}';
    }

    @Override
    public String tableName() {
        return " postignuti_rezultati ";
    }

    @Override
    public String alies() {
        return " pr ";
    }

    @Override
    public String textJoin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String insertColumns() {
        
        return " (idKorisnika,procenatMasti,procenatMisica,tezinaUKg,datumRezultata) ";
    }

    @Override
    public String insertValues() {
        return korisnik.getIdKorisnika()+","+procenatMasti+","+procenatMisica+","+
                tezinaUKG+",'"+datumRezultata+"'";
    }

    @Override
    public String updateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String requiredCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String conditionForSelect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    @Override
    public String getIdCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
    
    
    
    
    
    
    
    
}

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
    private Date datumRezultata;
    private Statistika statistika;

    public RezultatiKorisnika() {
    }

    public RezultatiKorisnika(int idRez, Korisnik korisnik, Date datumRezultata, Statistika statistika) {
        this.idRez = idRez;
        this.korisnik = korisnik;
        this.datumRezultata = datumRezultata;
        this.statistika = statistika;
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


    public Date getDatumRezultata() {
        return datumRezultata;
    }

    public void setDatumRezultata(Date datumRezultata) {
        this.datumRezultata = datumRezultata;
    }

    public Statistika getStatistika() {
        return statistika;
    }

    public void setStatistika(Statistika statistika) {
        this.statistika = statistika;
    }
    
    
    

    @Override
    public String toString() {
        return "RezultatiKorisnika{" + "idRez=" + idRez + ", korisnik=" + korisnik + ", datumRezultata=" + datumRezultata + '}';
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
        
        return " (idKorisnika,datumRezultata,idStatistike) ";
    }

    @Override
    public String insertValues() {
        return korisnik.getIdKorisnika()+",'"+datumRezultata+"'"+","+statistika.getId();
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

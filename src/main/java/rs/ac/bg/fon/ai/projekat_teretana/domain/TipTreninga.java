/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.domain;

import com.google.gson.annotations.Expose;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Stefan
 */
public class TipTreninga extends AbstractDomainObject {

    private int idTipa;
    private String nazivTipa;
    private String opis;
    private static final long serialVersionUID=1234567890;

    public TipTreninga() {
    }

    public TipTreninga(int idTipa, String nazivTipa, String opis) {
        this.idTipa = idTipa;
        this.nazivTipa = nazivTipa;
        this.opis = opis;
       
    }

    public int getIdTipa() {
        return idTipa;
    }

    public void setIdTipa(int idTipa) {
        this.idTipa = idTipa;
    }

    public String getNazivTipa() {
        return nazivTipa;
    }

    public void setNazivTipa(String nazivTipa) {
        
        if(nazivTipa==null)
            throw new NullPointerException("Naziv ne sme biti null");
        if(nazivTipa.isEmpty())
            throw new IllegalArgumentException("Naziv ne sme biti prazan string");
        
        this.nazivTipa = nazivTipa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        
        if(opis==null)
            throw new NullPointerException("Opis ne sme biti null");
        if(opis.isEmpty())
            throw new IllegalArgumentException("Opis ne sme biti prazan string");
        
        this.opis = opis;
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
        final TipTreninga other = (TipTreninga) obj;
        return Objects.equals(this.nazivTipa, other.nazivTipa);
    }

    
    
    
    

//    public List<Korisnik> getKorisnici() {
//        return korisnici;
//    }
//
//    public void setKorisnici(List<Korisnik> korisnici) {
//        this.korisnici = korisnici;
//    }

    @Override
    public String toString() {
        return nazivTipa;
    }

    @Override
    public String tableName() {
        return " tip_treninga ";
    }

    @Override
    public String alies() {
        return " tt ";
    }

    @Override
    public String textJoin() {

        return "";

    }

    @Override
    public String insertColumns() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String insertValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        
        return "";

    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {

        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            int id = rs.getInt("idTipa");
            String naziv = rs.getString("nazivTipa");
            String opis = rs.getString("opis");

            TipTreninga tt = new TipTreninga(id, naziv, opis);

            lista.add(tt);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getIdCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

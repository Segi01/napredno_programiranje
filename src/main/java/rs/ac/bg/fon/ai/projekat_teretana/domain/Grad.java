/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Stefan
 */
public class Grad extends AbstractDomainObject {
    
    private int idGrada;
    private String naziv;

    public Grad() {
    }

    public Grad(int idGrada, String naziv) {
        this.idGrada = idGrada;
        this.naziv = naziv;
    }

    public int getIdGrada() {
        return idGrada;
    }

    public void setIdGrada(int idGrada) {
        this.idGrada = idGrada;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        
        if(naziv==null)
            throw new NullPointerException("Naziv ne sme biti null");
        if(naziv.isEmpty())
            throw new IllegalArgumentException("Naziv ne sme biti prazan string");
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Grad other = (Grad) obj;
        return Objects.equals(this.naziv, other.naziv);
    }
    
    

    @Override
    public String tableName() {
        return " grad ";
    }

    @Override
    public String alies() {
        return " g ";
    }

    @Override
    public String textJoin() {
        return "";
    }

    @Override
    public String insertColumns() {
        return "";

    }

    @Override
    public String insertValues() {
        return "";
    }

    @Override
    public String updateValues() {
            return "";
    }

    @Override
    public String requiredCondition() {
        return "";
    }

    @Override
    public String conditionForSelect() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista=new ArrayList<>();
        
        while(rs.next()){
            
            int idGrada=rs.getInt("idGrada");
            String nazivGrada=rs.getString("nazivGrada");
            
            Grad g=new Grad(idGrada, nazivGrada);
            
            lista.add(g);
        }
        rs.close();
        return  lista;
        
    }

   

    @Override
    public String getIdCondition() {
        
        return "";
    }

  
    
    
    
}

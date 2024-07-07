/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Stefan
 */
public class Trener extends AbstractDomainObject {
    
    
    private int idTrenera;
    private String ime;
    private String prezime;
    private String kontakt;
    private Boolean sertifikat;
    private int godineIskustva;

    public Trener() {
    }

    public Trener(int idTrenera, String ime, String prezime, String kontakt, Boolean sertifikat, int godineIskustva) {
        this.idTrenera = idTrenera;
        this.ime = ime;
        this.prezime = prezime;
        this.kontakt = kontakt;
        this.sertifikat = sertifikat;
        this.godineIskustva = godineIskustva;
    }
    
    
    public int getIdTrenera() {
        return idTrenera;
    }

    public void setIdTrenera(int idTrenera) {
        this.idTrenera = idTrenera;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        
        
        if(!validateIme(ime))
            throw new IllegalArgumentException("Ime nije u dobrom formatu");
        
        if(ime==null)
            throw new NullPointerException("Ime ne sme biti null");
        
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        
        if(!validatePrezime(prezime))
            throw new IllegalArgumentException("Prezime nije u dobrom formatu");
        
        if(prezime==null)
            throw new NullPointerException("Prezime ne sme biti null");
        
        this.prezime = prezime;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        
        if(!validateKontakt(kontakt))
            throw new IllegalArgumentException("Kontakt nije u dobrom formatu");
        
        if(kontakt==null)
            throw new NullPointerException("Kontakt ne sme biti null");
        
        this.kontakt = kontakt;
    }

    public Boolean isSertifikat() {
        return sertifikat;
    }

    public void setSertifikat(Boolean sertifikat) {
        this.sertifikat = sertifikat;
    }

    public int getGodineIskustva() {
        return godineIskustva;
    }

    public void setGodineIskustva(int godineIskustva) {
        
       if(godineIskustva<0)
           throw new IllegalArgumentException("Godine ne smeju biti manje od nule");
        
        this.godineIskustva = godineIskustva;
    }
    
    public String toString() {
        return ime + " " + prezime;
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
        final Trener other = (Trener) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        return Objects.equals(this.prezime, other.prezime);
    }

    
    

    @Override
    public String tableName() {
        return " trener ";
    }

    @Override
    public String alies() {
        return " t ";
    }

    @Override
    public String textJoin() {
        
        return "";
    }

    @Override
    public String insertColumns() {
       return " (ime,prezime,kontakt,sertifikat,godinaIskustva) ";
    }

    @Override
    public String insertValues() {
        System.out.println(kontakt);
        return "'" + ime + "', '" + prezime + "', '"
                + kontakt + "', " + sertifikat + ", "
                + godineIskustva;
        
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
       
       if(ime==null && prezime==null && kontakt==null && sertifikat==null && godineIskustva==0)
            return "";
       if((ime==null || ime.isEmpty()) && sertifikat!=null)
           return " WHERE sertifikat="+sertifikat;
       if(!ime.isEmpty() && sertifikat==null)
           return " WHERE ime LIKE "+"'"+ime+"%"+"'";
      
       return " WHERE ime LIKE "+"'"+ime+"%"+"'" +" and "+" sertifikat= "+sertifikat;
       
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        
        ArrayList<AbstractDomainObject> lista=new ArrayList<>();
        
        while(rs.next()){
            
            int id=rs.getInt("idTrenera");
            String ime=rs.getString("ime");
            String prezime=rs.getString("prezime");
            String kontakt=rs.getString("kontakt");
            boolean sertifikat=rs.getBoolean("sertifikat");
            int godinaIsk=rs.getInt("godinaIskustva");
            
            Trener t=new Trener(id, ime, prezime, kontakt, sertifikat, godinaIsk);
            
            lista.add(t);
            
        }
        rs.close();
        return lista;
    }

   
    @Override
    public String getIdCondition() {
        
         return " WHERE t.idTrenera= "+idTrenera;
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

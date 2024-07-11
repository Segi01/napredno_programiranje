/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.domain;

import com.google.gson.annotations.Expose;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Stefan
 */
public class Trening extends AbstractDomainObject {

    private int idTreninga;
    private int cena;
    private Date datumTreninga;
    private int trajanjeUMin;
    private TipTreninga tip;
    private Trener trener;

    private int konstanta = 0;

    public Trening() {
    }

    public Trening(int idTreninga, int cena, Date datumTreninga, int trajanjeUMin, TipTreninga tip, Trener trener) {
        this.idTreninga = idTreninga;
        this.cena = cena;
        this.datumTreninga = datumTreninga;
        this.trajanjeUMin = trajanjeUMin;
        this.tip = tip;
        this.trener = trener;
    }

    public int getIdTreninga() {
        return idTreninga;
    }

    public void setIdTreninga(int idTreninga) {
        this.idTreninga = idTreninga;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        if (cena <= 0) {
            throw new IllegalArgumentException("Cena ne sme biti manja od nule");
        }
        this.cena = cena;
    }

    public Date getDatumTreninga() {
        return datumTreninga;
    }

    public void setDatumTreninga(Date datumTreninga) {

        if (datumTreninga == null) {
            throw new NullPointerException("Datum ne sme biti null");
        }

        if (datumTreninga.after(new Date())) {
            throw new IllegalArgumentException("Datum se ne sme odnositi na buducnost");
        }

        this.datumTreninga = datumTreninga;
    }

    public int getTrajanjeUMin() {
        return trajanjeUMin;
    }

    public void setTrajanjeUMin(int trajanjeUMin) {

        if (trajanjeUMin <= 0) {
            throw new IllegalArgumentException("Trajanje treninga mora biti pozitivan broj");
        }

        this.trajanjeUMin = trajanjeUMin;
    }

    public TipTreninga getTip() {
        return tip;
    }

    public void setTip(TipTreninga tip) {

        if (tip == null) {
            throw new NullPointerException("Tip ne sme biti null");
        }
        this.tip = tip;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        if (trener == null) {
            throw new IllegalArgumentException("Trener ne sme biti null");
        }
        this.trener = trener;
    }

    public void setKonstanta(int konstanta) {
        this.konstanta = konstanta;
    }

    public int getKonstanta() {
        return konstanta;
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return tip + " , " + sdf.format(datumTreninga) + " , " + trener;
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
        final Trening other = (Trening) obj;
        return Objects.equals(this.datumTreninga, other.datumTreninga);
    }

    @Override
    public String tableName() {
        return "trening";
    }

    @Override
    public String alies() {
        return " t ";

    }

    @Override
    public String textJoin() {
        if (konstanta == 1) {
            return "LEFT JOIN evidentiranje_prisustva ep ON t.idTreninga=ep.idTreninga JOIN trener tr ON t.idTrenera=tr.idTrenera "
                    + "JOIN tip_treninga tt ON t.idTipa=tt.idTipa";
        }

        return " JOIN trener tr on t.idTrenera=tr.idTrenera "
                + "JOIN tip_treninga tt on t.idTipa=tt.idTipa";
    }

    @Override
    public String insertColumns() {

        return " (cena,datumTreninga,trajanjeUMin,idTrenera,idTipa) ";
    }

    @Override
    public String insertValues() {

        return "'" + cena + "', '" + datumTreninga + "', "
                + " " + trajanjeUMin + ", " + trener.getIdTrenera() + ", "
                + tip.getIdTipa();
    }

    @Override
    public String updateValues() {
        return " trajanjeUMin= " + trajanjeUMin + ", idTrenera = " + trener.getIdTrenera();

    }

    @Override
    public String requiredCondition() {
        return " idTreninga=" + idTreninga;
    }

    @Override
    public String conditionForSelect() {

        if (cena == 0 && datumTreninga == null && trajanjeUMin == 0 && tip == null && trener == null && konstanta == 0) {
            return "";
        }

        if (cena == 0 && datumTreninga == null && trajanjeUMin == 0 && tip == null && trener == null && konstanta == 1) {
            return " WHERE ep.idTreninga IS NULL";
        }
        if (cena == 0 && tip != null) {
            return "WHERE t.idTipa= " + tip.getIdTipa();
        }
        if (cena != 0 && tip == null) {
            return " WHERE cena=" + cena;
        }
        return " WHERE t.idTipa= " + tip.getIdTipa() + " and " + "cena= " + cena;
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
//        Map<Integer, Trening> treninzi = new HashMap<>();

        while (rs.next()) {

            int idTrenera = rs.getInt("tr.idTrenera");
            String ime = rs.getString("tr.ime");
            String prezime = rs.getString("tr.prezime");
            String kontakt = rs.getString("tr.kontakt");
            boolean sertifikat = rs.getBoolean("tr.sertifikat");
            int godinaIskustva = rs.getInt("tr.godinaIskustva");

            Trener trener = new Trener(idTrenera, ime, prezime, kontakt, sertifikat, godinaIskustva);

            int idTipa = rs.getInt("tt.idTipa");
            String naziv = rs.getString("tt.nazivTipa");
            String opis = rs.getString("tt.opis");

            TipTreninga tip = new TipTreninga(idTipa, naziv, opis);

//            Trening trening = treninzi.get(idTreninga);
//            if (trening == null) {
            int idTreninga = rs.getInt("t.idTreninga");
            int cena = rs.getInt("t.cena");
            int trajanjeUMin = rs.getInt("t.trajanjeUMin");
            java.sql.Date datumSql = rs.getDate("t.datumTreninga");
            java.util.Date datumTreninga = new java.util.Date(datumSql.getTime());
            Trening trening = new Trening(idTreninga, cena, datumTreninga, trajanjeUMin, tip, trener);
//            treninzi.put(idTreninga, trening);
            lista.add(trening);
            // }

        }
//        lista.addAll(treninzi.values());
        rs.close();
        return lista;

    }

    @Override
    public String getIdCondition() {
        return " WHERE t.idTreninga= " + idTreninga;
    }

}

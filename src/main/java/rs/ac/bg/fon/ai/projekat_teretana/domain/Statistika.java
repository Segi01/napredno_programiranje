/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class Statistika extends AbstractDomainObject {

    private int id;
    private double procenatMasti;
    private double procenatMisica;
    private double tezinaUKG;

    public Statistika() {
    }

    public Statistika(int id, double procenatMasti, double procenatMisica, double tezinaUKG) {
        this.id = id;
        this.procenatMasti = procenatMasti;
        this.procenatMisica = procenatMisica;
        this.tezinaUKG = tezinaUKG;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Statistika{" + "procenatMasti=" + procenatMasti + ", procenatMisica=" + procenatMisica + ", tezinaUKG=" + tezinaUKG + '}';
    }

    @Override
    public String tableName() {
        return "statistika";
    }

    @Override
    public String alies() {
        return "s";
    }

    @Override
    public String textJoin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String insertColumns() {

        return " (procenatMasti,procenatMisica,tezinaUKG) ";
    }

    @Override
    public String insertValues() {

        return procenatMasti + "," + procenatMisica + "," + tezinaUKG;
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
    public String getIdCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

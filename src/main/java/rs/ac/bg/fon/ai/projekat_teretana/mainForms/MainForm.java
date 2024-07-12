/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.mainForms;

import java.io.IOException;
import rs.ac.bg.fon.ai.projekat_teretana.controller.ClientController;
import rs.ac.bg.fon.ai.projekat_teretana.domain.Administrator;
import rs.ac.bg.fon.ai.projekat_teretana.formEvidencijaPrisustva.EvidencijaPrisustvaForm;
import rs.ac.bg.fon.ai.projekat_teretana.formEvidencijaPrisustva.constants.MyConstantsEvidencija;
import rs.ac.bg.fon.ai.projekat_teretana.formKorisnik.FormPretraziKorisnike;
import rs.ac.bg.fon.ai.projekat_teretana.formKorisnik.KorisnikForm;
import rs.ac.bg.fon.ai.projekat_teretana.formKorisnik.constants.MyConstantsKorisnik;
import rs.ac.bg.fon.ai.projekat_teretana.formRezultat.RezultatForm;
import rs.ac.bg.fon.ai.projekat_teretana.formTrener.FormPretraziTrenere;
import rs.ac.bg.fon.ai.projekat_teretana.formTrener.TrenerForm;
import rs.ac.bg.fon.ai.projekat_teretana.formTrener.constants.MyConstantsTrener;
import rs.ac.bg.fon.ai.projekat_teretana.formTrening.FormPretraziTreninge;
import rs.ac.bg.fon.ai.projekat_teretana.formTrening.TreningForm;
import rs.ac.bg.fon.ai.projekat_teretana.formTrening.constants.MyConstantsTrening;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



/**
 *
 * @author Stefan Segrt
 */
public class MainForm extends javax.swing.JFrame {

    Administrator a;

    /**
     * Creates new form MainForm
     */
    public MainForm(Administrator a) {
        initComponents();
        this.a = a;
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle(a.getKorisnickoIme());
        setLocationRelativeTo(null);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOdjaviSe = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        meniKreirajTrenera = new javax.swing.JMenuItem();
        meniPretraziTrenera = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        meniKreirajTrening = new javax.swing.JMenuItem();
        meniIzmenaPodTreninga = new javax.swing.JMenuItem();
        meniObrisiTrening = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        meniKreiranjeKorisnika = new javax.swing.JMenuItem();
        meniPretraziKorisnike = new javax.swing.JMenuItem();
        meniIzmenaPodatakaKor = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        meniEvidentiranjePrisustva = new javax.swing.JMenuItem();
        meniIzmenaPodOEvidentiranju = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        meniKreirajRezKorisnika = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOdjaviSe.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnOdjaviSe.setForeground(new java.awt.Color(0, 0, 0));
        btnOdjaviSe.setText("Odjavi se");
        btnOdjaviSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdjaviSeActionPerformed(evt);
            }
        });
        getContentPane().add(btnOdjaviSe, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, -1, -1));

        jMenu1.setText("Trener");

        meniKreirajTrenera.setText("Kreiraj trenera");
        meniKreirajTrenera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniKreirajTreneraActionPerformed(evt);
            }
        });
        jMenu1.add(meniKreirajTrenera);

        meniPretraziTrenera.setText("Pretrazi trenera");
        meniPretraziTrenera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniPretraziTreneraActionPerformed(evt);
            }
        });
        jMenu1.add(meniPretraziTrenera);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Trening");

        meniKreirajTrening.setText("Kreiranje treninga");
        meniKreirajTrening.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniKreirajTreningActionPerformed(evt);
            }
        });
        jMenu2.add(meniKreirajTrening);

        meniIzmenaPodTreninga.setText("Izmena podataka treninga");
        meniIzmenaPodTreninga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniIzmenaPodTreningaActionPerformed(evt);
            }
        });
        jMenu2.add(meniIzmenaPodTreninga);

        meniObrisiTrening.setText("Obrisi trening");
        meniObrisiTrening.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniObrisiTreningActionPerformed(evt);
            }
        });
        jMenu2.add(meniObrisiTrening);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Korisnik");

        meniKreiranjeKorisnika.setText("Kreiranje korisnika");
        meniKreiranjeKorisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniKreiranjeKorisnikaActionPerformed(evt);
            }
        });
        jMenu3.add(meniKreiranjeKorisnika);

        meniPretraziKorisnike.setText("Pretrazi korisnike");
        meniPretraziKorisnike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniPretraziKorisnikeActionPerformed(evt);
            }
        });
        jMenu3.add(meniPretraziKorisnike);

        meniIzmenaPodatakaKor.setText("Izmena podataka korisnika");
        meniIzmenaPodatakaKor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniIzmenaPodatakaKorActionPerformed(evt);
            }
        });
        jMenu3.add(meniIzmenaPodatakaKor);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Evidentiranje prisustva");

        meniEvidentiranjePrisustva.setText("Evidentiranje prisustva");
        meniEvidentiranjePrisustva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniEvidentiranjePrisustvaActionPerformed(evt);
            }
        });
        jMenu4.add(meniEvidentiranjePrisustva);

        meniIzmenaPodOEvidentiranju.setText("Izmena podataka o evidentiranju");
        meniIzmenaPodOEvidentiranju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniIzmenaPodOEvidentiranjuActionPerformed(evt);
            }
        });
        jMenu4.add(meniIzmenaPodOEvidentiranju);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Rezultati korisnika");

        meniKreirajRezKorisnika.setText("Kreiraj rezultat korisnika");
        meniKreirajRezKorisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniKreirajRezKorisnikaActionPerformed(evt);
            }
        });
        jMenu5.add(meniKreirajRezKorisnika);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meniKreirajTreneraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniKreirajTreneraActionPerformed
        TrenerForm tf = new TrenerForm(this, true, MyConstantsTrener.DODAJ_TRENERA);
        tf.setVisible(true);
    }//GEN-LAST:event_meniKreirajTreneraActionPerformed

    private void meniPretraziTreneraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniPretraziTreneraActionPerformed

        
        FormPretraziTrenere fpt = new FormPretraziTrenere(this, true, MyConstantsTrener.DETALJI);
        fpt.setVisible(true);

    }//GEN-LAST:event_meniPretraziTreneraActionPerformed

    private void meniKreirajTreningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniKreirajTreningActionPerformed
        TreningForm trf = new TreningForm(this, true, MyConstantsTrening.DODAJ_TRENING);
        trf.setVisible(true);

    }//GEN-LAST:event_meniKreirajTreningActionPerformed

    private void meniIzmenaPodTreningaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniIzmenaPodTreningaActionPerformed
        FormPretraziTreninge fptr = new FormPretraziTreninge(this, true, MyConstantsTrening.IZMENI_TRENING);
        fptr.setVisible(true);
    }//GEN-LAST:event_meniIzmenaPodTreningaActionPerformed

    private void meniObrisiTreningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniObrisiTreningActionPerformed
        FormPretraziTreninge fptr = new FormPretraziTreninge(this, true, MyConstantsTrening.OBRISI_TRENING);
        fptr.setVisible(true);
    }//GEN-LAST:event_meniObrisiTreningActionPerformed

    private void meniKreiranjeKorisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniKreiranjeKorisnikaActionPerformed
        KorisnikForm kf = new KorisnikForm(this, true, MyConstantsKorisnik.DODAJ_KORISNIKA);
        kf.setVisible(true);
    }//GEN-LAST:event_meniKreiranjeKorisnikaActionPerformed

    private void meniPretraziKorisnikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniPretraziKorisnikeActionPerformed
        FormPretraziKorisnike fpk = new FormPretraziKorisnike(this, true, MyConstantsKorisnik.DETALJI);
        fpk.setVisible(true);
    }//GEN-LAST:event_meniPretraziKorisnikeActionPerformed

    private void meniIzmenaPodatakaKorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniIzmenaPodatakaKorActionPerformed
        FormPretraziKorisnike fpk = new FormPretraziKorisnike(this, true, MyConstantsKorisnik.IZMENA_PODATAKA_KORISNIKA);
        fpk.setVisible(true);
    }//GEN-LAST:event_meniIzmenaPodatakaKorActionPerformed

    private void meniEvidentiranjePrisustvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniEvidentiranjePrisustvaActionPerformed
        EvidencijaPrisustvaForm epf = new EvidencijaPrisustvaForm(this, true, MyConstantsEvidencija.DODAJ_PRISUSTVA);
        epf.setVisible(true);
    }//GEN-LAST:event_meniEvidentiranjePrisustvaActionPerformed

    private void meniIzmenaPodOEvidentiranjuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniIzmenaPodOEvidentiranjuActionPerformed
        EvidencijaPrisustvaForm epf = new EvidencijaPrisustvaForm(this, true, MyConstantsEvidencija.IZMENI_PODATKE_O_EVIDENCIJAMA);
        epf.setVisible(true);
    }//GEN-LAST:event_meniIzmenaPodOEvidentiranjuActionPerformed

    private void meniKreirajRezKorisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniKreirajRezKorisnikaActionPerformed
        RezultatForm rf = new RezultatForm(this, true);
        rf.setVisible(true);
    }//GEN-LAST:event_meniKreirajRezKorisnikaActionPerformed

    private void btnOdjaviSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdjaviSeActionPerformed

        try {
            ClientController.getInstance().signOut(a);
            JOptionPane.showMessageDialog(this, "Uspesno ste se izlogovali");
            this.dispose();
        } catch (Exception ex) {

            if (ex instanceof IOException) {
                JOptionPane.showMessageDialog(this, "GRESKA,POKUSAJTE KASNIJE!!!!!");
                System.exit(0);
                
                

            }
            JOptionPane.showMessageDialog(this, ex.getMessage());

        }
    }//GEN-LAST:event_btnOdjaviSeActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdjaviSe;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem meniEvidentiranjePrisustva;
    private javax.swing.JMenuItem meniIzmenaPodOEvidentiranju;
    private javax.swing.JMenuItem meniIzmenaPodTreninga;
    private javax.swing.JMenuItem meniIzmenaPodatakaKor;
    private javax.swing.JMenuItem meniKreirajRezKorisnika;
    private javax.swing.JMenuItem meniKreirajTrenera;
    private javax.swing.JMenuItem meniKreirajTrening;
    private javax.swing.JMenuItem meniKreiranjeKorisnika;
    private javax.swing.JMenuItem meniObrisiTrening;
    private javax.swing.JMenuItem meniPretraziKorisnike;
    private javax.swing.JMenuItem meniPretraziTrenera;
    // End of variables declaration//GEN-END:variables
}

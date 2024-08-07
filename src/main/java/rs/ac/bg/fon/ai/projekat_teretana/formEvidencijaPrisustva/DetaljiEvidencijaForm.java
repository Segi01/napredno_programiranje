/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat_teretana.formEvidencijaPrisustva;

import rs.ac.bg.fon.ai.projekat_teretana.domain.EvidentiranjePrisustva;
import javax.swing.JOptionPane;


/**
 *
 * @author Stefan Segrt
 */
public class DetaljiEvidencijaForm extends javax.swing.JDialog {

    EvidentiranjePrisustva ep;
    EvidencijaPrisustvaForm main;

    /**
     * Creates new form DetaljiEvidencijaForm
     */
    public DetaljiEvidencijaForm(java.awt.Dialog parent, boolean modal, EvidentiranjePrisustva ep) {
        super(parent, modal);
        initComponents();
        this.ep = ep;
        main = (EvidencijaPrisustvaForm) parent;
        txtKalorije.setText(String.valueOf(ep.getPotroseneKal()));
        txtOtkucaji.setText(String.valueOf(ep.getOtkucajiSrca()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtOtkucaji = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtKalorije = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Otkucaji srca:");

        jLabel2.setText("Potrosene kalorije:");

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtOtkucaji, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(txtKalorije)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(btnSacuvaj)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOtkucaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKalorije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacuvaj)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        int kalorije = validateKalorije(txtKalorije.getText());
        int brojotk = validateOtkucaje(txtOtkucaji.getText());

        String porukaZaPrazno = "";
        int brojac = 0;
        if (txtKalorije.getText().isEmpty() || txtOtkucaji.getText().isEmpty()) {

            if (txtKalorije.getText().isEmpty()) {
                porukaZaPrazno += "kalorije, ";
                brojac++;
            }
            if (txtOtkucaji.getText().isEmpty()) {
                porukaZaPrazno += "otkucaji ";
                brojac++;
            }
            if (brojac == 1) {
                porukaZaPrazno = "Polje " + porukaZaPrazno + " nije popunjeno";
                JOptionPane.showMessageDialog(this, porukaZaPrazno);
                return;
            }
            JOptionPane.showMessageDialog(this, "Polja " + porukaZaPrazno + " nisu popunjena");
            return;
        }
        brojac = 0;
        String porukaZaValidaciju = "";

        if (kalorije == 0) {
            porukaZaValidaciju += "kalorije, ";
            brojac++;
        }
        if (brojotk == 0) {
            porukaZaValidaciju += "otkucaji srca, ";
            brojac++;
        }
        if (brojac == 1 && porukaZaValidaciju.contains("otkucaji srca")) {
            JOptionPane.showMessageDialog(this, "Polje " + porukaZaValidaciju + " nije u dobrom formatu. "
                    + "Ocekivano je da broj otkucaja bude pozitivan broj manji od 205.");
            return;
        }
        if (brojac == 1) {
            JOptionPane.showMessageDialog(this, "Polje " + porukaZaValidaciju + " nije u dobrom formatu.");
            return;
        }
        if (!porukaZaValidaciju.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Polja " + porukaZaValidaciju + " nisu u dobrom formatu. "
                    + "Ocekivano je da broj otkucaja bude pozitivan broj manji od 205.");
            return;
        }

        ep.setPotroseneKal(kalorije);

        ep.setOtkucajiSrca(brojotk);

        JOptionPane.showMessageDialog(this,
                "Uspesno izmenjeni podaci");
        main.refreshTable();

        this.dispose();


    }//GEN-LAST:event_btnSacuvajActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DetaljiEvidencijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DetaljiEvidencijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DetaljiEvidencijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DetaljiEvidencijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DetaljiEvidencijaForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtKalorije;
    private javax.swing.JTextField txtOtkucaji;
    // End of variables declaration//GEN-END:variables

    private int validateKalorije(String kalorijeStr) {

        int kalorije = 0;
        try {
            kalorije = Integer.parseInt(kalorijeStr);
        } catch (NumberFormatException nfe) {
            return 0;
        }
        if (kalorije <= 0) {
            return 0;
        }
        return kalorije;
    }

    private int validateOtkucaje(String otkucajiStr) {
        int otkucaji = 0;
        try {
            otkucaji = Integer.parseInt(otkucajiStr);
        } catch (NumberFormatException nfe) {
            return 0;
        }
        if (otkucaji <= 0 || otkucaji > 205) {
            return 0;
        }
        return otkucaji;

    }
}

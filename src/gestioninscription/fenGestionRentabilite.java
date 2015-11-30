/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioninscription;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import sql.GestionBdd;

/**
 *
 * @author alan
 */
public class fenGestionRentabilite extends javax.swing.JFrame {

   Connection conn;
    Statement stmt1, stmt2;
    
    public fenGestionRentabilite() {
        initComponents();
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
        cmbSessionAchevee = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDeRentabilite = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de la rentabilite");
        jLabel1.setMaximumSize(new java.awt.Dimension(396, 37));
        jLabel1.setMinimumSize(new java.awt.Dimension(396, 37));
        jLabel1.setPreferredSize(new java.awt.Dimension(396, 37));

        cmbSessionAchevee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Session achevée :");

        tableDeRentabilite.setModel(new ModeleJTableListeSession());
        tableDeRentabilite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDeRentabiliteMouseClicked(evt);
            }
        });
        tableDeRentabilite.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tableDeRentabiliteInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tableDeRentabilite);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(cmbSessionAchevee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSessionAchevee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(298, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(111, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
try
            {
                // On prévoit 2 connexions à la base
                stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor","localhost", "root","");
                stmt2 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor","localhost", "root","");
                // Liste des clients qui "ont un plan de formation"
                String req = "select distinct libelleform from session_form ";
                ResultSet rs = GestionBdd.envoiRequeteLMD(stmt1,req);
                cmbSessionAchevee.removeAllItems();
                cmbSessionAchevee.addItem("---");
                while (rs.next())
                {
                    cmbSessionAchevee.addItem(rs.getString(1));
                }
            }
            catch (SQLException se)
            {
                System.out.println("Erreur SQL1 : " + se.getMessage());
            }        
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       try {
           renseigne();
       } catch (SQLException ex) {
           Logger.getLogger(fenGestionRentabilite.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_formWindowActivated

    private void tableDeRentabiliteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDeRentabiliteMouseClicked
        
    }//GEN-LAST:event_tableDeRentabiliteMouseClicked

    private void tableDeRentabiliteInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tableDeRentabiliteInputMethodTextChanged
        //
    }//GEN-LAST:event_tableDeRentabiliteInputMethodTextChanged

    private void renseigne() throws SQLException
    {
        try
        {
        // On vide le JTable
            int j, k;
            String req;
            for(int i=0;i<tableDeRentabilite.getRowCount();i++)
            {
                for (j=0;j<tableDeRentabilite.getColumnCount();j++)
		{
                    tableDeRentabilite.setValueAt(null,i,j);
		}
            }
           
            req = "select libelleform, niveauform, datedebut, nb_places, nb_inscrits from session_form where close = 0";
                
            stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor","localhost", "root","");
            ResultSet rs2 = GestionBdd.envoiRequeteLMD(stmt1, req);
            k = 0;
            while(rs2.next())
            {
                for (j=0;j<(tableDeRentabilite.getColumnCount());j++)
                {
                    tableDeRentabilite.setValueAt(rs2.getObject(j+1), k, j);
                }
                k++;
            }
            rs2.close();
            
        }
        catch(NullPointerException npe)
        {
            System.out.println("Erreur : " + npe.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fenGestionRentabilite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenGestionRentabilite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenGestionRentabilite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenGestionRentabilite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenGestionRentabilite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbSessionAchevee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDeRentabilite;
    // End of variables declaration//GEN-END:variables
}

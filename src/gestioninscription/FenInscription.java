/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioninscription;
import java.awt.Color;
import java.awt.Label;
import java.sql.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import sql.*;
/**
 *
 * @author Administrateur
 */
public class FenInscription extends javax.swing.JFrame {

    /**
     * Creates new form FenInscription
     */
    Connection conn;
    Statement stmt1, stmt2;
    
    public FenInscription()
    {
        initComponents();
        btnInscription.setVisible(false); // On rend le bouton inscription non visible
        tableInscription.selectAll();
        tableInscription.setDefaultRenderer(Object.class, new Couleur()); // Pour mettre les sessions déficitaires en rouge
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
        jLabel2 = new javax.swing.JLabel();
        cmbMatricule = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInscription = new javax.swing.JTable();
        btnInscription = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inscription des clients aux différentes sessions");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jLabel1.setText("GESTION DES INSCRIPTIONS");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setText("Matricule : ");

        cmbMatricule.setName("cmbMat"); // NOI18N
        cmbMatricule.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMatriculeItemStateChanged(evt);
            }
        });
        cmbMatricule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMatriculeActionPerformed(evt);
            }
        });

        jLabel3.setText(" ");
        jLabel3.setName("lblNomPren"); // NOI18N

        tableInscription.setModel(new ModeleJTableListeSession());
        tableInscription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableInscriptionMouseClicked(evt);
            }
        });
        tableInscription.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tableInscriptionInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tableInscription);

        btnInscription.setText("Inscription");
        btnInscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscriptionActionPerformed(evt);
            }
        });

        jLabel5.setText("Sélection : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                    .addComponent(btnInscription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInscription, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
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
                String req = "select distinct c.matricule from client c, plan_formation p "
                 + "where c.matricule = p.matricule order by c.matricule";
                ResultSet rs = GestionBdd.envoiRequeteLMD(stmt1,req);
                cmbMatricule.addItem("---");
                while (rs.next())
                {
                    cmbMatricule.addItem(rs.getString(1));
                }
            }
            catch (SQLException se)
            {
                System.out.println("Erreur SQL1 : " + se.getMessage());
            }
    }//GEN-LAST:event_formWindowOpened

    private void cmbMatriculeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMatriculeItemStateChanged
          // Affichage du nom prénom et de la liste des sessions autorisées
        if (evt.getStateChange() != 1) // Pour éviter le déclenchement sur la création de la fenêtre
        {
            renseigne();
		
        }
    }//GEN-LAST:event_cmbMatriculeItemStateChanged

    private void btnInscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscriptionActionPerformed
        FenConfirmationInscription f2 = new FenConfirmationInscription(this, true);
        f2.init(cmbMatricule.getSelectedItem(), tableInscription.getValueAt(tableInscription.getSelectedRow(),0));
        f2.setSize(400,300);
        f2.setVisible(true);
    }//GEN-LAST:event_btnInscriptionActionPerformed

    private void tableInscriptionInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tableInscriptionInputMethodTextChanged
        //
    }//GEN-LAST:event_tableInscriptionInputMethodTextChanged

    private void tableInscriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableInscriptionMouseClicked
        if (cmbMatricule.getSelectedIndex()>0 && tableInscription.getValueAt(tableInscription.getSelectedRow(), 0) != null)
        {
            jLabel5.setText(tableInscription.getValueAt(tableInscription.getSelectedRow(), 0).toString());
            int pos1 = jLabel3.getText().indexOf(":");
            String nomPrenom = jLabel3.getText().substring(pos1 + 1);
            btnInscription.setText("Inscription à la session numéro " + tableInscription.getValueAt(tableInscription.getSelectedRow(), 0) + " pour " + nomPrenom);
            btnInscription.setVisible(true);
        }
        else
        {
            btnInscription.setVisible(false);
            jLabel5.setText("Aucune sélection");
        }
    }//GEN-LAST:event_tableInscriptionMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        renseigne();
    }//GEN-LAST:event_formWindowActivated

    private void cmbMatriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMatriculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMatriculeActionPerformed
    private void renseigne()
    {
        try
        {
        // On vide le JTable
            int j, k;
            String req;
            for(int i=0;i<tableInscription.getRowCount();i++)
            {
                for (j=0;j<tableInscription.getColumnCount();j++)
		{
                    tableInscription.setValueAt(null,i,j);
		}
            }
            if (cmbMatricule.getSelectedIndex()==0 || cmbMatricule.getSelectedItem()== null) // Pas de client de choisi
            {
                jLabel3.setText("ENSEMBLE DES SESSIONS");
                // Toutes les sessions
                req = "select null, s.numero, s.libelleform, s.niveauform, s.datedebut, duree, nb_places, nb_inscrits, coutrevient ";
                req += "from session_form s, formation f ";
                req += "where s.libelleform = f.libelle and s.niveauform = f.niveau ";
                // et date supérieure à la date du jour
                btnInscription.setVisible(false); // On rend le bouton inscription non visible
            }
            else
            {
                // Sélection des sessions "autorisées"
                req = "select c.nom, s.numero, s.libelleform, s.niveauform, s.datedebut, duree, nb_places, nb_inscrits, coutrevient ";
                req += "from session_form s, client c, plan_formation p, formation f ";
                req += "where c.matricule = '" + cmbMatricule.getSelectedItem() + "' ";
                req += "and p.matricule = c.matricule and nb_places > nb_inscrits ";
                req += "and p.libelle_form = f.libelle and p.niveau = f.niveau ";
                req += "and s.libelleform = f.libelle and s.niveauform = f.niveau ";
                // et date supérieure à la date du jour
                req += "and close = 0 and effectue = 0 and s.numero Not In ";
                req += "(Select num_session From inscription Where matricule = '" + cmbMatricule.getSelectedItem() + "')";
                if (tableInscription.getValueAt(tableInscription.getSelectedRow(), 0) != null) //Si la cellule sélectionnée est vide
                {
                    btnInscription.setVisible(false); // On rend le bouton inscription non visible
                }
            }
            stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor","localhost", "root","");
            ResultSet rs2 = GestionBdd.envoiRequeteLMD(stmt1, req);
            ResultSet rs3 = null;
            
            k = 0;
            try
            {
                while(rs2.next())
                {
                    if (k==0 && cmbMatricule.getSelectedIndex()!=0)
                    {
                        jLabel3.setText("Sessions autorisées pour : " + rs2.getString(1));
                    }
                    // On calcule la marge et on renseigne la dernière colonne(7ème) du jTable
                    req = "Select sum(taux_horaire) as revenu_session ";
                    req += "from statut st, session_form s, client c, inscription i ";
                    req += "where s.numero = i.num_session and c.matricule = i.matricule ";
                    req += "and c.typestatut = st.type and s.numero = " + rs2.getInt(2);
                    stmt2 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor","localhost", "root","");
                    rs3 = GestionBdd.envoiRequeteLMD(stmt2, req);
                    rs3.first();
                    tableInscription.setValueAt((rs3.getFloat(1) - rs2.getFloat(9)), k, 7);
                    // On renseigne le reste du jTable
                    for (j=0;j<(tableInscription.getColumnCount() -1);j++)
                    {
                        tableInscription.setValueAt(rs2.getObject(j+2), k, j);
                    }
                    k++;
                }
                rs2.close();
            }
            catch (SQLException sqle)
            {
                System.out.print("Erreur SQL : " + sqle.getMessage());
            }
        }
        catch(NullPointerException npe)
        {
            System.out.println("Erreur : " + npe.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInscription;
    private javax.swing.JComboBox cmbMatricule;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableInscription;
    // End of variables declaration//GEN-END:variables
}

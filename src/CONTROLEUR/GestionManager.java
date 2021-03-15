/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import VUE.AccueilAdmin;

/**
 *
 * @author lglotin
 */
public class GestionManager extends JPanel {

    DefaultTableModel model = new DefaultTableModel();// DTM implémente l'ensemble des méthodes
    Statement stmn;
    SQLConnection conn = new SQLConnection();
    JTextField idManag, n, pren;

    public GestionManager() {

//Création du PANEL dans JFRAME
        JPanel essai = new JPanel();//panel dans la Jframe
        this.setLayout(new BorderLayout());//Panel prend toutela place de la fenêtre

//=======================================================        
//Création du Panel NORD 
//=======================================================  
        JPanel titre = new JPanel();
        this.add(titre, BorderLayout.NORTH);
        titre.setBorder(BorderFactory.createLineBorder(Color.black));
        //Trait horizontal sous "AccueilAdmin"
        //titre.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.black));

        //Création du Label placé dans le Panel titre avec affichage "AccueilAdmin"
        JLabel label = new JLabel("Gestion Des Managers");
        JLabel profil = new JLabel("");
        JLabel nom = new JLabel("");
        JLabel prenom = new JLabel("");
        //Police et taille
        label.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        //Ajout le label dans le Panel titre
        titre.add(label);

//=======================================================        
//Création du Panel OUEST 
//======================================================= 
        JPanel ouest = new JPanel();
        JScrollPane jScrollP = new JScrollPane(ouest);
        this.add(jScrollP, BorderLayout.WEST);
        JPanel west = new JPanel(new GridLayout(8, 2, 2, 50));
        west.setBorder(BorderFactory.createEmptyBorder(40, 25, 0, 25));
        ouest.add(west);

        JLabel idManager = new JLabel("Id Manager  :");
        idManager.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        idManag = new JTextField(10);
        idManag.setFont(new Font(Font.SERIF, Font.BOLD, 25));

        JLabel no = new JLabel("Nom   :");
        no.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        n = new JTextField(10);
        n.setFont(new Font(Font.SERIF, Font.BOLD, 25));

        JLabel preno = new JLabel("Prenom :");
        preno.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        pren = new JTextField(10);
        pren.setFont(new Font(Font.SERIF, Font.BOLD, 25));

        JButton ajouter = new JButton("Ajouter");
        ajouter.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        ajouter.addActionListener((ActionEvent ae) -> {
            ajouter();
        });

        JButton modifier = new JButton("Modifier");
        modifier.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        modifier.addActionListener((ActionEvent ae) -> {
            modifier();
        });

        JButton supprimer = new JButton("Supprimer");
        supprimer.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        supprimer.addActionListener((ActionEvent ae) -> {
            supprimer();
        });

        JButton actualiser = new JButton("Actualiser");
        actualiser.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        actualiser.addActionListener((ActionEvent ae) -> {
//            model.fireTableDataChanged();         
            this.removeAll();
            GestionManager gestionM = new GestionManager();
            this.add(gestionM);
            this.validate();
        });

        west.add(idManager);
        west.add(idManag);
        west.add(no);
        west.add(n);
        west.add(preno);
        west.add(pren);
        west.add(ajouter);
        west.add(modifier);
        west.add(supprimer);
        west.add(actualiser);

//=======================================================        
//Création du Panel CENTRE 
//======================================================= 
        JTable tble = new JTable();
        JScrollPane jScrollPane1 = new JScrollPane(tble);
        this.add(jScrollPane1, BorderLayout.CENTER);
        tble.getTableHeader().setPreferredSize(new Dimension(200, 25));
        tble.getTableHeader().setFont(new Font(Font.SERIF, Font.PLAIN, 25));
        tble.setRowHeight(30);
        tble.setFont(new Font(Font.SERIF, Font.PLAIN, 25));

        jScrollPane1.setViewportView(tble);

        model.addColumn("id");
        model.addColumn("Nom");
        model.addColumn("Prenom");

        Afficher();
        tble.setModel(model);

        tble.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int i = tble.getSelectedRow();
                deplace(i);
            }
        });

//=======================================================        
//Création du Panel SUD 
//======================================================= 
        JPanel sud = new JPanel();
        this.add(sud, BorderLayout.SOUTH);
        sud.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton retour = new JButton("Retour");
        retour.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        sud.add(retour);

        retour.addActionListener((ActionEvent ae) -> {
            this.removeAll();
            AccueilAdmin admin = new AccueilAdmin();
            this.add(admin);
            this.validate();
        });
    }

    public void Afficher() {
        try {
            stmn = conn.getInstance().createStatement();
            ResultSet res = stmn.executeQuery("Select * from manager");
            while (res.next()) {
                model.addRow(new Object[]{res.getInt("id"), res.getString("nom"), res.getString("prenom")});
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return;
    }

    private void deplace(int i) {//fonctionne 
        try {     //i represente les ligne 

            idManag.setText(model.getValueAt(i, 0).toString());
            // txttp.setSelectedItem(dt.getValueAt (i, 5).toString());
            n.setText(model.getValueAt(i, 1).toString());
            // txtb.setSelectedItem(dt.getValueAt (i, 2).toString());
            pren.setText(model.getValueAt(i, 2).toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erreur de deplacement de message !!!!! " + e.getMessage());
        }
    }

    private void ajouter() { //ajouter utilisateur    
        String id = idManag.getText();
        String nom = n.getText();
        String prenom = pren.getText();

        String req = "INSERT INTO manager(nom,prenom)VALUES('" + nom + "','" + prenom + "')";
        try {
            stmn = conn.getInstance().createStatement();
//stm.executeQuery(req);
            stmn.executeUpdate(req);
            JOptionPane.showMessageDialog(null, "Le manager " + nom + " a bien été ajouté");
            idManag.setText("");
            n.setText("");
            pren.setText("");

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private void supprimer() {   //supprimer utilisateur                                      
        try {
            if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer ce manager ?",
                    "Supprimer manager", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                if (idManag.getText().length() != 0) {
                    stmn.executeUpdate("DELETE FROM manager WHERE id = " + idManag.getText());
                }//ca est pour recharger la list des stagiaire
                else {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir le champ id !");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de suppression \n" + e.getMessage());
        }
    }

    private void modifier() {

        String id = idManag.getText();
        String nom = n.getText();
        String prenom = pren.getText();

        try {
            if (JOptionPane.showConfirmDialog(null, "Confirmer la modification", "modification",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

                stmn.executeUpdate("UPDATE manager SET nom='" + n.getText() + "',prenom='" + pren.getText()
                        + "' WHERE id = " + idManag.getText());
                //afficher ();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de modification !!!!");
            System.err.println(e);
        }
    }

}

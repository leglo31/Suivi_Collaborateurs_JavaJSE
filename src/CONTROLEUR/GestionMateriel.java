/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import VUE.AccueilAdmin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lglotin
 */
public class GestionMateriel extends JPanel {

    DefaultTableModel model = new DefaultTableModel();// DTM implémente l'ensemble des méthodes
    Statement stmn;
    SQLConnection conn = new SQLConnection();

    //CONSTRUCTEUR
    public GestionMateriel() {

//Création du PANEL dans JFRAME
        JPanel essai = new JPanel();//panel dans la Jframe
        this.setLayout(new BorderLayout());//Panel prend toutela place de la fenêtre

//-------------------------------------------------
//Création du Panel NORD      
        JPanel titre = new JPanel();
        this.add(titre, BorderLayout.NORTH);
        titre.setBorder(BorderFactory.createLineBorder(Color.black));
        //Trait horizontal sous "AccueilAdmin"
        //titre.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.black));

        //Création du Label placé dans le Panel titre avec affichage "AccueilAdmin"
        JLabel label = new JLabel("Gestion du Materiel");
        //Police et taille
        label.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        //Ajout le label dans le Panel titre
        titre.add(label);

        JTable tble = new JTable();
        JScrollPane jScrollPane1 = new JScrollPane(tble);
        this.add(jScrollPane1, BorderLayout.CENTER);
        tble.getTableHeader().setPreferredSize(new Dimension(200, 25));
        tble.getTableHeader().setFont(new Font(Font.SERIF, Font.PLAIN, 25));
        tble.setRowHeight(30);
        tble.setFont(new Font(Font.SERIF, Font.PLAIN, 25));

        jScrollPane1.setViewportView(tble);

        model.addColumn("id");
        model.addColumn("Propriétaire PC");
        model.addColumn("N°Info");
        model.addColumn("N°Airbus");
        model.addColumn("S/N");
        model.addColumn("Ecran 1");
        model.addColumn("Ecran 2");
        model.addColumn("Fauteuil Ergo");
        model.addColumn("EPI");

        //List<Utilisateur> utilisateur  = u.getAll(); 
        // model.addRow();
        Afficher();
        tble.setModel(model);
        
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
            ResultSet res = stmn.executeQuery("Select * from materiel");
            while (res.next()) {
                model.addRow(new Object[]{res.getInt("id"), res.getString("ProprioPc"), res.getInt("numInfo"),
                    res.getString("numAirbus"), res.getString("s/n"), res.getString("ecran1"), 
                    res.getString("ecran2"), res.getString("fauteuilErgo"), res.getString("epi")});
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return;
    }

}

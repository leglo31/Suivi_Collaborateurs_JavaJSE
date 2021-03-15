/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUE;

import CONTROLEUR.Authentification;
import label_jtext_bouton_constructeur.Essai_heritage_action;
import CONTROLEUR.GestionManager;
import CONTROLEUR.GestionMateriel;
import CONTROLEUR.SQLConnection;
import MODELE_dao.UtilisateurDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import CONTROLEUR.GestionUtilisateur;
import CONTROLEUR.GestionProfil;
import entity.Utilisateur;


/**
 *
 * @author lglotin
 */
public class AccueilAdmin extends JPanel {

    Statement stmn;
    Box west;
    UtilisateurDAO auth = new UtilisateurDAO();
    DefaultTableModel model = new DefaultTableModel();
    SQLConnection conn = new SQLConnection();
Authentification au = new Authentification();
    
    //CONSTRUCTEUR
    public AccueilAdmin() {

//Création du PANEL dans JFRAME
        this.setLayout(new BorderLayout());//Panel prend toutela place de la fenêtre=>nord/est/sud/ouest

//-------------------------------------------------
//Création du Panel NORD      
        JPanel titre = new JPanel();
        this.add(titre, BorderLayout.NORTH);
        titre.setBorder(BorderFactory.createLineBorder(Color.black));
        //Trait horizontal sous "AccueilAdmin"
        //titre.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.black));
        Box nord = Box.createHorizontalBox();
        titre.add(nord);
        //Création du Label placé dans le Panel titre avec affichage "AccueilAdmin"
        JLabel label = new JLabel("ADMIN");
    
        //JLabel noms = new JLabel("Bienvenue" + nom);
       // noms.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
       // noms.setForeground(Color.blue);
        //Police et taille
        label.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        //Ajout le label dans le Panel titre
        //nord.add(noms);
        nord.add(label);

//-------------------------------------------------
//Création du Panel OUEST
        JPanel ouest = new JPanel();
        this.add(ouest, BorderLayout.WEST);
        ouest.setBorder(BorderFactory.createLineBorder(Color.green));//si on veut bordure mate
        //this.add(ouest, BorderLayout.WEST);//panel WEST 
        //JScrollPane ouest = new JScrollPane();

        west = Box.createVerticalBox();
        ouest.add(west);
        espace();

        //west.add(new Bouton("Gestion Profil").getButton());
        //espace(0, 20);
        JButton gestionProfil = new JButton("Gestion Profil");
        west.add(gestionProfil);
        gestionProfil.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        gestionProfil.setBorderPainted(false);
        espace();

        JButton gestionUtilisateur = new JButton("Gestion Collaborateur");
        west.add(gestionUtilisateur);
        gestionUtilisateur.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        gestionUtilisateur.setBorderPainted(false);
        espace();

        JButton gestionMateriel = new JButton("Gestion Materiel");
        west.add(gestionMateriel);
        gestionMateriel.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        gestionUtilisateur.setBorderPainted(false);
        espace();

        JButton gestionManager = new JButton("Gestion Manager");
        west.add(gestionManager);
        gestionManager.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        gestionUtilisateur.setBorderPainted(false);
        espace();

        JButton essai = new JButton("essai");
        west.add(essai);
        essai.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        essai.setBorderPainted(false);
        espace();

        //-------------------------------------------------
//Création du Panel CENTRE
        JTable tble = new JTable();
        JScrollPane jScrollPane1 = new JScrollPane(tble);
        this.add(jScrollPane1, BorderLayout.CENTER);
        tble.getTableHeader().setPreferredSize(new Dimension(200, 25));
        tble.getTableHeader().setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        tble.setRowHeight(30);
        tble.setFont(new Font(Font.SERIF, Font.PLAIN, 20));

        jScrollPane1.setViewportView(tble);

        model.addColumn("idCollaborateur");
        model.addColumn("nom");
        model.addColumn("login");
        model.addColumn("motdepasse");
        model.addColumn("idProfil");

        //-------------------------------------------------
//Création du Panel SUD 
        JPanel sud = new JPanel();
        this.add(sud, BorderLayout.SOUTH);
        sud.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton retour = new JButton("RETOUR");
        retour.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        sud.add(retour);

//========================================
//Action sur RETOUR
//========================================
        retour.addActionListener((ActionEvent ae) -> {
            this.removeAll();
            Authentification identif = new Authentification();
            this.add(identif);
            this.validate();

        });

//========================================
//Action sur Gestion Profil
//========================================
        gestionUtilisateur.addActionListener((ActionEvent ae) -> {
            this.removeAll();
            GestionUtilisateur gestionU = new GestionUtilisateur();
            this.add(gestionU);
            this.validate();
        });

        gestionMateriel.addActionListener((ActionEvent ae) -> {
            this.removeAll();
            GestionMateriel gestionM = new GestionMateriel();
            this.add(gestionM);
            this.validate();
        });

        gestionProfil.addActionListener((ActionEvent ae) -> {
            this.removeAll();
            GestionProfil gestionP = new GestionProfil();
            this.add(gestionP);
            this.validate();
        });

        gestionManager.addActionListener((ActionEvent ae) -> {
            this.removeAll();
            GestionManager gestionU = new GestionManager();
            this.add(gestionU);
            this.validate();
        });
        
        
        essai.addActionListener((ActionEvent ae) -> {
            this.removeAll();
            Essai_heritage_action ess = new Essai_heritage_action();
            this.add(ess);
            this.validate();
        });
        
        
        
        
    }

    private void espace() {
        west.add(Box.createRigidArea(new Dimension(0, 60)));
    }

    public JButton Bouton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        button.setBorderPainted(false);
        return button;
    }
}

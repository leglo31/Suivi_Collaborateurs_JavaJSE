/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelJPanelAction;

import label_jtext_bouton_constructeur.Bouton;
import MODELE_dao.DAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import VUE.AccueilAdmin;

/**
 *
 * @author lglotin
 */
//public class Model <T> extends JPanel {
public class Model extends JPanel {

    protected JButton retour;
    //protected DAO<T> dao;

    //public Model(DAO dao) {
         public Model() {
 //this.dao = dao;
//Création du PANEL dans JFRAME
        this.setLayout(new BorderLayout());//Panel prend toute la place de la fenêtre

//=======================================================        
//Création du Panel NORD 
//======================================================= 
        JPanel titre = new JPanel();
        this.add(titre, BorderLayout.NORTH);
        titre.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel label = new JLabel("");
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
//1er chiffre => nbr de lignes
//3 espace entre label et jtext 10mini defaut
//4 espace entre lignes
//======
//1er chiffre => espace hauteur
//2 espace gauche
//4espace avec centre

        JButton ajouter = new JButton("Ajouter");
        ajouter.setFont(new Font(Font.SERIF, Font.BOLD, 35));
//        ajouter.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                if (ajouter.getName() == "ajouter"){
//                }
//                dao.create(ABORT);
//            }
//                });
//       

        JButton modifier = new JButton("Modifier");
        modifier.setFont(new Font(Font.SERIF, Font.BOLD, 35));

        JButton actualiser = new JButton("Actualiser");
        actualiser.setFont(new Font(Font.SERIF, Font.BOLD, 35));

        JButton supprimer = new JButton("Supprimer");
        supprimer.setFont(new Font(Font.SERIF, Font.BOLD, 35));

        JButton rechercher = new JButton("Rechercher");
        rechercher.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        
        Bouton bonjour= new Bouton("bonjour");

        //boutons
        west.add(ajouter);
        west.add(modifier);
        west.add(actualiser);
        west.add(supprimer);
        west.add(rechercher);
        west.add(bonjour);

        //=======================================================        
//Création du Panel SUD 
//======================================================= 
        JPanel sud = new JPanel();
        this.add(sud, BorderLayout.SOUTH);
        sud.setBorder(BorderFactory.createLineBorder(Color.black));

        retour = new JButton("Retour");
        retour.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        sud.add(retour);

//        retour.addActionListener((ActionEvent ae) -> {
//            this.removeAll();
//            AccueilAdmin admin = new AccueilAdmin();
//            this.add(admin);
//            this.validate();
//        });
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUE;

import CONTROLEUR.Authentification;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author lglotin
 */
public class AccueilSecretariat extends JPanel{
    
     //CONSTRUCTEUR
    public AccueilSecretariat() {

//Création du PANEL dans JFRAME
        JPanel essai = new JPanel();//panel dans la Jframe
        this.setLayout(new BorderLayout());//Panel prend toutela place de la fenêtre

//-------------------------------------------------
//Création du Panel NORD      
        JPanel titre = new JPanel();
        this.add(titre, BorderLayout.NORTH);
        titre.setBorder(BorderFactory.createLineBorder(Color.black));
        //Trait horizontal sous "Admin"
        //titre.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.black));

        //Création du Label placé dans le Panel titre avec affichage "Admin"
        JLabel label = new JLabel("SECRETARIAT");
        //Police et taille
        label.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        //Ajout le label dans le Panel titre
        titre.add(label);

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
            Authentification gestionU = new Authentification();
            this.add(gestionU);
            this.validate();
        });       
        
    
    }    
}

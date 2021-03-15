/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUE;

import CONTROLEUR.Authentification;
import VUE.AccueilAdmin;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author lglotin
 */
public class Frame extends JFrame {

    public Frame() {
//Configuration de la JFrame
        this.setTitle("Suivi Collaborateurs DSI");//titre affiché en haut à gauche
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//appli se ferme sur la croix rouge
        this.setExtendedState(this.MAXIMIZED_BOTH);//la JFrame prend tout l'écran
        this.setMinimumSize(new Dimension(800, 600));//dimension mini de la JFrame(fenêtre)
        this.setLocationRelativeTo(null); //on centre la fenêtre sur l'écran
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/DSI-icon.png")));
        // icone en haut à gauche du titre
        Authentification authentification = new Authentification();
        this.add(authentification);
       // AccueilAdmin admin = new AccueilAdmin();
       // this.add(admin);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package label_jtext_bouton_constructeur;

import java.awt.event.ActionEvent;
import modelJPanelAction.Model;
import VUE.AccueilAdmin;

/**
 *
 * @author lglotin
 */
public class Essai_heritage_action extends Model{//la classe Essai_heritage_action hérite de la classe Model
    
    public Essai_heritage_action(){
        //On s'appercoit que l'interface de Model est bien présente dans Essai_heritage_action, et on peut compléter cette interface avec de nouvelles fonctionnalités
        retour.addActionListener((ActionEvent ae) -> {//Rajout d'un listener sur le bouton retour déclaré dans la classe Model  
            this.removeAll();
            AccueilAdmin admin = new AccueilAdmin();
            this.add(admin);
            this.validate();
        });
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_actions;

import label_jtext_bouton_constructeur.Jtext;
import MODELE_dao.UtilisateurDAO;
import entity.Utilisateur;
import javax.swing.JComboBox;

/**
 *
 * @author lglotin
 */
public class GestionUtilisateurs {

    Jtext idUtilisat, n, log, mp, recherche;//déclaration des JTexts
    int idProfi, idUtil;//idem
    String idUt, no, logi, motdepasse, recupIdProf;//déclaration variables qui prendront les valeurs des JTexts
    JComboBox idProf = new JComboBox();//combobox dans la box west pour déterminer les # profils(1.2.3.4)
    UtilisateurDAO u = new UtilisateurDAO();//instanciation d'un objet UtilisateurDAO
    String recupIdUtil;

    public GestionUtilisateurs() {

    }

    public void ModifUtilisateur() {
        recupIdUtil = idUtilisat.getText();//recupère l'idUtilisateur dans le JText
        idUtil = Integer.parseInt(recupIdUtil);//change le string jText en int
        no = n.getText();//no,logi...récupère infos dans les Jtext(String)
        logi = log.getText();
        motdepasse = mp.getText();
        recupIdProf = idProf.getSelectedItem().toString();//récupIdProf récupère idProfil(String) dans la combobox
        idProfi = Integer.parseInt(recupIdProf);//conversion récupIdProf(String) en int car le constructeur Utilisateur est un int pour l'idProfil 

        //recupJText();//méthode pour récuperer les jText commune au bouton ajouter
      Utilisateur uti = new Utilisateur(idUtil, no, logi, motdepasse, idProfi);
        //=========
        u.update(uti);//FONCTION GENERIQUE UPDATE() DE UTILISATEUR DAO
        //=========
    }

}

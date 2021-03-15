/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import VUE.AccueilAdmin;
import MODELE_dao.UtilisateurDAO;
import entity.Utilisateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import VUE.AccueilSecretariat;
import VUE.AccueilAutreUtilisateur;
import VUE.AccueilMateriel;

/**
 *
 * @author lglotin
 */
public class Authentification extends JPanel {

    JTextField saisieLogin;
    JPasswordField saisieMPass;
    Box cent;
    JOptionPane jop1;
    Statement stmn;
    SQLConnection conn = new SQLConnection();
    private Statement statement;
    UtilisateurDAO u = new UtilisateurDAO();

    public Authentification() {

        this.saisieLogin = new JTextField();//création jtext pour la saisieLogin
        this.saisieMPass = new JPasswordField();//création jtextcaché xxxxx pour la saisieMPass

//==================================================
        //Création du Panel identification qui prend toute la JFrame
        JPanel identification = new JPanel();//panel dans la JFrame
        this.setLayout(new BorderLayout());//Panel prend toutela place de la fenêtre(JFrame)

//==================================================
//Création du Panel NORD
//==================================================
        //titre placé au nord du Panel identification ou on mettra le Label IDENTIFICATION
        JPanel titre = new JPanel();
        this.add(titre, BorderLayout.NORTH);//panel titre ajouté au nord
        //trait horizontal sous "IDENTIFICATION"
        // titre.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.black));

        //Création du Label placé dans le Panel titre avec login "AUTHENTIFICATION"
        JLabel identific = new JLabel("AUTHENTIFICATION");
        //police et taille
        identific.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        //ajout le identific dans le Panel titre
        titre.add(identific);

//==================================================
//Création du Panel CENTRE
//==================================================
        JPanel centre = new JPanel();
        this.add(centre, BorderLayout.CENTER);//panel centre ajouté au centre
        cent = Box.createVerticalBox();//création d'une box au centre pour aligné vertivalement les boutons/panel
        centre.add(cent);//ajout de la box au panel centre
        espace(0, 70);//appel méthode pour l'espacement des boutons

        //Création du panel et du label nom utilisateur
        JPanel login = new JPanel();
        JLabel log = new JLabel("Login:                  ");
        login.add(log);
        log.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        cent.add(login);
        espace(0, 30);

        //Création du panel et label mot de passe
        JPanel motPass = new JPanel();
        JLabel motdepasse = new JLabel("Mot de Passe:      ");
        motPass.add(motdepasse);//ajout du label dans le panel
        motdepasse.setFont(new Font(Font.SERIF, Font.BOLD, 30));//police
        cent.add(motPass);//ajout panel mot de passe au panel centre
        espace(0, 30);

        //Création du JText saisieLogin utilisateur
        saisieLogin.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        saisieLogin.setPreferredSize(new Dimension(400, 70));//dimension du jtext
        cent.add(saisieLogin);//ajout jtext au panel centre

        //Création du JPasswordField saisieMPass mot de passe
        saisieMPass.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        saisieMPass.setPreferredSize(new Dimension(400, 70));
        cent.add(saisieMPass);

        //création du panel(FLOWLAYOUT) ou on mettra nom utilisateur et saisieLogin 
        JPanel utilisateur = new JPanel(new FlowLayout());// permet de mettre panel à la suite
        cent.add(utilisateur);
        utilisateur.add(Box.createRigidArea(new Dimension(140, 50)));//création espace avant le Jtext saisie
        utilisateur.add(log);
        utilisateur.add(saisieLogin);
        espace(0, 30);

        //création du panel(FLOWLAYOUT) ou on mettra mot de passe et saisieMPass
        JPanel motDePasse = new JPanel(new FlowLayout());// permet de mettre panel à la suite
        cent.add(motDePasse);
        motDePasse.add(Box.createRigidArea(new Dimension(140, 50)));//création espace avant le Jtext saisie
        motDePasse.add(motdepasse);
        motDePasse.add(saisieMPass);
        espace(0, 30);

        JPanel valide = new JPanel();
        JButton valider = new JButton("Valider");
        valider.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        valide.add(valider);
        cent.add(valide);

//==================================================
        //Action listener sur le bouton VALIDER
//==================================================
        valider.addActionListener(new ActionListener() { //action effectuée après le clic VALIDER
            @Override
            public void actionPerformed(ActionEvent ae) {
                String loginsaisie = saisieLogin.getText();// récupère le login tapé dans la variable loginsaisie
                String motdepassesaisie = saisieMPass.getText();// récupère le login tapé dans la variable loginsaisie

                System.out.println("=======");
                //appelle la //METHODE RECHERCHE PAR LOGIN dans UtilisateurDAO// pour rechercher utilisateur  
                Utilisateur utilisat = u.rechercheParLogin(loginsaisie);
                System.out.println("Mot de passe tapé par le collaborateur: " + motdepassesaisie);//affiche console login tapé

                //nouveau utilisateur utilisat est égal au return utilisateur de la methode, et donc de la requete avec le login tapé
                //si par ex toto en login, champ utilisateur avec le login toto
                if (utilisat == null) {//si l'utilisateur n'existe pas
                    jop1.showMessageDialog(null, "login incorrect !", "Erreur", 1);//message dialogue sur écran si login faux
                    saisieLogin.setText(""); //Efface le contenu du JText saisie Login
                    saisieLogin.requestFocus(); //Remet le curseur dans le JText saisie Login
                    return;//arrête le programme
                }
                System.out.println("=======");

                if (!utilisat.getMotdepasse().equals(motdepassesaisie)) {//si mot de passe utilisateur n'est pas égale à la saisie
                    jop1.showMessageDialog(null, "mot de passe incorrect !", "Erreur", 1);//message dialogue sur écran si mot de passe faux 
                    saisieMPass.setText("");
                    saisieMPass.requestFocus();
                    return;//arrête le programme
                }

//Condition pour connaitre sur quelle page l'Utilisateur va aller en fonction de son IdProfil et donc du profil: admin,informatique,autreuser....
                if (utilisat.getIdProfil() == 1) { // ici 1 est l'idProfil de admin
                    Authentification.this.removeAll();  //efface la page actuelle
                    AccueilAdmin admin = new AccueilAdmin();  //créer un objet admin
                    Authentification.this.add(admin); //rajoute nouveau admin dans la page actuelle
                    //jop1.showMessageDialog(null, "login correct !", "Infos", 1);//message sur écran login bon
                    Authentification.this.validate(); //affiche la nouvelle page admin

                } else if (utilisat.getIdProfil() == 2) {// 2 pour Autreuser
                    Authentification.this.removeAll();  //efface la page actuelle
                    AccueilAutreUtilisateur autreUtil = new AccueilAutreUtilisateur();  //créer un objet autreuser
                    Authentification.this.add(autreUtil); //rajoute nouveau autreuser dans la page actuelle
                    Authentification.this.validate(); //affiche la nouvelle page autreuser

                } else if (utilisat.getIdProfil() == 3) { // 3 pour Matériel
                    Authentification.this.removeAll();  //efface la page actuelle
                    AccueilSecretariat secretariat = new AccueilSecretariat();  //créer un objet secretariat
                    Authentification.this.add(secretariat); //rajoute nouveau secretariat dans la page actuelle
                    Authentification.this.validate(); //affiche la nouvelle page secretariat

                } else if (utilisat.getIdProfil() == 4) { // 4 Pour Secrétariat
                    Authentification.this.removeAll();  //efface la page actuelle
                    AccueilMateriel materiel = new AccueilMateriel();  //créer un objet informatique
                    Authentification.this.add(materiel); //rajoute nouveau informatique dans la page actuelle
                    Authentification.this.validate(); //affiche la nouvelle page informatique
                }
            }
        });
    }
//==================================================       
//FIN DE L'INTERFACE GRAPHIQUE
//==================================================

    //méthode pour créer des espaces entre les composants
    private void espace(int x, int y) {
        cent.add(Box.createRigidArea(new Dimension(x, y)));
    }
}

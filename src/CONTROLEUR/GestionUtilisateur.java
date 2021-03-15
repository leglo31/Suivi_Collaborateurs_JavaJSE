/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import label_jtext_bouton_constructeur.Bouton;
import label_jtext_bouton_constructeur.Label;
import VUE.AccueilAdmin;
import label_jtext_bouton_constructeur.Jtext;
import MODELE_dao.UtilisateurDAO;
import entity.Utilisateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model_actions.GestionUtilisateurs;

/**
 *
 * @author lglotin
 */
public class GestionUtilisateur extends JPanel {

    Box west;//permet de gerer la disposition des panels et jtexts à l'ouest 
    DefaultTableModel model = new DefaultTableModel();// DTM implémente l'ensemble des méthodes
    JTable tble;//déclaration tble de type JTable
    SQLConnection conn = new SQLConnection();//instanciation d'un objet SQLconnection
    Jtext idUtilisat, n, log, mp, recherche;//déclaration des JTexts
    JComboBox idProf = new JComboBox();//combobox dans la box west pour déterminer les # profils(1.2.3.4)
    UtilisateurDAO u = new UtilisateurDAO();//instanciation d'un objet UtilisateurDAO
    String idUt, no, logi, motdepasse, recupIdProf;//déclaration variables qui prendront les valeurs des JTexts
    int idProfi, idUtil;//idem
    GestionUtilisateurs g = new GestionUtilisateurs();

    public GestionUtilisateur() {
//Création du PANEL dans JFRAME
        this.setLayout(new BorderLayout());//Panel prend toutela place de la fenêtre

//=======================================================        
//Création du Panel NORD 
//======================================================= 
        JPanel titre = new JPanel();
        this.add(titre, BorderLayout.NORTH);
        titre.setBorder(BorderFactory.createLineBorder(Color.black));//Trait horizontal sous "AccueilAdmin"
        //titre.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.black));
        JLabel label = new JLabel("Gestion des Collaborateurs");//Création du Label placé dans le Panel titre avec affichage "AccueilAdmin"
        label.setFont(new Font(Font.SERIF, Font.BOLD, 35));//Police et taille
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        titre.add(label);//Ajout le label dans le Panel titre

//=======================================================        
//Création du Panel OUEST 
//======================================================= 
        JPanel ouest = new JPanel();//JPanel ouest
        JScrollPane jScrollP = new JScrollPane(ouest);//ascenseur placé à l'ouest
        this.add(jScrollP, BorderLayout.WEST);
        //this.add(ouest, BorderLayout.WEST);
        JPanel west = new JPanel(new GridLayout(8, 0, 2, 50));//1er chiffre => nbr de lignes = 8, 
        //2 nrb de colonnes = 0, 3 espace entre les colonnes , 4 espace entre lignes = 50
        west.setBorder(BorderFactory.createEmptyBorder(40, 25, 0, 25));//1er chiffre => espace hauteur, 
        //2 espace gauche,4 espace avec centre
        ouest.add(west);

        //==============JPanel et JText==============//
        Label idUtilisate = new Label("Id Collaborateur :");//utilise la classe Label, Label id Utilisateur
        idUtilisat = new Jtext(10);//utilise la classe Jtext, Jtext id Utilisateur
        Label nom = new Label("Nom                :");//nom
        n = new Jtext(10);//nom
        Label login = new Label("Login              :");//login
        log = new Jtext(10);//login
        Label mdp = new Label("Mot de Passe :");//mot de passe
        mp = new Jtext(10);//mot de passe
        Label idProfil = new Label("Id Profil          :");//idProfil
        idProf.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"1", "2", "3", "4"}));//idProfil combobox
        idProf.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        recherche = new Jtext(10);//JText à coté du bouton rechercher
        //==============JPanel et JText==============//  

        //==============BOUTONS==============//
        Bouton ajouter = new Bouton("Ajouter");//utilise la classe Bouton
        Bouton actualiser = new Bouton("Actualiser");
        Bouton modifier = new Bouton("Modifier");
        Bouton supprimer = new Bouton("Supprimer");
        Bouton rechercher = new Bouton("Rechercher");
        //==============BOUTONS==============//

        //==============JLabel, JText et Boutons dans West==============//
        west.add(idUtilisate);/*JLabel idUtilisateur dans le Panel west*/ west.add(idUtilisat);//JText idUtilisateur dans Panel west
        west.add(nom);/*JLabel et JText*/ west.add(n);
        west.add(login);/**/ west.add(log);
        west.add(mdp);/**/ west.add(mp);
        west.add(idProfil);/**/ west.add(idProf);
        //boutons 
        west.add(ajouter);/**/ west.add(actualiser);
        west.add(modifier);/**/ west.add(supprimer);
        west.add(rechercher);/**/ west.add(recherche);
//==============JLabel, JText et Boutons dans West==============//

//========================//***ACTIONS SUR LES BOUTONS***//========================DEBUT    
        //BOUTON AJOUTER
        ajouter.addActionListener((ActionEvent ae) -> {
            recupJText();//méthode pour récuperer les jText commune au bouton modifier
            //création new Utilisateur avec paramètres récupérer dans les Jtexts
            Utilisateur ut = new Utilisateur(idUtil, no, logi, motdepasse, idProfi);//recupère tous les JTexts en paramètre
            // on recherche tous les login que l'on mettra dans une vaiable listLogin de type List
            ArrayList<String> listLogin = new ArrayList<String>();//création list de type ArrayList
            int i = 0; //i represente la ligne, et le chiffre qui suit, la colonne (2 est la colonne login car ça commence à 0)
            for (i = 0; i < model.getRowCount(); i++) {//on parcourt la colonne login 
                listLogin.add(model.getValueAt(i, 2).toString());//et on la rajoute à list
            }
            System.out.println(listLogin);//affiche pour info la liste sur console
            boolean trouvelogin = false;//booléen trouve initialisé à false
            System.out.println("On recherche le login " + logi + ":");//affiche le login tapé sur console
            if ((logi.isEmpty()) || (motdepasse.isEmpty()) || (no.isEmpty())) {//si les champs sont vides isEmpty=>JText null
                JOptionPane.showMessageDialog(null, "Veuillez rentrer tous les champs sauf l'id!");
            } else {
                for (i = 0; i < listLogin.size(); i++) {//on parcourt la list
                    if (listLogin.get(i).equals(logi)) {//si un login de la list est egal au login tapé
                        trouvelogin = true;//le booléen est true 
                        System.out.println("login " + logi + " existe dejà");//affiche console login existe deja
                        JOptionPane.showMessageDialog(null, "Le Collaborateur au login " + logi + " existe déjà! ");//message login existe
                    }
                }
                if (!trouvelogin) {//si booléen est false
                    System.out.println("login " + logi + " n'existe pas.\n");//affiche console login n'existe pas
                    //=========
                    u.create(ut);//FONCTION GENERIQUE CREATE() DE UTILISATEUR DAO appelée avec paramètre utilisateur
                    //=========                  
                    actualiser();//méthode actualiser appelée pour mettre le nouvel Utilisateur dans la Jtable(tableau)
                    JOptionPane.showMessageDialog(null, "Le Collaborateur " + no + " a bien été ajouté ");//message login ajouté car n'existe pas
                }
            }
        });

//BOUTON MODIFIER
        modifier.addActionListener((ActionEvent ae) -> {
            String recupIdUtil = idUtilisat.getText();//recupère l'idUtilisateur dans le JText
            idUtil = Integer.parseInt(recupIdUtil);//change le string jText en int
            recupJText();//méthode pour récuperer les jText commune au bouton ajouter
            Utilisateur uti = new Utilisateur(idUtil, no, logi, motdepasse, idProfi);
            //=========
            u.update(uti);//FONCTION GENERIQUE UPDATE() DE UTILISATEUR DAO
            //=========
            //g.ModifUtilisateur();
            actualiser();
        });
//BOUTON SUPPRIMER
        supprimer.addActionListener((ActionEvent ae) -> {
            idUt = idUtilisat.getText();
            if (idUt.length() != 0) {//si l'idUtilisateur dans Jtext n'est pas vide 
                //=========
                u.delete(idUt);//FONCTION GENERIQUE DELETE() DE UTILISATEUR DAO avec pour paramètre idUtilisateur ci-dessus
                //=========
                actualiser();//permet d'effacer l'utilisateur dans la JTable(tableau)
            }
        });
//BOUTON ACTUALISER
        actualiser.addActionListener((ActionEvent ae) -> {
            actualiser();//appel de la méthode actualiser()
        });
//BOUTON RECHERCHER
        rechercher.addActionListener((ActionEvent ae) -> {
            String nomRechercher = recherche.getText();//nomRechercher=>nom tapé dans dans le Jtext rechercher
            System.out.println("On recherche le Collaborateur au nom " + nomRechercher + ":");//affiche le login tapé sur console
            Utilisateur utilisateur = u.find(nomRechercher);//FONCTION GENERIQUE FIND() DE UTILISATEUR DAO parametre nom tapé dans jtext
            List<Utilisateur> recherchelistUti = u.rechercheListUtilisateur(nomRechercher);//FONCTION GENERIQUE RECHERCHELISTUTIL() DE UTILISATEUR DAO pour plusieurs Uti de même nom
            System.out.println(recherchelistUti);//affiche console la liste des utilisateurs du même nom
            if (utilisateur == null) {//si l'utilisateur n'existe pas        
                JOptionPane.showMessageDialog(null, "il y a aucun Collaborateur à ce nom");
                recherche.setText("");//efface le contenu du JText recherche
                recherche.requestFocus();//remet le curseur sur JText recherche
            } else {//sinon on creér une ligne seulement du tableau avec les mêmes champs pour lire l'utilisateur séléctionné
                model.setRowCount(0);//enlève les lignes du tableau afin d'afficher ce qui suit
                for (Utilisateur util : recherchelistUti) {
                    model.addRow(new Object[]{util.getIdUtilisateur(), util.getNom(), util.getLogin(), util.getMotdepasse(), util.getIdProfil()});
                    int i = 0;//pour 1 ligne
                    deplace(i);//méthode qui déplace les champs dans les JText 
                    actualiser.setVisible(false);
                    ajouter.setVisible(false);//enleve le bouton ajouter à la nouvelle vue
                    rechercher.setVisible(false);
                    recherche.setVisible(false);
                }
            }
        });
//========================//***ACTIONS SUR LES BOUTONS***//========================FIN  

//=======================================================        
//Création du Panel CENTRE 
//======================================================= 
        JTable tble = new JTable();
        JScrollPane jScrollPane1 = new JScrollPane(tble);//ascenseur dans la JTable
        this.add(jScrollPane1, BorderLayout.CENTER);
        tble.getTableHeader().setPreferredSize(new Dimension(200, 25));
        tble.getTableHeader().setFont(new Font(Font.SERIF, Font.PLAIN, 25));
        tble.setRowHeight(30);//hauteur des lignes
        tble.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
        jScrollPane1.setViewportView(tble);

//Création des colonnes titre du Jtable(tableau)
        model.addColumn("id");
        model.addColumn("Nom");
        model.addColumn("Login");
        model.addColumn("Mot de Passe");
        model.addColumn("Profil");

//========================//AFFICHAGE LISTE DES UTILISATEURS DANS LE TABLEAU//========================DEBUT               
        //=========//FONCTION GENERIQUE GETALL() DE UTILISATEUR DAO qui va rechercher la liste de tous les utilisateurs
        List<Utilisateur> listeUtil = u.getAll();//u est de type UtilisateurDAO instancié plus haut 
        //=========
        for (Utilisateur uti : listeUtil) {//uti est de type Utilisateur
            //parcourt la liste trouvée dans getAll() avec la variable listeUtil
            model.addRow(new Object[]{uti.getIdUtilisateur(), uti.getNom(), uti.getLogin(),
                uti.getMotdepasse(), uti.getIdProfil()});//met la liste dans le DefaultTableModel model, ligne par ligne                                                        
        }
        tble.setModel(model);//ajoute le model dans la jtable pour l'afficher
//========================//AFFICHAGE LISTE DES UTILISATEURS DANS LE TABLEAU//========================FIN 

        tble.addMouseListener(new MouseAdapter() {//clic sur une ligne=>la methode deplace() pour mettre les champs dans Jtext 
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

        retour.addActionListener((ActionEvent ae) -> {//action sur le bouton retour: efface,instancie admin de la class AccueilAdmin,ajoute à la page actuelle 
            this.removeAll();
            AccueilAdmin admin = new AccueilAdmin();
            this.add(admin);
            this.validate();
//            if(GestionUtilisateur.this.setVisible(true)) {
//                actualiser();
//            }else{
//                this.removeAll();
//                AccueilAdmin admin = new AccueilAdmin();
//                this.add(admin);
//                this.validate();
//            }

        });

    }

    private void espace() {
        west.add(Box.createRigidArea(new Dimension(20, 60)));
    }

    private void deplace(int i) {//permet de récupérer les infos de chaque champs du model(JTable) pour les inserer dans les JText 
        try {     //i represente la ligne, et le chiffre qui suit, la colonne
            idUtilisat.setText(model.getValueAt(i, 0).toString());//met la valeur de l'idUtilisateur qui est dans le tableau dans Jtext idUtilisat
            n.setText(model.getValueAt(i, 1).toString());//idem pour les autres champs
            log.setText(model.getValueAt(i, 2).toString());
            mp.setText(model.getValueAt(i, 3).toString());
            idProf.setSelectedItem(model.getValueAt(i, 4).toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erreur de deplacement de message !!" + e.getMessage());
        }
    }

//    public void tbleMouseClicked() {//clic sur une ligne, appelle la methode deplace() pour mettre les champs dans Jtext
//        try {
//            int i = tble.getSelectedRow();
//            deplace(i);
//            //sa si quant on choisir un nom dans le tableau il va afficher sur les fieldtext
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "erreur selectionne\n" + e.getMessage());
//        }
//    }
    private void actualiser() {
        this.removeAll();
        GestionUtilisateur gestionU = new GestionUtilisateur();
        this.add(gestionU);
        this.validate();
    }

    private void recupJText() {
        no = n.getText();//no,logi...récupère infos dans les Jtext(String)
        logi = log.getText();
        motdepasse = mp.getText();
        recupIdProf = idProf.getSelectedItem().toString();//récupIdProf récupère idProfil(String) dans la combobox
        idProfi = Integer.parseInt(recupIdProf);//conversion récupIdProf(String) en int car le constructeur Utilisateur est un int pour l'idProfil 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import label_jtext_bouton_constructeur.Bouton;
import label_jtext_bouton_constructeur.Label;
import label_jtext_bouton_constructeur.Jtext;
import MODELE_dao.ProfilDAO;
import VUE.AccueilAdmin;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import entity.Profil;
import java.util.List;
import VUE.ProfilAdmin;
import VUE.ProfilAutreUser;

/**
 *
 * @author lglotin
 */
public class GestionProfil extends JPanel {

    Jtext idProf, libel;
    DefaultTableModel model = new DefaultTableModel();// DTM implémente l'ensemble des méthodes
    JTable tble;
    Statement stmn;
    SQLConnection conn = new SQLConnection();
    Jtext idUtilisat, n, log, mp;
    ProfilDAO p = new ProfilDAO();

    public GestionProfil() {

//Création du PANEL dans JFRAME
        JPanel essai = new JPanel();//panel dans la Jframe
        this.setLayout(new BorderLayout());//Panel prend toute la place de la fenêtre

//=======================================================        
//Création du Panel NORD 
//=======================================================    
        JPanel titre = new JPanel();
        this.add(titre, BorderLayout.NORTH);
        titre.setBorder(BorderFactory.createLineBorder(Color.black));
        //Trait horizontal sous "AccueilAdmin"
        //titre.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.black));

        //Création du Label placé dans le Panel titre avec affichage "AccueilAdmin"
        Label label = new Label("Gestion des Profils");
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
        JPanel west = new JPanel(new GridLayout(6, 2, 2, 50));
        west.setBorder(BorderFactory.createEmptyBorder(40, 25, 0, 25));
        ouest.add(west);

        //==============JPanel et JText==============//
        Label idProfil = new Label("Id Profil :");//utilise la classe Label
        idProf = new Jtext(10);//utilise la classe Jtext 

        Label libelle = new Label("Profil    :");
        libel = new Jtext(10);

        //==============JPanel et JText==============//

        //==============BOUTONS==============//        
        Bouton ajouter = new Bouton("Ajouter");//utilise la classe bouton
        Bouton modifier = new Bouton("Modifier");
        Bouton actualiser = new Bouton("Actualiser");
        Bouton supprimer = new Bouton("Supprimer");
        //==============BOUTONS==============//   

//========================//***ACTIONS SUR LES BOUTONS***//========================DEBUT  
        ajouter.addActionListener((ActionEvent ae) -> {
            ajouter();
            actualiser();
        });

        modifier.addActionListener((ActionEvent ae) -> {
            modifier();
        });

        supprimer.addActionListener((ActionEvent ae) -> {
            //supprimer();
            String idPro = idProf.getText();
            if (idPro.length() != 0) {//si l'idUtilisateur dans Jtext n'est pas vide 
                //=========
                p.delete(idPro);//FONCTION GENERIQUE DELETE() DE UTILISATEUR DAO avec pour paramètre idUtilisateur ci-dessus
                //=========
                actualiser();//permet d'effacer l'utilisateur dans la JTable(tableau)
            }
        });

        actualiser.addActionListener((ActionEvent ae) -> {
            this.removeAll();
            GestionProfil gestionProf = new GestionProfil();
            this.add(gestionProf);
            this.validate();
        });

//========================//***ACTIONS SUR LES BOUTONS***//========================FIN  
//==============JLabel, JText et Boutons dans West==============//
        west.add(idProfil);
        west.add(idProf);
       west.add(libelle);
        west.add(libel);

        //boutons
        west.add(ajouter);
        west.add(modifier);
        west.add(actualiser);
        west.add(supprimer);

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

        //=========//FONCTION GENERIQUE GETALL() DE UTILISATEUR DAO qui va rechercher la liste de tous les utilisateurs
        List<Profil> listeProfil = p.getAll();//u est de type UtilisateurDAO instancié plus haut 
        //=========
        for (Profil prof : listeProfil) {//uti est de type Utilisateur
            //parcourt la liste trouvée dans getAll() avec la variable listeUtil
            model.addRow(new Object[]{prof.getIdProfil(), prof.getLibelleProfil()});
            //met la liste dans le DefaultTableModel model, ligne par ligne                                                        
        }
        tble.setModel(model);//ajoute le model dans la jtable pour l'afficher

        tble.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String admin = null;
                if ((e.getClickCount() == 2) && (tble.getSelectedRow() != -1)) {
                    //for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.println(model.getColumnName(j));
                        //if ((model.getValueAt(j)).eguals(admin)) {
                        System.out.println("super");
                        removeAll();
                        ProfilAdmin ProfAdm = new ProfilAdmin();
                        add(ProfAdm);
                        validate();
//                            } else {
//                                if (libelleProfil == autreuser) {
//                                    removeAll();
//                                    ProfilAutreUser Profilautre = new ProfilAutreUser();
//                                    add(Profilautre);
//                                    validate();
//                                }

                    }
                    // }

                } else {
                    int i = tble.getSelectedRow();
                    deplace(i);
                }
            }
        }
        );

//=======================================================        
//Création du Panel SUD 
//======================================================= 
        JPanel sud = new JPanel();

        this.add(sud, BorderLayout.SOUTH);

        sud.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton retour = new JButton("Retour");

        retour.setFont(
                new Font(Font.SERIF, Font.BOLD, 35));
        sud.add(retour);

        retour.addActionListener((ActionEvent ae) -> {
                    this.removeAll();
                    AccueilAdmin admin = new AccueilAdmin();
                    this.add(admin);
                    this.validate();

                }
        );

    }

    public void Afficher() {
        try {
            stmn = conn.getInstance().createStatement();
            ResultSet res = stmn.executeQuery("Select * from profil");
            while (res.next()) {
                model.addRow(new Object[]{res.getInt("idProfil"), res.getString("libelleProfil")});
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return;
    }

    private void ajouter() { //ajouter utilisateur    
        String id = idProf.getText();
        String libelle = libel.getText();
        String req = "INSERT INTO profil(idProfil,libelleProfil)VALUES('" + id + "','" + libelle + "')";
        try {
            stmn = conn.getInstance().createStatement();
//stm.executeQuery(req);
            stmn.executeUpdate(req);
            JOptionPane.showMessageDialog(null, "Le Profil " + libelle + " a bien été ajouté");
            idProf.setText("");
            libel.setText("");

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private void supprimer() {   //supprimer utilisateur                                      
        try {
            if (JOptionPane.showConfirmDialog(null, "Attention, êtes vous sur de vouloir supprimer ce profil ?",
                    "Supprimer profil", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                if (idProf.getText().length() != 0) {
                    stmn.executeUpdate("DELETE FROM profil WHERE idProfil = " + idProf.getText());
                }//ca est pour recharger la list des stagiaire
                else {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir le champ idProfil !");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de suppression \n" + e.getMessage());
        }
    }

    private void modifier() {

        String id = idProf.getText();
        String nom = libel.getText();

        try {
            if (JOptionPane.showConfirmDialog(null, "Confirmer la modification", "modification",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

                stmn.executeUpdate("UPDATE profil SET libelleProfil='" + libel.getText()
                        + "' WHERE idProfil= " + idProf.getText());
                //afficher ();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de modification !!!!!!!");
            System.err.println(e);
        }
    }

    private void deplace(int i) {//fonctionne 
        try {     //i represente les ligne 

            idProf.setText(model.getValueAt(i, 0).toString());
            // txttp.setSelectedItem(dt.getValueAt (i, 5).toString());
            libel.setText(model.getValueAt(i, 1).toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erreur de deplacement de message !!!!! " + e.getMessage());
        }
    }

    private void tbleMouseClicked() {
        try {
            int i = tble.getSelectedRow();
            deplace(i);
            //sa si quant on choisir un nom dans le tableau il va afficher sur les fieldtext
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erreur selectionne\n" + e.getMessage());
        }
    }

    private void actualiser() {
        this.removeAll();
        GestionProfil gestionP = new GestionProfil();
        this.add(gestionP);
        this.validate();
    }
}

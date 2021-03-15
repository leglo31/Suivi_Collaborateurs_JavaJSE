/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELE_dao;

import entity.Utilisateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import CONTROLEUR.GestionUtilisateur;
import CONTROLEUR.SQLConnection;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author lglotin
 */
public class UtilisateurDAO extends DAO<Utilisateur> {

    List<Utilisateur> listeUtilisateurs = new ArrayList<>();
    List<Utilisateur> listeUti = new ArrayList<>();

    Statement statement;
    PreparedStatement pstatement;
    String requeteUtilisateur;
    ResultSet resultatUtilisateur;

    @Override
    public List<Utilisateur> getAll() {
        try {
            // connection = SQLConnection.getInstance();
            statement = connection.createStatement();
            requeteUtilisateur = "SELECT * FROM Utilisateur";
            resultatUtilisateur = statement.executeQuery(requeteUtilisateur);

            while (resultatUtilisateur.next()) {
                Utilisateur utilisateur = new Utilisateur(resultatUtilisateur.getInt("idUtilisateur"),
                        resultatUtilisateur.getString("nom"), resultatUtilisateur.getString("login"),
                        resultatUtilisateur.getString("motdepasse"),
                        resultatUtilisateur.getInt("idProfil"));
                listeUtilisateurs.add(utilisateur);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeUtilisateurs;
    }

    @Override
    public void update(Utilisateur util) {
        try {
            statement = connection.createStatement();
            requeteUtilisateur = ("UPDATE utilisateur SET idUtilisateur = '" + util.getIdUtilisateur() + "', nom='"
                    + util.getNom() + "',login='" + util.getLogin()
                    + "',motdepasse='" + util.getMotdepasse() + "',idProfil='" + util.getIdProfil()
                    + "' WHERE idUtilisateur= '" + util.getIdUtilisateur() + "'");
            statement.executeUpdate(requeteUtilisateur);

            if (JOptionPane.showConfirmDialog(null, "Confirmer la modification", "modification",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
            }
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de modification !!!!!!!");
            System.err.println(e);
        }
    }

    @Override
    public void create(Utilisateur uti) {
        try {
            statement = connection.createStatement();
            requeteUtilisateur = "INSERT INTO utilisateur(nom,login,motdepasse,idProfil)VALUES('" + uti.getNom()
                    + "','" + uti.getLogin() + "','" + uti.getMotdepasse() + "','" + uti.getIdProfil() + "')";
            statement.executeUpdate(requeteUtilisateur);
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public void delete(String str_id) {
        try {
            statement = connection.createStatement();
            if (JOptionPane.showConfirmDialog(null, "Êtes vous sur de vouloir supprimer cet utilisateur ?",
                    "Supprimer utilisateur", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                statement.executeUpdate("DELETE FROM utilisateur WHERE idUtilisateur = " + str_id);
                //statement.executeUpdate("SELECT * FROM utilisateur WHERE idUtilisateur = ?");
            } //else {
            // JOptionPane.showMessageDialog(null, "Veuillez remplir le champ idUtilisateur !");
            //}
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de suppression \n" + e.getMessage());
        }
    }

    @Override
    public Utilisateur find(String nom) {
        try {
            statement = connection.createStatement();
            requeteUtilisateur = ("SELECT * FROM Utilisateur WHERE nom =  '" + nom + "'");
            resultatUtilisateur = statement.executeQuery(requeteUtilisateur);

            while (resultatUtilisateur.next()) { //Renvoie true s'il existe un résultat, prépare le traitement de la ligne, curseur passe ligne suivante
                Utilisateur utilisateur = new Utilisateur(//création d'un nouvel utilisateur avec récupération des champs
                        resultatUtilisateur.getInt("idUtilisateur"),
                        resultatUtilisateur.getString("nom"), resultatUtilisateur.getString("login"),
                        resultatUtilisateur.getString("motdepasse"), resultatUtilisateur.getInt("idProfil"));
                return utilisateur;
            }
            statement.close();
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public List<Utilisateur> rechercheListUtilisateur(String nom) {
        try {
            statement = connection.createStatement();
            requeteUtilisateur = ("SELECT * FROM Utilisateur WHERE nom =  '" + nom + "'");
            resultatUtilisateur = statement.executeQuery(requeteUtilisateur);

            while (resultatUtilisateur.next()) { //Renvoie true s'il existe un résultat, prépare le traitement de la ligne, curseur passe ligne suivante
                Utilisateur utilisateur = new Utilisateur(//création d'un nouvel utilisateur avec récupération des champs
                        resultatUtilisateur.getInt("idUtilisateur"),
                        resultatUtilisateur.getString("nom"), resultatUtilisateur.getString("login"),
                        resultatUtilisateur.getString("motdepasse"), resultatUtilisateur.getInt("idProfil"));
                listeUti.add(utilisateur);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listeUti;
    }

    public Utilisateur rechercheParLogin(String login) {
        System.out.println("Login tapé par le collaborateur: " + login);//affiche console login tapé

        try { //appel méthode singleton getInstance() de SQLConnection  car  connection = SQLConnection.getInstance();
            statement = connection.createStatement();//createStatement servant à envoyer des instructions SQL à la base de données

            //ResultSet contient les résultats de la requête
            ResultSet res = statement.executeQuery("SELECT * FROM Utilisateur WHERE login='" + login + "'"); //Requête pour obtenir un utilsateur par le login 
            //ce login est passé en parametre, on obtient les champs "Utilisateur" de ce login
            if (res.next()) { //Renvoie true s'il existe un résultat, prépare le traitement de la ligne, curseur passe ligne suivante
                Utilisateur utilisateur = new Utilisateur(//création d'un nouvel utilisateur avec récupération des champs
                        res.getInt("idUtilisateur"),
                        res.getString("nom"), res.getString("login"), res.getString("motdepasse"), res.getInt("idProfil"));
                String motdepass = res.getString("motdepasse");

                statement.close(); //Ferme la connection à la base de données
                return utilisateur;//retourne un utilisateur avec tous ses champs - "private Utilisateur"     
            } else {
                return null;//retourne aucun utilisateur
            }
        } catch (SQLException ex) {
            System.err.println(ex);//indique les erreurs de la connection
        }
        return null;//retourne aucune connection    
    }

    public List<Utilisateur> rechercheListlogin(String login) {
        System.out.println("Login tapé par l'utilisateur: " + login);//affiche console login tapé

        try { //appel méthode singleton getInstance() de SQLConnection
            statement = SQLConnection.getInstance().createStatement();//objet SQLServerStatement servant à envoyer des instructions SQL à la base de données
            //ResultSet contient les résultats de la requête
            ResultSet res = statement.executeQuery("SELECT * FROM Utilisateur WHERE login='" + login + "'"); //Requête pour obtenir un utilsateur par le login 
            //ce login est passé en parametre, on obtient les champs "Utilisateur" de ce login
            if (res.next()) { //Renvoie true s'il existe un résultat, prépare le traitement de la ligne, curseur passe ligne suivante
                Utilisateur utilisateur = new Utilisateur(//création d'un nouvel utilisateur avec récupération des champs
                        res.getInt("idUtilisateur"),
                        res.getString("nom"), res.getString("login"), res.getString("motdepasse"), res.getInt("idProfil"));
                statement.close(); //Ferme la connection à la base de données
                listeUti.add(utilisateur);//retourne un liste utilisateur avec tous ses champs - "private Utilisateur"     
            } else {
                return null;//retourne aucun utilisateur
            }
        } catch (SQLException ex) {
            System.err.println(ex);//indique les erreurs de la connection
        }
        return null;//retourne aucune connection        }
    }
}

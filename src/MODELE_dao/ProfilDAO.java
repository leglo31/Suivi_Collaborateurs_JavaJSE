/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELE_dao;

import CONTROLEUR.SQLConnection;
import entity.Profil;
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

/**
 *
 * @author lglotin
 */
public class ProfilDAO extends DAO<Profil> {

    List<Profil> listeProfil = new ArrayList<>();
    Statement statement;
    PreparedStatement pstatement;
    String requeteProfil;
    ResultSet resultatProfil;

    @Override
    public List<Profil> getAll() {
          try {
        connection = SQLConnection.getInstance();
        statement = connection.createStatement();
        requeteProfil = "SELECT * FROM Profil";
        resultatProfil = statement.executeQuery(requeteProfil);

        while (resultatProfil.next()) {
            Profil profil = new Profil(resultatProfil.getInt("idProfil"), resultatProfil.getString("libelleProfil"));
            listeProfil.add(profil);
        }
            //connection.close();
        }catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
                }
        return listeProfil;
    }

    @Override
    public void update(Profil object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Profil object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String str_id) {
try {
            connection = SQLConnection.getInstance();
            statement = connection.createStatement();
            if (JOptionPane.showConfirmDialog(null, "Êtes vous sur de vouloir supprimer ce profil ?",
                    "Supprimer profil", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                statement.executeUpdate("DELETE FROM profil WHERE idProfil= " + str_id);
                //statement.executeUpdate("SELECT * FROM utilisateur WHERE idUtilisateur = ?");
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez remplir le champ idProfil !");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de suppression \n" + e.getMessage());
        }    }

    @Override
    public Profil find(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

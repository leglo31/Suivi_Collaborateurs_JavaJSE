/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author lglotin
 */
public class Utilisateur {

    int idUtilisateur;
    String nom, login, motdepasse;
    int idProfil;

    public Utilisateur(int idUtilisateur, String nom, String login, String motdepasse, int idProfil) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.login = login;
        this.motdepasse = motdepasse;
        this.idProfil = idProfil;
    }
   
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public int getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(int idProfil) {
        this.idProfil = idProfil;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", login=" + login + ", motdepasse=" + motdepasse + ", idProfil=" + idProfil + '}';
    }
}

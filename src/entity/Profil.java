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
public class Profil {
    int idProfil;
    String libelleProfil;
    
    public Profil(int idProfil, String libelleProfil) {
        this.idProfil = idProfil;
        this.libelleProfil = libelleProfil;
    }

    public int getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(int idProfil) {
        this.idProfil = idProfil;
    }

    public String getLibelleProfil() {
        return libelleProfil;
    }

    public void setLibelleProfil(String libelleProfil) {
        this.libelleProfil = libelleProfil;
    }

    @Override
    public String toString() {
        return "Profil{" + "idProfil=" + idProfil + ", libelleProfil=" + libelleProfil + '}';
    }
    
}

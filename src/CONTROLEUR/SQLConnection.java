/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lglotin
 */
public class SQLConnection {

    private final static String HOST = "localhost"; // L'ip de l'hôte;
    private final static String PORT = "3306"; // Le port de connexion, 3306 par défaut sur MySQL;
    private final static String DATABASE = "dsi"; // La base de données sur laquelle se connecter;
    private final static String LOGIN = "root"; // Le login;
    private final static String PASSWORD = ""; // Le mot de passe;
    private static Connection connection = null;
    private final static String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

    public SQLConnection() {
    }

    public static Connection getInstance() {
        if(connection == null){
            try {
                if (connection == null) {
                    connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
                    System.out.println("Connection à la base de données " + DATABASE + " avec l'url" + URL);
                    System.out.println("Connection Réussie");
                }
            } catch (SQLException ex) {
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

}

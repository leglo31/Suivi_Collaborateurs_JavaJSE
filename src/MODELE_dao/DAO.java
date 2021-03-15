/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELE_dao;

import CONTROLEUR.SQLConnection;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author lglotin
 * @param <T>
 */
public abstract class DAO<T> {

    protected Connection connection;

    public <T> DAO() {
        connection = SQLConnection.getInstance();
    }

    public abstract List<T> getAll();

    public abstract void update(T object);

    public abstract void create(T object);

    public abstract void delete(String str_id);

    public abstract T find(String nom);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELE_dao;

import entity.Utilisateur;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lglotin
 */
public class UtilisateurDAOTest {
    
    public UtilisateurDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class UtilisateurDAO.
     */
//    @Test
//    public void testGetAll() {
//        System.out.println("getAll");
//        UtilisateurDAO instance = new UtilisateurDAO();
//        List<Utilisateur> expResult = null;
//        List<Utilisateur> result = instance.getAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of update method, of class UtilisateurDAO.
//     */
//    @Test
//    public void testUpdate() {
//        System.out.println("update");
//        Utilisateur util = null;
//        UtilisateurDAO instance = new UtilisateurDAO();
//        instance.update(util);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of create method, of class UtilisateurDAO.
//     */
//    @Test
//    public void testCreate() {
//        System.out.println("create");
//        Utilisateur uti = null;
//        UtilisateurDAO instance = new UtilisateurDAO();
//        instance.create(uti);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of delete method, of class UtilisateurDAO.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("test fonction delete");
//        String str_id = "";
//        UtilisateurDAO instance = new UtilisateurDAO();
//        instance.delete(str_id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of find method, of class UtilisateurDAO.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String nom = "fritos";
        UtilisateurDAO instance = new UtilisateurDAO();
        Utilisateur expResult = null;
        Utilisateur result = instance.find("fritos");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of rechercheListUtilisateur method, of class UtilisateurDAO.
     */
//    @Test
//    public void testRechercheListUtilisateur() {
//        System.out.println("rechercheListUtilisateur");
//        String nom = "";
//        UtilisateurDAO instance = new UtilisateurDAO();
//        List<Utilisateur> expResult = null;
//        List<Utilisateur> result = instance.rechercheListUtilisateur(nom);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of rechercheParLogin method, of class UtilisateurDAO.
//     */
//    @Test
//    public void testRechercheParLogin() {
//        System.out.println("rechercheParLogin");
//        String login = "";
//        UtilisateurDAO instance = new UtilisateurDAO();
//        Utilisateur expResult = null;
//        Utilisateur result = instance.rechercheParLogin(login);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of rechercheListlogin method, of class UtilisateurDAO.
//     */
//    @Test
//    public void testRechercheListlogin() {
//        System.out.println("rechercheListlogin");
//        String login = "";
//        UtilisateurDAO instance = new UtilisateurDAO();
//        List<Utilisateur> expResult = null;
//        List<Utilisateur> result = instance.rechercheListlogin(login);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}

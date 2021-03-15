/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package label_jtext_bouton_constructeur;

import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author lglotin
 */
public class Jtext extends javax.swing.JTextField{
      private JTextField jtext;
      
    public Jtext(int i){
        super(i);
        jtext = new JTextField(i);
        this.setFont(new Font(Font.SERIF, Font.BOLD, 25));
    }
}

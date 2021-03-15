/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package label_jtext_bouton_constructeur;

import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author lglotin
 */
public class Label extends javax.swing.JLabel{
    
    private JLabel jlabel;
    
    public Label(String text){
        super(text);
        jlabel = new JLabel(text);
        this.setFont(new Font(Font.SERIF, Font.BOLD, 25));
    }
}

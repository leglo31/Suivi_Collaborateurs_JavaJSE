/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package label_jtext_bouton_constructeur;

import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author lglotin
 */
public class Bouton extends JButton {

    private JButton button;

    public Bouton(String text) {
        super(text);//appel le constructeur de JButton
        button = new JButton(text);
        this.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        //this.setBorderPainted(false);
    }
}

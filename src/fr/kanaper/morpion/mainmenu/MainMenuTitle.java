package fr.kanaper.morpion.mainmenu;

import javax.swing.JLabel;

import java.awt.Color;

/**
 * Classe MainMenuTitle permettant de créer le titre du menu principal
 * 
 * @version 1.0
 * @autor Kanaper
 */
public class MainMenuTitle extends JLabel {

    /**
     * Constructeur de la classe MainMenuTitle
     */
    public MainMenuTitle() {
        super("Morpion");

        this.setBounds(0, 150, MainMenuWindow.WIDTH, 150);
        this.setBackground(Color.BLACK);

        this.setFont(this.getFont().deriveFont(90f));
        this.setHorizontalAlignment(JLabel.CENTER);
    }

}

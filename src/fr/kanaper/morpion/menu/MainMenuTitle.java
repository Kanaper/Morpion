package fr.kanaper.morpion.menu;

import javax.swing.JLabel;

import java.awt.Color;

public class MainMenuTitle extends JLabel {

    public MainMenuTitle() {
        super("Morpion");

        this.setBounds(0, 150, MainMenuWindow.WIDTH, 150);
        this.setBackground(Color.BLACK);

        this.setFont(this.getFont().deriveFont(90f));
        this.setHorizontalAlignment(JLabel.CENTER);
    }

}

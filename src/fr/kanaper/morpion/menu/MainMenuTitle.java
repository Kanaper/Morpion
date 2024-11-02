package fr.kanaper.morpion.menu;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.Color;

public class MainMenuTitle extends JLabel {

    public MainMenuTitle() {
        super("Morpion");

        Border lineborder = BorderFactory.createLineBorder(Color.black, 1);

        this.setBorder(lineborder);
        this.setBounds(0, 50, MainMenuWindow.WIDTH, 150);
        this.setBackground(Color.BLACK);

        this.setFont(this.getFont().deriveFont(90f));
        this.setHorizontalAlignment(JLabel.CENTER);
    }

}

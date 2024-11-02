package fr.kanaper.morpion.menu;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import java.awt.Color;

import fr.kanaper.morpion.component.KanButton;

public class MainMenuButton extends JPanel {

    private static final int PANWIDTH = MainMenuWindow.WIDTH - 200;
    private static final int PANHEIGHT = MainMenuWindow.HEIGHT - 400;

    public MainMenuButton() {
        super();
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);

        Border lineborder = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(lineborder);

        KanButton play = new KanButton("Play", PANHEIGHT + 50, PANWIDTH + 50);
        this.add(play);

        KanButton quit = new KanButton("quit", PANHEIGHT + 150, PANWIDTH + 250);
        this.add(quit);
    }

}

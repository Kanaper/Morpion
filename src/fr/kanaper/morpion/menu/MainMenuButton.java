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

        KanButton play = new KanButton("Play");
        play.setBounds(PANWIDTH / 2 - 250, PANHEIGHT / 2 - 50, 200, 100);
        play.addActionListener(new MainMenuButtonListener());
        this.add(play);

        KanButton quit = new KanButton("quit");
        quit.setBounds(PANWIDTH / 2 + 50, PANHEIGHT / 2 - 50, 200, 100);
        quit.addActionListener(new MainMenuButtonListener());
        this.add(quit);

        this.setOpaque(false);
    }

}

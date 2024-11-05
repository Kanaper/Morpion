package fr.kanaper.morpion.menu;

import javax.swing.JPanel;

import fr.kanaper.morpion.component.KanButton;
import fr.kanaper.morpion.enums.KanButtonType;

public class MainMenuButton extends JPanel {

    private static final int PANWIDTH = MainMenuWindow.WIDTH - 200;
    private static final int PANHEIGHT = MainMenuWindow.HEIGHT - 400;

    public MainMenuButton(MainMenuWindow menuWindow) {
        super();
        this.setLayout(null);

        KanButton play = new KanButton("Play", 185, 85);
        play.setBounds(PANWIDTH / 2 - 250, PANHEIGHT / 2 - 50, 200, 100);
        play.addActionListener(new MainMenuButtonListener(KanButtonType.PLAY, menuWindow));
        this.add(play);

        KanButton quit = new KanButton("Quit", 185, 85);
        quit.setBounds(PANWIDTH / 2 + 50, PANHEIGHT / 2 - 50, 200, 100);
        quit.addActionListener(new MainMenuButtonListener(KanButtonType.QUIT, menuWindow));
        this.add(quit);

        this.setOpaque(false);
    }

}

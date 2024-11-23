package fr.kanaper.morpion.mainmenu;

import javax.swing.JPanel;

import fr.kanaper.morpion.component.KanButton;
import fr.kanaper.morpion.enums.KanButtonType;

public class MainMenuButtonPanel extends JPanel {

    private static final int PANWIDTH = MainMenuWindow.WIDTH - 200;
    private static final int PANHEIGHT = MainMenuWindow.HEIGHT - 400;

    public MainMenuButtonPanel(MainMenuWindow menuWindow) {
        super();
        this.setLayout(null);

        KanButton play = new KanButton("Play", KanButtonType.PLAY, menuWindow);
        play.setWidth(150);
        play.setHeight(100);
        play.setBounds(PANWIDTH / 2 - 250, PANHEIGHT / 2 - 50, play.getWidth(), play.getHeight());
        play.addActionListener(new MainMenuButtonPanelListener(KanButtonType.PLAY, menuWindow));
        this.add(play);

        KanButton quit = new KanButton("Quit", KanButtonType.QUIT, menuWindow);
        quit.setWidth(150);
        quit.setHeight(100);
        quit.setBounds(PANWIDTH / 2 + 50, PANHEIGHT / 2 - 50, quit.getWidth() + 50, quit.getHeight() + 50);
        quit.addActionListener(new MainMenuButtonPanelListener(KanButtonType.QUIT, menuWindow));
        this.add(quit);

        this.setOpaque(false);
    }

}

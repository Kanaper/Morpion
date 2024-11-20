package fr.kanaper.morpion.mainmenu;

import java.awt.event.ActionListener;

import fr.kanaper.morpion.enums.KanButtonType;
import fr.kanaper.morpion.jeu.ChoosePlayer;
import fr.kanaper.morpion.jeu.Game;

import java.awt.event.ActionEvent;

public class MainMenuButtonListener implements ActionListener {

    private KanButtonType type;
    private MainMenuWindow window;

    public MainMenuButtonListener(KanButtonType type, MainMenuWindow window) {
        this.type = type;
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (this.type) {
            case PLAY:
                Game game = new Game();
                game.setVisible(true);
                this.window.dispose();
                new ChoosePlayer(game);
                break;
            case QUIT:
                this.window.dispose();
                break;
            default:
                throw new IllegalArgumentException("invalid type");
        }

    }
}

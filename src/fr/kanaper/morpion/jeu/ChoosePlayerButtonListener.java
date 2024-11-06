package fr.kanaper.morpion.jeu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import fr.kanaper.morpion.enums.PlayerType;

public class ChoosePlayerButtonListener implements ActionListener {

    private PlayerType player;
    private Game gameWindow;
    private ChoosePlayer modalWindow;

    public ChoosePlayerButtonListener(ChoosePlayer modalWindow, PlayerType player, Game gameWindow) {
        this.player = player;
        this.gameWindow = gameWindow;
        this.modalWindow = modalWindow;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (this.player) {
            case PlayerType.PLAYER1:
                this.gameWindow.setCurrentPlayer(this.gameWindow.player1);
                this.modalWindow.dispose();
                break;
            case PlayerType.PLAYER2:
                this.gameWindow.setCurrentPlayer(this.gameWindow.player2);
                this.modalWindow.dispose();
                break;
            default:
                throw new IllegalArgumentException("invalid player");
        }
    }

}

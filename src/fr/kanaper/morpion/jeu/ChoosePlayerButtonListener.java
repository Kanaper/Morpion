package fr.kanaper.morpion.jeu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import fr.kanaper.morpion.enums.Player;

public class ChoosePlayerButtonListener implements ActionListener {

    private Player player;
    private Game gameWindow;
    private ChoosePlayer modalWindow;

    public ChoosePlayerButtonListener(ChoosePlayer modalWindow, Player player, Game gameWindow) {
        this.player = player;
        this.gameWindow = gameWindow;
        this.modalWindow = modalWindow;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (this.player) {
            case Player.PLAYER1:
                this.gameWindow.setCurrentPlayer(Player.PLAYER1);
                this.modalWindow.dispose();
                break;
            case Player.PLAYER2:
                this.gameWindow.setCurrentPlayer(Player.PLAYER2);
                this.modalWindow.dispose();
                break;
            default:
                throw new IllegalArgumentException("invalid player");
        }
    }

}

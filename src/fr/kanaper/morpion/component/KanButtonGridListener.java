package fr.kanaper.morpion.component;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import fr.kanaper.morpion.jeu.Game;
import fr.kanaper.morpion.enums.Player;

public class KanButtonGridListener implements ActionListener {

    private Game gameWindow;
    private KanButtonGrid button;

    public KanButtonGridListener(Game gameWindow, KanButtonGrid button) {
        this.gameWindow = gameWindow;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.button.getFilled()) {
            switch (this.gameWindow.getCurrentPlayer()) {
                case PLAYER1:
                    this.gameWindow.setCurrentPlayer(Player.PLAYER2);
                    break;

                case PLAYER2:
                    this.gameWindow.setCurrentPlayer(Player.PLAYER1);
                    break;

                default:
                    throw new IllegalArgumentException("Unexpected value: " + this.gameWindow.getCurrentPlayer());
            }
        }
        if (this.button.getMouseInButton()) {
            this.button.setButtonClicked(true);
            this.button.setMouseInButton(false);
            this.button.repaint();
        }
    }
}

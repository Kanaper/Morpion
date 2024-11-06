package fr.kanaper.morpion.component;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import fr.kanaper.morpion.jeu.Game;
import fr.kanaper.morpion.jeu.Player;
import fr.kanaper.morpion.enums.PlayerType;

public class KanButtonGridListener implements ActionListener {

    private Game gameWindow;
    private KanButtonGrid button;

    public KanButtonGridListener(Game gameWindow, KanButtonGrid button, Player player) {
        this.gameWindow = gameWindow;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!this.button.getFilled()) {
            switch (this.gameWindow.getCurrentPlayer().getPlayerType()) {
                case PLAYER1:
                    this.gameWindow.nextPlayer();
                    break;

                case PLAYER2:
                    this.gameWindow.nextPlayer();
                    break;

                default:
                    throw new IllegalArgumentException("Unexpected value: " + this.gameWindow.getCurrentPlayer());
            }
        }
        if (this.button.getMouseInButton()) {
            this.button.setButtonClicked(true);
            this.button.setMouseInButton(false);
            this.button.repaint();

            this.gameWindow.getCurrentPlayer().posList[this.button.getGridX()][this.button.getGridY()] = 1;

            this.gameWindow.checkEndGame(this.gameWindow.getCurrentPlayer());
        }
    }
}

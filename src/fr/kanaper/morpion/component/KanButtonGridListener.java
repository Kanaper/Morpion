package fr.kanaper.morpion.component;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import fr.kanaper.morpion.jeu.Game;
import fr.kanaper.morpion.jeu.Player;

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
            this.gameWindow.nextPlayer();
            this.gameWindow.getCurrentPlayer().posList[this.button.getGridX()][this.button.getGridY()] = 1;
            this.button.setPlayer(this.gameWindow.getCurrentPlayer());
            this.button.setFilled(true);
            this.button.repaint();
            this.gameWindow.checkEndGame(this.gameWindow.getCurrentPlayer());
            System.out.println("je suis le bouton " + this.button.getGridX() + " " + this.button.getGridY()
                    + " et je lance la recherche");
        }
    }
}

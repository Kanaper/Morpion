package fr.kanaper.morpion.component;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import fr.kanaper.morpion.jeu.Game;
import fr.kanaper.morpion.jeu.Player;

/**
 * classe qui permet de gérer les actions des boutons de la grille
 * 
 * @version 1.0
 * @author Kanaper
 */
public class KanButtonGridListener implements ActionListener {

    private Game gameWindow;
    private KanButtonGrid button;

    /**
     * Constructeur de la classe KanButtonGridListener
     * 
     * @param gameWindow la fenêtre de jeu
     * @param button     le bouton de la grille
     * @param player     le joueur
     */
    public KanButtonGridListener(Game gameWindow, KanButtonGrid button, Player player) {
        this.gameWindow = gameWindow;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!this.button.getFilled()) {
            this.gameWindow.getCurrentPlayer().setMove(this.gameWindow.getCurrentPlayer().getMove() + 1);
            this.gameWindow.getCurrentPlayer().posList[this.button.getGridX()][this.button.getGridY()] = 1;
            this.button.setPlayer(this.gameWindow.getCurrentPlayer());
            this.button.setFilled(true);
            this.button.repaint();
            this.gameWindow.checkEndGame(this.gameWindow.getCurrentPlayer());
            this.gameWindow.nextPlayer();
            this.gameWindow.getGrid().repaint();
        }
    }
}

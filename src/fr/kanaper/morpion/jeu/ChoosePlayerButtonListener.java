package fr.kanaper.morpion.jeu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import fr.kanaper.morpion.enums.PlayerType;

/**
 * classe ChoosePlayerButtonListener permettant de gérer les événements sur les
 * boutons de choix de joueur
 * 
 * @version 1.0
 * @autor Kanaper
 */
public class ChoosePlayerButtonListener implements ActionListener {

    private PlayerType player;
    private Game gameWindow;
    private ChoosePlayer modalWindow;

    /**
     * Constructeur de la classe ChoosePlayerButtonListener
     * 
     * @param modalWindow fenêtre modale
     * @param player      joueur
     * @param gameWindow  fenêtre de jeu
     */
    public ChoosePlayerButtonListener(ChoosePlayer modalWindow, PlayerType player, Game gameWindow) {
        this.player = player;
        this.gameWindow = gameWindow;
        this.modalWindow = modalWindow;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (this.player) {
            case PlayerType.CROSS:
                this.gameWindow.setCurrentPlayer(this.gameWindow.player1);
                this.modalWindow.dispose();
                break;
            case PlayerType.CIRCLE:
                this.gameWindow.setCurrentPlayer(this.gameWindow.player2);
                this.modalWindow.dispose();
                break;
            default:
                throw new IllegalArgumentException("invalid player");
        }
    }

}

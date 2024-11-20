package fr.kanaper.morpion.jeu;

import fr.kanaper.morpion.enums.PlayerType;

/**
 * Cette classe permet de créer un joueurs
 * 
 * @version 1.0
 * @author kanaper
 */
public class Player {

    public int[][] posList;
    private PlayerType playerType;

    /**
     * Constructeur de la classe Player
     * 
     * @param player le type de joueur
     */
    public Player(PlayerType player) {

        this.playerType = player;
        this.posList = new int[3][3];

    }

    /**
     * Permet de récupérer le type de joueur
     * 
     * @return le type de joueur
     */
    public PlayerType getPlayerType() {
        return this.playerType;
    }
}
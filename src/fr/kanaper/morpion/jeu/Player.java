package fr.kanaper.morpion.jeu;

import fr.kanaper.morpion.enums.PlayerType;

public class Player {

    public int[][] posList;
    private PlayerType playerType;

    public Player(PlayerType player) {

        this.playerType = player;
        this.posList = new int[3][3];

    }

    public PlayerType getPlayerType() {
        return this.playerType;
    }
}

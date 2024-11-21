package fr.kanaper.morpion.jeu;

import javax.swing.JFrame;

import fr.kanaper.morpion.enums.PlayerType;
import fr.kanaper.morpion.endmenu.endMenu;

/**
 * Game class
 * 
 * @version 1.0
 * @author Kanaper
 */
public class Game extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;

    public Player player1;
    public Player player2;

    private Player currentPlayer;

    /**
     * constructeur de la classe Game, initialise la fenêtre de jeu
     * 
     * @version 1.0
     * @author Kanaper
     */
    public Game() {
        this.setTitle("Morpion");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.player1 = new Player(PlayerType.PLAYER1);
        this.player2 = new Player(PlayerType.PLAYER2);

        Grid grid = new Grid(this);
        this.add(grid);
    }

    /**
     * retourne le joueur actuel
     * 
     * @return Player
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * défini le joueur actuel
     * 
     * @param player joueur actuel
     */
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    /**
     * change le joueur actuel
     */
    public void nextPlayer() {
        if (this.currentPlayer == this.player1) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = this.player1;
        }
    }

    /**
     * vérifie si la partie est terminée
     * 
     * @param player joueur actuel
     */
    public void checkEndGame(Player player) {
        for (int x = 0; x < 3; x++) {
            if (player.posList[x][0] == 1 && player.posList[x][1] == 1 && player.posList[x][2] == 1) {
                new endMenu(this, player);
            }
            if (player.posList[0][x] == 1 && player.posList[1][x] == 1 && player.posList[2][x] == 1) {
                new endMenu(this, player);
            }
        }
        if (player.posList[0][0] == 1 && player.posList[1][1] == 1 && player.posList[2][2] == 1) {
            new endMenu(this, player);
        }
        if (player.posList[0][2] == 1 && player.posList[1][1] == 1 && player.posList[2][0] == 1) {
            new endMenu(this, player);
        }
        if (player.getMove() == 5) {
            new endMenu(this, null);
        }
    }

}

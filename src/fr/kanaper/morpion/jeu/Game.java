package fr.kanaper.morpion.jeu;

import javax.swing.JFrame;

import fr.kanaper.morpion.enums.PlayerType;

public class Game extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;

    private Player currentPlayer;
    public Player player1;
    public Player player2;

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

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public void nextPlayer() {
        if (this.currentPlayer == this.player1) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = this.player1;
        }
    }

    public void checkEndGame(Player player) {
        for (int x = 0; x < 3; x++) {
            if (player.posList[x][0] == 1 && player.posList[x][1] == 1 && player.posList[x][2] == 1) {
                System.out.println("Player A win");
            }
            if (player.posList[0][0] == 1 && player.posList[1][1] == 1 && player.posList[2][2] == 1) {
                System.out.println("Player B win");
            }
            if (player.posList[0][x] == 1 && player.posList[1][x] == 1 && player.posList[2][x] == 1) {
                System.out.println("Player C win");
            }
            if (player.posList[0][2] == 1 && player.posList[1][1] == 1 && player.posList[2][0] == 1) {
                System.out.println("Player D win");
            }
        }
    }

}

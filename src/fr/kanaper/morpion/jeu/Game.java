package fr.kanaper.morpion.jeu;

import javax.swing.JFrame;

import fr.kanaper.morpion.enums.Player;

public class Game extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;

    private Player currentPlayer;

    public Game() {
        this.setTitle("Morpion");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        Grid grid = new Grid(this);
        this.add(grid);
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

}

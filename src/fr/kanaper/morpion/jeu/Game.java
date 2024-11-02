package fr.kanaper.morpion.jeu;

import javax.swing.JFrame;

public class Game extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;

    public Game() {
        this.setTitle("Morpion");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        Grid grid = new Grid();
        this.add(grid);
    }

}

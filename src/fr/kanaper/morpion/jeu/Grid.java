package fr.kanaper.morpion.jeu;

import javax.swing.JPanel;

import fr.kanaper.morpion.component.KanButtonGrid;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.BasicStroke;

/**
 * Classe Grid permettant de créer la grille de jeu
 * 
 * @version 1.0
 * @autor Kanaper
 */
public class Grid extends JPanel {

    public static final int GRIDSIZE = 500;
    private static final int xStart = Game.WIDTH / 2 - GRIDSIZE / 2;
    private static final int yStart = Game.HEIGHT / 2 - GRIDSIZE / 2;

    private Game gameWindow;

    /**
     * Constructeur de la classe Grid
     * 
     * @param gameWindow fenêtre de jeu
     */
    public Grid(Game gameWindow) {
        this.setBounds(xStart - 5, yStart - 5, GRIDSIZE + 7, GRIDSIZE + 7);
        this.setLayout(null);

        this.gameWindow = gameWindow;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                this.add(new KanButtonGrid(xStart + x * GRIDSIZE / 3, yStart + y * GRIDSIZE / 3, gameWindow, x, y));
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5));

        g2d.drawRect(xStart, yStart, GRIDSIZE, GRIDSIZE);
        g2d.drawLine(xStart + GRIDSIZE / 3, yStart, xStart + GRIDSIZE / 3, yStart + GRIDSIZE);
        g2d.drawLine(xStart + 2 * GRIDSIZE / 3, yStart, xStart + 2 * GRIDSIZE / 3, yStart + GRIDSIZE);
        g2d.drawLine(xStart, yStart + GRIDSIZE / 3, xStart + GRIDSIZE, yStart + GRIDSIZE / 3);
        g2d.drawLine(xStart, yStart + 2 * GRIDSIZE / 3, xStart + GRIDSIZE, yStart + 2 * GRIDSIZE / 3);

        if (this.gameWindow.getCurrentPlayer() != null) {
            switch (this.gameWindow.getCurrentPlayer().getPlayerType()) {
                case CROSS:
                    g2d.setColor(Color.RED);
                    g2d.setStroke(new BasicStroke(3));
                    g2d.drawRect(xStart - 3, yStart - 3, GRIDSIZE + 5, GRIDSIZE + 5);
                    break;

                case CIRCLE:
                    g2d.setColor(Color.BLUE);
                    g2d.setStroke(new BasicStroke(3));
                    g2d.drawRect(xStart - 3, yStart - 3, GRIDSIZE + 5, GRIDSIZE + 5);
                    break;

                default:
                    throw new IllegalArgumentException("Unexpected value: " +
                            this.gameWindow.getCurrentPlayer());
            }
        }
    }
}

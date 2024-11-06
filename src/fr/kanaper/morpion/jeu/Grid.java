package fr.kanaper.morpion.jeu;

import javax.swing.JPanel;

import fr.kanaper.morpion.component.KanButtonGrid;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.BasicStroke;

public class Grid extends JPanel {

    public static final int GRIDSIZE = 500;
    private static final int xStart = Game.WIDTH / 2 - GRIDSIZE / 2;
    private static final int yStart = Game.HEIGHT / 2 - GRIDSIZE / 2;

    public Grid(Game gameWindow) {
        this.setBounds(xStart, yStart, GRIDSIZE, GRIDSIZE);
        this.setLayout(null);

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

        // grid
        g2d.drawRect(xStart, yStart, GRIDSIZE, GRIDSIZE);
        g2d.drawLine(xStart + GRIDSIZE / 3, yStart, xStart + GRIDSIZE / 3, yStart + GRIDSIZE);
        g2d.drawLine(xStart + 2 * GRIDSIZE / 3, yStart, xStart + 2 * GRIDSIZE / 3, yStart + GRIDSIZE);
        g2d.drawLine(xStart, yStart + GRIDSIZE / 3, xStart + GRIDSIZE, yStart + GRIDSIZE / 3);
        g2d.drawLine(xStart, yStart + 2 * GRIDSIZE / 3, xStart + GRIDSIZE, yStart + 2 * GRIDSIZE / 3);

    }
}

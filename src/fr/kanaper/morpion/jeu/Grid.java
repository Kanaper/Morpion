package fr.kanaper.morpion.jeu;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class Grid extends JPanel {

    private static final int gridWidth = 500;
    private static final int gridHeight = 500;
    private static final int xStart = Game.WIDTH / 2 - gridWidth / 2;
    private static final int yStart = Game.HEIGHT / 2 - gridHeight / 2;

    public Grid() {

        this.setBounds(xStart, yStart, gridWidth, gridHeight);
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5));

        // grid
        g2d.drawRect(xStart, yStart, gridWidth, gridHeight);
        g2d.drawLine(xStart + gridWidth / 3, yStart, xStart + gridWidth / 3, yStart + gridHeight);
        g2d.drawLine(xStart + 2 * gridWidth / 3, yStart, xStart + 2 * gridWidth / 3, yStart + gridHeight);
        g2d.drawLine(xStart, yStart + gridHeight / 3, xStart + gridWidth, yStart + gridHeight / 3);
        g2d.drawLine(xStart, yStart + 2 * gridHeight / 3, xStart + gridWidth, yStart + 2 * gridHeight / 3);

    }
}

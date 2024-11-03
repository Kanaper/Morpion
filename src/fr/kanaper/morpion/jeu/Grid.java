package fr.kanaper.morpion.jeu;

import javax.swing.JPanel;

import fr.kanaper.morpion.component.KanButtonGrid;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.BasicStroke;

public class Grid extends JPanel {

    public static final int GRIDWIDTH = 500;
    public static final int GRIDHEIGHT = 500;
    private static final int xStart = Game.WIDTH / 2 - GRIDWIDTH / 2;
    private static final int yStart = Game.HEIGHT / 2 - GRIDHEIGHT / 2;

    public Grid() {
        this.setBounds(xStart, yStart, GRIDWIDTH, GRIDHEIGHT);
        this.setLayout(null);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                this.add(new KanButtonGrid(xStart + x * GRIDWIDTH / 3, yStart + y * GRIDHEIGHT / 3));
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
        g2d.drawRect(xStart, yStart, GRIDWIDTH, GRIDHEIGHT);
        g2d.drawLine(xStart + GRIDWIDTH / 3, yStart, xStart + GRIDWIDTH / 3, yStart + GRIDHEIGHT);
        g2d.drawLine(xStart + 2 * GRIDWIDTH / 3, yStart, xStart + 2 * GRIDWIDTH / 3, yStart + GRIDHEIGHT);
        g2d.drawLine(xStart, yStart + GRIDHEIGHT / 3, xStart + GRIDWIDTH, yStart + GRIDHEIGHT / 3);
        g2d.drawLine(xStart, yStart + 2 * GRIDHEIGHT / 3, xStart + GRIDWIDTH, yStart + 2 * GRIDHEIGHT / 3);

    }
}

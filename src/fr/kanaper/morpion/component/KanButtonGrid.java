package fr.kanaper.morpion.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.AlphaComposite;

import javax.swing.JButton;

import fr.kanaper.morpion.jeu.Grid;
import fr.kanaper.morpion.jeu.Game;
import fr.kanaper.morpion.enums.Player;

public class KanButtonGrid extends JButton {

    private static final int CASESIZE = Grid.GRIDSIZE / 3;
    private boolean mouseIn = false;
    private boolean filled = false;
    private Game gameWindow;
    private Player player;
    private boolean buttonClicked = false;

    public KanButtonGrid(int xStart, int yStart, Game gameWindow) {
        this.setBounds(xStart, yStart, CASESIZE, CASESIZE);

        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        this.gameWindow = gameWindow;

        this.addMouseListener(new KanButtonGridMouseListener(this));
        this.addActionListener(new KanButtonGridListener(gameWindow, this));

    }

    public void setMouseInButton(boolean mousIn) {
        this.mouseIn = mousIn;
    }

    public boolean getMouseInButton() {
        return this.mouseIn;
    }

    public boolean getFilled() {
        return this.filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean getButtonClicked() {
        return this.buttonClicked;
    }

    public void setButtonClicked(boolean buttonClicked) {
        if (this.buttonClicked) {
            return;
        } else {
            this.buttonClicked = buttonClicked;
            this.player = this.gameWindow.getCurrentPlayer();
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        float opacite = 0.2f;

        g2d.setStroke(new BasicStroke(5));

        if (!getFilled()) {
            if (getMouseInButton()) {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacite));
                g2d.setColor(Color.GRAY);
                g2d.fillRect(0, 0, CASESIZE, CASESIZE);

                g2d.setColor(Color.BLACK);
                g2d.drawRect(0, 0, CASESIZE, CASESIZE);
            } else {
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, CASESIZE, CASESIZE);

                g2d.setColor(Color.BLACK);
                g2d.drawRect(0, 0, CASESIZE, CASESIZE);
            }

            if (getButtonClicked()) {
                switch (this.player) {
                    case PLAYER1:
                        g2d.setColor(Color.RED);
                        g2d.drawLine(0, 0, CASESIZE, CASESIZE);
                        g2d.drawLine(CASESIZE, 0, 0, CASESIZE);
                        this.setFilled(true);
                        break;

                    case PLAYER2:
                        g2d.setColor(Color.BLUE);
                        g2d.drawOval(0, 0, CASESIZE, CASESIZE);
                        this.setFilled(true);
                        break;

                    default:
                        throw new IllegalArgumentException("Unexpected value: " + this.gameWindow.getCurrentPlayer());
                }
            }

        } else {
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, CASESIZE, CASESIZE);
            switch (this.player) {
                case PLAYER1:
                    g2d.setColor(Color.RED);
                    g2d.drawLine(0, 0, CASESIZE, CASESIZE);
                    g2d.drawLine(CASESIZE, 0, 0, CASESIZE);
                    break;

                case PLAYER2:
                    g2d.setColor(Color.BLUE);
                    g2d.drawOval(0, 0, CASESIZE, CASESIZE);
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Unexpected value: " + this.gameWindow.getCurrentPlayer());
            }
            g2d.setColor(Color.BLACK);
            g2d.drawRect(0, 0, CASESIZE, CASESIZE);
        }

    }
}
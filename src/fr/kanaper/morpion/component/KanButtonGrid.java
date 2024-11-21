package fr.kanaper.morpion.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.AlphaComposite;

import javax.swing.JButton;

import fr.kanaper.morpion.jeu.Grid;
import fr.kanaper.morpion.jeu.Game;
import fr.kanaper.morpion.jeu.Player;

/**
 * Cette classe permet de créer les boutons de la grille de jeu
 * 
 * @version 1.0
 * @author Kanaper
 */
public class KanButtonGrid extends JButton {

    private static final int CASESIZE = Grid.GRIDSIZE / 3;

    private boolean filled = false;
    private boolean mouseIn = false;

    private Game gameWindow;
    private Player player;

    private int gridX;
    private int gridY;

    /**
     * Constructeur de la classe KanButtonGrid
     * 
     * @param xStart     la position en x du bouton
     * @param yStart     la position en y du bouton
     * @param gameWindow la fenêtre de jeu
     * @param gridX      la position en x du bouton dans la grille
     * @param gridY      la position en y du bouton dans la grille
     */
    public KanButtonGrid(int xStart, int yStart, Game gameWindow, int gridX, int gridY) {
        this.setBounds(xStart, yStart, CASESIZE, CASESIZE);

        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        this.gameWindow = gameWindow;
        this.gridX = gridX;
        this.gridY = gridY;

        this.addMouseListener(new KanButtonGridMouseListener(this));
        this.addActionListener(new KanButtonGridListener(gameWindow, this, this.player));

    }

    /**
     * Méthode permettant de récupérer la position en x du bouton dans la grille
     * 
     * @return la position en x du bouton dans la grille
     */
    public int getGridX() {
        return this.gridX;
    }

    /**
     * Méthode permettant de récupérer la position en y du bouton dans la grille
     * 
     * @return la position en y du bouton dans la grille
     */
    public int getGridY() {
        return this.gridY;
    }

    /**
     * Méthode permettant d'indiquer si la souris est sur le bouton
     * 
     * @param mousIn true si la souris est sur le bouton, false sinon
     */
    public void setMouseInButton(boolean mousIn) {
        this.mouseIn = mousIn;
    }

    /**
     * Méthode permettant de savoir si la souris est sur le bouton
     * 
     * @return true si la souris est sur le bouton, false sinon
     */
    public boolean getMouseInButton() {
        return this.mouseIn;
    }

    /**
     * Méthode permettant de savoir si le bouton est rempli
     * 
     * @return true si le bouton est rempli, false sinon
     */
    public boolean getFilled() {
        return this.filled;
    }

    /**
     * Méthode permettant de remplir le bouton
     * 
     * @param filled true si le bouton est rempli, false sinon
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Méthode permettant de récupérer le joueur qui a rempli le bouton
     * 
     * @return le joueur qui a rempli le bouton
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        float opacite = 0.1f;

        g2d.setStroke(new BasicStroke(5));

        if (!getFilled()) {
            if (getMouseInButton()) {
                this.player = gameWindow.getCurrentPlayer();
                switch (this.player.getPlayerType()) {
                    case CROSS:
                        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacite));
                        g2d.setColor(Color.GRAY);
                        g2d.fillRect(0, 0, CASESIZE, CASESIZE);
                        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
                        g2d.setColor(Color.RED);
                        g2d.drawLine(0, 0, CASESIZE, CASESIZE);
                        g2d.drawLine(CASESIZE, 0, 0, CASESIZE);
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(0, 0, CASESIZE, CASESIZE);
                        break;

                    case CIRCLE:
                        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacite));
                        g2d.setColor(Color.GRAY);
                        g2d.fillRect(0, 0, CASESIZE, CASESIZE);
                        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
                        g2d.setColor(Color.BLUE);
                        g2d.drawOval(0, 0, CASESIZE, CASESIZE);
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(0, 0, CASESIZE, CASESIZE);
                        break;

                    default:
                        throw new IllegalArgumentException("Unexpected value: " + this.gameWindow.getCurrentPlayer());
                }
            } else {
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, CASESIZE, CASESIZE);

                g2d.setColor(Color.BLACK);
                g2d.drawRect(0, 0, CASESIZE, CASESIZE);
            }
        } else {
            switch (this.player.getPlayerType()) {
                case CROSS:
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(0, 0, CASESIZE, CASESIZE);
                    g2d.setColor(Color.RED);
                    g2d.drawLine(0, 0, CASESIZE, CASESIZE);
                    g2d.drawLine(CASESIZE, 0, 0, CASESIZE);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(0, 0, CASESIZE, CASESIZE);
                    break;

                case CIRCLE:
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(0, 0, CASESIZE, CASESIZE);
                    g2d.setColor(Color.BLUE);
                    g2d.drawOval(0, 0, CASESIZE, CASESIZE);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(0, 0, CASESIZE, CASESIZE);
                    break;

                default:
                    throw new IllegalArgumentException("Unexpected value: " + this.gameWindow.getCurrentPlayer());
            }
        }
    }
}
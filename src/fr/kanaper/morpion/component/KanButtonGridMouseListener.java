package fr.kanaper.morpion.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Cette classe permet de gérer les actions de la souris sur les boutons de la
 * grille de jeu
 * 
 * @version 1.0
 * @author Kanaper
 */
public class KanButtonGridMouseListener implements MouseListener {

    private KanButtonGrid button;

    /**
     * Constructeur de la classe KanButtonGridMouseListener
     * 
     * @param button le bouton sur lequel on applique les actions de la souris
     */
    public KanButtonGridMouseListener(KanButtonGrid button) {
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (!this.button.getFilled()) {
            this.button.setMouseInButton(true);
            this.button.repaint();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (!this.button.getFilled()) {
            this.button.setMouseInButton(false);
            this.button.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

}

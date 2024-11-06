package fr.kanaper.morpion.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KanButtonGridMouseListener implements MouseListener {

    private KanButtonGrid button;

    public KanButtonGridMouseListener(KanButtonGrid button) {
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.button.setMouseInButton(true);
        this.button.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.button.setMouseInButton(false);
        this.button.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

}

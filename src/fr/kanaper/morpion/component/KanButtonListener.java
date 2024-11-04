package fr.kanaper.morpion.component;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class KanButtonListener implements MouseListener {

    private KanButton button;

    public KanButtonListener(KanButton button) {
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.button.setMouseClicked(true);
        this.button.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.button.setMouseClicked(false);
        this.button.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}

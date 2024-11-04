package fr.kanaper.morpion.component;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KanButtonGridListener implements ActionListener {

    private KanButtonGrid button;

    public KanButtonGridListener(KanButtonGrid button) {
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.button.getFilled()) {
            this.button.setFilled(true);
            if (this.button.getPlayer()) {
                this.button.setPlayer(false);
            } else {
                this.button.setPlayer(true);
            }
        }
    }
}

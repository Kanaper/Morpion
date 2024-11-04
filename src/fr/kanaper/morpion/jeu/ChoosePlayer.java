package fr.kanaper.morpion.jeu;

import javax.swing.JDialog;

public class ChoosePlayer extends JDialog {

    public ChoosePlayer() {
        this.setTitle("choisissez une couleur");
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setModal(true);
        this.setVisible(true);
    }

}

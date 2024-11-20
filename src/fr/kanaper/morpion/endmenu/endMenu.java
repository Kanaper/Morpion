package fr.kanaper.morpion.endmenu;

import javax.swing.JDialog;

import fr.kanaper.morpion.jeu.Game;
import fr.kanaper.morpion.jeu.Player;

public class endMenu extends JDialog {

    public endMenu(Game gameWindow, Player player) {
        super(gameWindow, "Fin de partie", true);

        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        this.setVisible(true);
    }

}

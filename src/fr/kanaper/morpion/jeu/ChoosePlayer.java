package fr.kanaper.morpion.jeu;

import javax.swing.JDialog;
import javax.swing.JLabel;

import fr.kanaper.morpion.component.KanButton;
import fr.kanaper.morpion.enums.PlayerType;

/**
 * Classe permettant de choisir le joueur
 * 
 * @version 1.0
 * @author Kanaper
 */
public class ChoosePlayer extends JDialog {

    public ChoosePlayer(Game gameWindow, Grid grid) {
        super(gameWindow, "Choix du joueur", true);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        JLabel title = new JLabel("Choisissez une forme");
        title.setBounds(0, 50, 400, 100);
        title.setFont(title.getFont().deriveFont(28f));
        title.setHorizontalAlignment(JLabel.CENTER);
        this.add(title);

        KanButton blue = new KanButton("Bleu", 85, 35);
        blue.setBounds(75, 200, 100, 50);
        blue.addActionListener(new ChoosePlayerButtonListener(this, PlayerType.CROSS, gameWindow, grid));
        this.add(blue);

        KanButton red = new KanButton("Rouge", 85, 35);
        red.setBounds(225, 200, 100, 50);
        red.addActionListener(new ChoosePlayerButtonListener(this, PlayerType.CIRCLE, gameWindow, grid));
        this.add(red);

        this.setVisible(true);
    }

}

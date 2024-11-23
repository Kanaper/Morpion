package fr.kanaper.morpion.jeu;

import javax.swing.JDialog;
import javax.swing.JLabel;

import fr.kanaper.morpion.component.KanButton;
import fr.kanaper.morpion.enums.KanButtonType;
import fr.kanaper.morpion.enums.PlayerType;

/**
 * Classe permettant de choisir le joueur
 * 
 * @version 1.0
 * @author Kanaper
 */
public class ChoosePlayer extends JDialog {

    public ChoosePlayer(Game gameWindow) {
        super(gameWindow, "Choix du joueur", true);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        JLabel title = new JLabel("Choisissez une forme");
        title.setBounds(0, 50, 400, 100);
        title.setFont(title.getFont().deriveFont(28f));
        title.setHorizontalAlignment(JLabel.CENTER);
        this.add(title);

        KanButton cross = new KanButton("Croix", KanButtonType.CROSS, gameWindow);
        cross.setWidth(80);
        cross.setHeight(30);
        cross.setBounds(75, 200, 80, 30);
        cross.addActionListener(new ChoosePlayerButtonListener(this, PlayerType.CROSS, gameWindow));
        this.add(cross);

        KanButton circle = new KanButton("Cercle", KanButtonType.CIRCLE, gameWindow);
        circle.setWidth(80);
        circle.setHeight(30);
        circle.setBounds(225, 200, 80, 30);
        circle.addActionListener(new ChoosePlayerButtonListener(this, PlayerType.CIRCLE, gameWindow));
        this.add(circle);

        this.setVisible(true);
    }

}

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

    private final int WIDTH = 400;
    private final int HEIGHT = 300;

    /**
     * Constructeur de la classe ChoosePlayer permettant de choisir le joueur
     * 
     * @param gameWindow fenêtre de jeu
     */
    public ChoosePlayer(Game gameWindow) {
        super(gameWindow, "Choix du joueur", true);
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        JLabel title = new JLabel("Choisissez une forme");
        title.setBounds(0, 25, 400, 75);
        title.setFont(title.getFont().deriveFont(28f));
        title.setHorizontalAlignment(JLabel.CENTER);
        this.add(title);

        KanButton cross = new KanButton("Croix", KanButtonType.CROSS, gameWindow);
        cross.setWidth(100);
        cross.setHeight(50);
        cross.setBounds(this.WIDTH / 2 - (cross.getWidth() + 50), 150, cross.getWidth(), cross.getHeight());
        cross.addActionListener(new ChoosePlayerButtonListener(this, PlayerType.CROSS, gameWindow));
        this.add(cross);

        KanButton circle = new KanButton("Cercle", KanButtonType.CIRCLE, gameWindow);
        circle.setWidth(100);
        circle.setHeight(50);
        circle.setBounds(this.WIDTH / 2 + 50, 150, circle.getWidth(), circle.getHeight());
        circle.addActionListener(new ChoosePlayerButtonListener(this, PlayerType.CIRCLE, gameWindow));
        this.add(circle);

        this.setVisible(true);
    }

}

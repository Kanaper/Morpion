package fr.kanaper.morpion.mainmenu;

import javax.swing.JFrame;

/**
 * Classe MainMenuWindow permettant de créer la fenêtre du menu principal
 * 
 * @version 1.0
 * @autor Kanaper
 */
public class MainMenuWindow extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;

    /**
     * Constructeur de la classe MainMenuWindow
     */
    public MainMenuWindow() {
        this.setTitle("Main Menu");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        MainMenuTitle title = new MainMenuTitle();
        this.add(title);

        MainMenuButtonPanel buttonPanel = new MainMenuButtonPanel(this);
        buttonPanel.setBounds(100, 300, WIDTH - 200, HEIGHT - 400);
        this.add(buttonPanel);
    }
}

package screen;

import javax.swing.*;

public class GamePanel {
    static JFrame frame;
    static Menu menu;
    static Inventory inventory;
    static Update update;
    static GameMap gamemap;

    public static void startgame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        menu = new Menu();
        frame.add(menu);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void inventory() {
        frame.remove(menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        inventory = new Inventory();
        frame.add(inventory);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void playgame() {
        frame.remove(inventory);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        gamemap = new GameMap();
        frame.add(gamemap);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void returntomenu() {
        frame.remove(inventory);
        frame.remove(gamemap);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        menu = new Menu();
        frame.add(menu);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

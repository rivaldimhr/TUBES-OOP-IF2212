package screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import screen.GameMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

import entity.Zombie.Zombie;
import javax.imageio.ImageIO;
import java.io.IOException;
import screen.Deck;

public class Inventory2 extends JPanel {
    public BufferedImage inventory;
    private Inventory inventor;
    private String[] imageFiles = {
            "image/peashooter.png",
            "image/kentang_gede.png",
            "image/mushroom.png",
            "image/squash.png",
            "image/lilipad.png",
            "image/double_peashooter.png",
            "image/tangle_kelp.png",
            "image/peashooter_ice.png",
            "image/kentang.png",
            "image/sunflower.png"
    };

    private int[] imagePositions = new int[10];

    public Inventory2() {
        this.setPreferredSize(new Dimension(GameMap.Width, GameMap.Height));
        this.setDoubleBuffered(true);
        this.setBackground(Color.white);
        loadBackgroundImage();

    }

    private void calculateImagePositions() {
        int index = 0;
        for (int y = 2; y <= 3; y++) {
            for (int x = 0; x < 5; x++) {
                imagePositions[index++] = x * 90 + y * 90 * 1000; // y * 1000 to separate x and y values
            }
        }
    }

    private void loadBackgroundImage() {
        try {
            this.inventory = ImageIO.read(new File("image/backgroundInventory.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawinventory(Graphics2D g) {
        if (inventory != null) {
            g.drawImage(inventory, 0, 0, GameMap.Width, GameMap.Height, this);
        } else {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, GameMap.Width, GameMap.Height);
        }
    }

    public void paintComponent(Graphics2D g) {
        drawinventory(g);
        for (int i = 0; i < Deck.deck.size(); i++) {
            if (Deck.deck.get(i) != null) {
                Deck.deck.get(i).drawdeck(g);
            }
        }

    }

    // public static void main(String[] args) {
    // JFrame window = new JFrame("inventory");
    // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // window.setResizable(false);
    // Inventory inventory = new Inventory();
    // window.add(inventory);
    // window.pack();// untuk mmengeluarkan panelnya
    // window.setLocationRelativeTo(null);
    // window.setVisible(true);

    // }
}
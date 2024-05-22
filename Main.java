package screen;

// import java.awt.image.TileObserver;

import javax.swing.JFrame;
import screen.GameMap;
import entity.Plant.Peashooter;
import entity.Plant.Plant;
import entity.Projecttail.Bullet;
import entity.Zombie.DolphinRider;
import entity.Zombie.Zombie;
import entity.Zombie.Zombiefootball;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame("Plant vs Zombie");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        Inventory inventory = new Inventory();
        window.add(inventory);
        window.pack();// untuk mmengeluarkan panelnya
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // Peashooter peashooter = new Peashooter(7 * GameMap.Tile_Size, 3 *
        // GameMap.Tile_Size);
        // Peashooter peashooter2 = new Peashooter(8 * GameMap.Tile_Size, 3 *
        // GameMap.Tile_Size);
        // Plant.plants.add(peashooter);
        // Plant.plants.add(peashooter2);
    }

}
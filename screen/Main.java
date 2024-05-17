package screen;

import java.awt.image.TileObserver;

import javax.swing.JFrame;
import screen.GameMap;
import entity.Plant.Peashooter;
import entity.Plant.Plant;
import entity.Projecttail.Bullet;
import entity.Zombie.Zombie;
import entity.Zombie.Zombiefootball;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame("Plant vs Zombie");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        GameMap gameMap = new GameMap();
        window.add(gameMap);
        window.pack();// untuk mmengeluarkan panelnya
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gameMap.startGameThread();
        Peashooter peashooter = new Peashooter(2 * GameMap.Tile_Size, 3 * GameMap.Tile_Size);
        Plant.plants.add(peashooter);
        // Zombiefootball zombiefootball = new Zombiefootball(9 * GameMap.Tile_Size, 3 *
        // GameMap.Tile_Size);
        // Zombie.zombies.add(zombiefootball);
    }

}
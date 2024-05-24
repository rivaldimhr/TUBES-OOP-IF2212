package entity.Plant;

import menu.GameLevel;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import entity.Projecttail.Bullet;
import entity.Zombie.Zombie;

public class Lilypad extends Plant {
    private int timer;

    public Lilypad(int x, int y) {
        super("Lilypad", 100, true, 0, 0, 25, 0, 10, x, y,
                "image\\lily_pad.gif");
    }

    public <png> void drawPlant(Graphics g) {
        try {
            png = new ImageIcon(getImage()).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(png, x, y + 15, GameLevel.Tile_Size, GameLevel.Tile_Size, null);
    }

    @Override
    public void actionPerformed() {

    }
}

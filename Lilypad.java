package entity.Plant;

import entity.Projecttail.Bullet;
import entity.Zombie.Zombie;

public class Lilypad extends Plant {
    private int timer;

    public Lilypad(int x, int y) {
        super("Lilypad", 100, true, 0, 0, 25, 0, 10, x, y,
                "image\\lily_pad.gif");
    }

    @Override
    public void actionPerformed() {

    }
}

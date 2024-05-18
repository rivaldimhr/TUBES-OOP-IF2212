package entity.Plant;

import entity.Projecttail.Bullet;
import entity.Zombie.Zombie;

public class Sunflower extends Plant {
    private int timer;
    public Sun sun = new Sun();

    public Sunflower(int x, int y) {
        super("Sunflower", 100, false, 0, 0, 50, 0, 10, x, y,
                "image\\sun_flower.gif");
    }

    @Override
    public void actionPerformed() {
        if (timer >= 180) {
            sun.addSun(25);
            timer = 0;
        } else {
            timer++;
        }
    }
}

package entity.Plant;

import entity.Projecttail.Bullet;
import entity.Zombie.Zombie;

public class Snowpea extends Plant {
    private int timer;

    public Snowpea(int x, int y) {
        super("Snowpea", 100, false, 25, 4, 175, -1, 10, x, y,
                "image\\snowpea.png");
    }

    public void attack() {
        spawnBullet();
    }

    private void spawnBullet() {
        Bullet bullet = new Bullet(x, y, attackDamage);
        Bullet.bullets.add(bullet);
    }

    @Override
    public void actionPerformed() {
        for (Zombie zombie : Zombie.zombies) {
            if (zombie.gety() == y) {
                if (timer >= 120) {
                    attack();
                    timer = 0;
                } else {
                    timer++;
                }

            }
        }
    }
}

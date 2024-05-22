package entity.Plant;

import entity.Projecttail.Bullet;
import entity.Zombie.Zombie;

public class Squash extends Plant {
    private int timer;

    public Squash(int x, int y) {
        super("Squash", 100, false, 5000, 0, 50, 1, 20, x, y,
                "image\\Squash.gif");
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
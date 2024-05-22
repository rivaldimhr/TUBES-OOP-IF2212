package entity.Plant;

import entity.Projecttail.Bullet;
import entity.Zombie.Zombie;

public class Wallnut extends Plant {
    private int timer;

    public Wallnut(int x, int y) {
        super("Wall-nut", 1000, false, 0, 0, 50, 0, 20, x, y,
                "image\\Wallnut1.png");
    }

    // public void attack() {
    // spawnBullet();
    // }

    // private void spawnBullet() {
    // Bullet bullet = new Bullet(x, y, attackDamage);
    // Bullet.bullets.add(bullet);
    // }

    @Override
    public void actionPerformed() {
        // for (Zombie zombie : Zombie.zombies) {
        // if (zombie.gety() == y) {
        // if (timer >= 120) {
        // attack();
        // timer = 0;
        // } else {
        // timer++;
        // }

        // }
        // }
        // }
    }
}
package entity.Plant;

import menu.GameLevel;
import entity.Projecttail.Bullet;
import entity.Projecttail.Puffbullet;
import entity.Zombie.Zombie;

public class Puffshroom extends Plant {
    private int timer;

    public Puffshroom(int x, int y) {
        super("Puffshroom", 70, false, 25, 4, 0, 3, 20, x, y,
                "image\\PuffShroom.png");
    }

    public void attack() {
        if (GameLevel.time % 200 >= 100) {
            spawnBullet();
            // ini keknya mmasih salah
        }
    }

    private void spawnBullet() {
        Bullet bullet = new Puffbullet(x, y, attackDamage);
        Bullet.bullets.add(bullet);
    }

    @Override
    public void actionPerformed() {
        Boolean shoutable = true;
        if (timer >= 60) {
            for (Zombie zombie : Zombie.zombies) {
                if (zombie.gety() == y && zombie.getX() <= x + 180) {
                    if (shoutable) {
                        attack();
                        shoutable = false;
                        timer = 0;
                    }

                }
            }
        } else {
            timer++;
        }
    }
}

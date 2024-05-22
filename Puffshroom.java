package entity.Plant;

import entity.Projecttail.Bullet;
import entity.Projecttail.Puffbullet;
import entity.Zombie.Zombie;
import screen.GameMap;

public class Puffshroom extends Plant {
    private int timer;
    private int i = 1;

    public Puffshroom(int x, int y) {
        super("Puffshroom", 70, false, 25, 4, 0, 3, 10, x, y,
                "image\\PuffShroom.png");
    }

    public void attack() {
        if (GameMap.time % 200 > 100) {
            spawnBullet();
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
                if (zombie.gety() == y) {
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

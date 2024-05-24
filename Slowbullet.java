package entity.Projecttail;

import entity.Projecttail.Bullet;

public class Slowbullet extends Bullet {

    public Slowbullet(int x, int y, int damage) {
        super(x, y, damage, true);
        img = "image\\ProjectileSnowPea.png";
    }

}

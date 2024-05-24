package entity.Plant;

import entity.Projecttail.Bullet;
import entity.Zombie.Zombie;

public class TangleKelp extends Plant {
    private int timer;
    private String move;
    private boolean first = true;
    private final int RANGE = 120; // Range within which Squash can kill zombies
    private boolean instantKill = false;

    public TangleKelp(int x, int y) {
        super("TangleKelp", 100, true, 5000, 0, 50, 1, 20, x, y,
                "image\\TangleKelp.gif");
    }

    @Override
    public void actionPerformed() {
        hitzombie();
    }

    public void instant_kill(Zombie zombie) {
        zombie.setHealth(0);
    }

    public void hitzombie() {
        for (Zombie zombie : Zombie.zombies) {
            if (Math.abs(x - zombie.getX()) <= RANGE && y == zombie.gety() && (move == "back" || first)) {
                zombie.takeDamage(zombie.getHealt()); // Instant kill
                instantKill = true;
                move = "back";
                first = false;
            } else if (Math.abs(zombie.getX() - x) <= RANGE && y == zombie.gety() && (move == "front" || first)) {
                zombie.takeDamage(zombie.getHealt()); // Instant kill
                instantKill = true;
                move = "front";
                first = false;
            }
        }
        if (instantKill) {
            this.setHealth(0);
            ; // Squash dies after killing zombies
        }
    }
}
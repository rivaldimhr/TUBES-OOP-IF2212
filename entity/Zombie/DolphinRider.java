package entity.Zombie;

public class DolphinRider extends Zombie {
    boolean instant_kill = false;

    public DolphinRider(int x, int y) {
        super("Dolphin Rider Zombie", 175, true, 100, 1, x, y,
                "image\\Dolphinride.gif");
        // isi folder fotonya"DolphinRider");
        // TODO Auto-generated constructor stub
    }

    @Override
    public void actionPerformed() {

        hitplant();
        if (moving) {
            if (timer >= 1) {
                move();
                timer = 0;
            } else {
                timer++;
            }
        } else {
            if (!instant_kill) {
                instant_kill(target);
                instant_kill = true;
            } else {
                if (timer >= 60) {
                    target.takedamage(attackDamage);
                    timer = 0;
                } else {
                    timer++;
                }
            }

        }

    }

}

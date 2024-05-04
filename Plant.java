public class Plant extends Entity {
    private int cost;
    private int cooldown;
    private int range;

    public Plant(String name, int health, boolean is_aquatic, int attackDamage, double attackSpeed, int cost,
            int cooldown, int range) {
        super(name, health, is_aquatic, attackDamage, attackSpeed);
        this.cost = cost;
        this.cooldown = cooldown;
        this.range = range;
    }

    public int getCost() {
        return this.cost;
    }

    public int getCooldown() {
        return this.cooldown;
    }

    public int getRange() {
        return this.range;
    }

    public void getImage() {

    }
}
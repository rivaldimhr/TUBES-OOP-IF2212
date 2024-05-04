public class Entity {
    String name;
    int health;
    boolean is_aquatic;
    int attackDamage;
    double attackSpeed;

    public Entity(String name, int health, boolean is_aquatic, int attackDamage, double attackSpeed) {
        this.name = name;
        this.health = health;
        this.is_aquatic = false;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
    }

    public boolean addis_aquatic() {
        boolean is_aquatic = false; // Menginisialisasi is_aquatic ke false
        for (int row = 0; row < 6; row++) {
            if (row == 2 || row == 3) { // Pool areas on rows 2 and 3
                is_aquatic = true;
            }
        }
        return is_aquatic; // Mengembalikan nilai is_aquatic setelah loop
    }

    // getter and setter-----------------------------------------------------------------------------------------------------------
    public String getName() {
        return this.name;
    }

    public int getHealt() {
        return this.health;
    }

    public int getattackDamage() {
        return this.attackDamage;
    }

    public double getattackSpeed() {
        return this.attackSpeed;
    }

    public void setHealth() {
        this.health = health;
    }

    public void setattackSpeed() {
        this.attackSpeed = attackSpeed;
    }
}

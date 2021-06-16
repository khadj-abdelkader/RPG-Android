package rpg;

public class Ability {

    private float damage;
    private final String name;
    private final int manaCost;
    private int coolDown;

    public Ability(String name, float damage, int manaCost) {
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
        this.coolDown = 0;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public float getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getCoolDown() {
        return coolDown;
    }

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }
}

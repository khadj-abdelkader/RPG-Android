package rpg;

import java.util.Random;

public abstract class RpgEntity {

    protected int hp = 0;
    protected int hpMax = 0;
    protected int mana = 0;
    protected int manaMax = 0;
    protected int level = 0;
    protected float scoreCriticalStrike = 0f;
    protected float criticalDamage  = 0f;
    protected float defense = 0f;
    protected float damageMin = 0f;
    protected float damageMax = 0f;
    protected Ability ability = null;

    public int getHp() {
        return hp;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getMana() {
        return mana;
    }

    public int getManaMax() {
        return manaMax;
    }

    public int getLevel() {
        return level;
    }

    public float getScoreCriticalStrike() {
        return scoreCriticalStrike;
    }

    public float getCriticalDamage() {
        return criticalDamage;
    }

    public float getDefense() {
        return defense;
    }

    public float getDamageMin() {
        return damageMin;
    }

    public float getDamageMax() {
        return damageMax;
    }

    private int getRandomBetweenNumber(float fLow, float fHigh) {
        Random r = new Random();
        int low = (int) Math.floor(fLow);
        int high = (int) Math.ceil(fHigh);
        return r.nextInt(high-low) + low;
    }

    public boolean isDead() {
        if (this.hp <= 0) {
            this.hp = 0;
            return true;
        }
        return false;
    }

    private float getDefenseCoefficient() {
        return ((100 - this.defense) / 100);
    }

    public Ability getAbility() {
        return ability;
    }

    protected void createAbility(String name, float damage, int manaCost) {
        this.ability = new Ability(name, damage, manaCost);
    }

    protected boolean attack(RpgEntity rpgEntityTarget) {
        if (this.isDead() || rpgEntityTarget.isDead()) {
            return false;
        }

        int damage = getRandomBetweenNumber(this.damageMin, this.damageMax);
        if (getRandomBetweenNumber(0f, 100f) <= this.scoreCriticalStrike) {
            damage *= this.criticalDamage;
        }

        damage *= rpgEntityTarget.getDefenseCoefficient();
        return false;
    }
}

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

    public boolean attack(RpgEntity rpgEntityTarget) {
        if (this.isDead() || rpgEntityTarget.isDead()) {
            return false;
        }

        if (this.ability != null) {
            boolean hasUsedAbility = useAbility(rpgEntityTarget);
            if (hasUsedAbility) {
                return true;
            }
        }

        int damage = getRandomBetweenNumber(this.damageMin, this.damageMax);
        if (getRandomBetweenNumber(0f, 100f) <= this.scoreCriticalStrike) {
            damage *= this.criticalDamage;
        }

        damage *= rpgEntityTarget.getDefenseCoefficient();

        rpgEntityTarget.hp -= damage;
        return true;
    }

    private boolean useAbility(RpgEntity rpgEntityTarget) {
        if (this.ability.getCoolDown() == 0 && this.ability.getManaCost() <= this.mana) {
            this.ability.setCoolDown(3);
            rpgEntityTarget.hp -= this.ability.getDamage();
            this.mana -= this.ability.getManaCost();
            return true;
        }
        if (this.ability.getCoolDown() > 0) {
            this.ability.setCoolDown(this.ability.getCoolDown()-1);
        }
        return false;
    }

    @Override
    public String toString() {
        return getClass() + " #" + this.level + " - " + this.hp + "/" + this.hpMax ;
    }
}

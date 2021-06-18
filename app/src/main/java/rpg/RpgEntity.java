package rpg;

import rpg.heros.Hero;

public abstract class RpgEntity {

    protected int uid;

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

    protected void reduceHp(int hp) {
        if (hp > this.hp) {
            this.hp = 0;
        } else {
            this.hp -= hp;
        }
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

    public int getUid() {
        return uid;
    }

    private int getRandomBetweenNumber(float fLow, float fHigh) {
        double low = Math.floor(fLow);
        double high = Math.ceil(fHigh);
        return (int)(low + (int)(Math.random() * ((high - low) + 1)));
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

    public String attack(RpgEntity rpgEntityTarget) {
        String info = "";
        if (this.isDead() || rpgEntityTarget.isDead()) {
            return "Victoire !";
        }

        if (this.ability != null) {
            boolean hasUsedAbility = useAbility(rpgEntityTarget);
            if (hasUsedAbility) {
                return "-" + (int) this.ability.getDamage() + " (ability)";
            }
        }

        int damage = getRandomBetweenNumber(this.damageMin, this.damageMax);
        if (getRandomBetweenNumber(0f, 100f) <= this.scoreCriticalStrike) {
            damage *= this.criticalDamage;
            info = "(CC) ";
        }

        damage *= rpgEntityTarget.getDefenseCoefficient();

        info += "-" + damage;
        rpgEntityTarget.reduceHp(damage);
        return info;
    }

    private boolean useAbility(RpgEntity rpgEntityTarget) {
        if (this.ability.getCoolDown() == 0 && this.ability.getManaCost() <= this.mana) {
            this.ability.setCoolDown(3);
            rpgEntityTarget.reduceHp((int) this.ability.getDamage());
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
        String display = this.getClass().getSimpleName() + " lvl" + this.level + " - " + this.hp + "/" + this.hpMax + " - " + this.mana + "/" + this.manaMax;
        if (this instanceof Hero) {
            Hero thisHero = ((Hero) this);
            display = thisHero.getName() + " - " + thisHero.getRace().getName() + " " + display;
        }
        return display;
    }
}

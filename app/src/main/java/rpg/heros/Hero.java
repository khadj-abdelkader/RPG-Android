package rpg.heros;

import java.io.Serializable;

import rpg.Race;
import rpg.RpgEntity;

public abstract class Hero extends RpgEntity implements Serializable {

    protected String name;
    protected Race race;
    protected int strength = 0;
    protected int agility = 0;
    protected int intelligence = 0;

    public Hero(String name, Race race, int strength, int agility, int intelligence) {
        this.name = name;
        this.race = race;
        this.scoreCriticalStrike = 11;
        this.criticalDamage = 1.5f;
        setStrength(strength);
        setAgility(agility);
        setIntelligence(intelligence);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength += strength;
        this.hp += strength * 19 + ((this.hpMax - this.hp) / 2);
        this.hpMax += strength * 19;
        if (this.hp > this.hpMax) {
            this.hp = this.hpMax;
        }
    }

    public void setAgility(int agility) {
        this.agility += agility;
        this.defense += (agility / 6f);
    }

    public void setIntelligence(int intelligence) {
        this.intelligence += intelligence;
        this.mana += intelligence * 17 + ((this.manaMax - this.mana) / 2);
        this.manaMax += intelligence * 17;
        if (this.mana > this.manaMax) {
            this.mana = this.manaMax;
        }
    }

    public void setAttributesFromMainCarac(int mainCarac) {
        this.level++;
        this.damageMin += mainCarac * 1.2f;
        this.damageMax += mainCarac * 1.4f;
        this.scoreCriticalStrike += mainCarac * 0.06f;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public abstract void levelUp();

    public abstract void updateAbility();

    public void setLevel(int level) {
        this.level = level - 1;
    }

    public void addLevel(int level) {
        for(int i = 0; i < level; i++) {
            levelUp();
        }
    }

    public void setCaracLevelUp(int strength, int agility, int intelligence, int mainCarac) {
        // Si la force n'est pas la main carac du personnage on monte sa force de 1 en plus
        if (strength != mainCarac && this.level%3 == 0) {
            strength++;
        }
        setStrength(strength);
        setAgility(agility);
        setIntelligence(intelligence);
        setAttributesFromMainCarac(mainCarac);
        updateAbility();
    }

}

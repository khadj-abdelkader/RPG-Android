package rpg.monsters;

public class Ogre extends Monsters {

    public Ogre(int level) {
        super(level, 2);
        this.hp = 70 + 83 * level;
        this.hpMax = this.hp;
        this.mana = 30 + 50 * level;
        this.manaMax = this.mana;
        this.defense = 2 + 0.48f * level;
        this.damageMin = 6.65f * level;
        this.damageMax = 6.70f * level;
        this.scoreCriticalStrike = 1 + 0.39f * level;
    }

}

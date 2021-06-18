package rpg.monsters;

public class Gobelin extends Monsters {

    public Gobelin(int level) {
        super(level, 1);
        this.hp = 38 + 50 * level;
        this.hpMax = this.hp;
        this.mana = 30 + 50 * level;
        this.manaMax = this.mana;
        this.defense = 0.33f * level;
        this.damageMin = 3.32f * level;
        this.damageMax = 3.38f * level;
        this.scoreCriticalStrike = 1 + 0.25f * level;
    }

}

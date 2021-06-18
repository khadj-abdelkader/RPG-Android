package rpg.monsters;

public class Dragon extends Monsters {

    public Dragon(int level) {
        super(level, 5);
        this.hp = 100 + 133 * level;
        this.hpMax = this.hp;
        this.mana = 50 + 70 * level;
        this.manaMax = this.mana;
        this.defense = 4 + 0.66f * level;
        this.damageMin = 8.89f * level;
        this.damageMax = 8.90f * level;
        this.scoreCriticalStrike = 1 + 0.5f * level;
        this.criticalDamage = 1.7f;
        createAbility("Fire Breathe", 48 + 10 * level, 160);
    }

}

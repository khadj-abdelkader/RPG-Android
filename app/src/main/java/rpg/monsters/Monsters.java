package rpg.monsters;

import rpg.RpgEntity;

public abstract class Monsters extends RpgEntity {

    protected int givenLevel;

    public Monsters(int level, int givenLevel) {
        this.level = level;
        this.criticalDamage = 1.5f;
        this.givenLevel = givenLevel;
    }

    public int getGivenLevel() {
        return givenLevel;
    }
}

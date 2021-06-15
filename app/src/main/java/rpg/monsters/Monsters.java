package rpg.monsters;

import rpg.RpgEntity;

public abstract class Monsters extends RpgEntity {

    public Monsters(int level) {
        this.level = level;
        this.criticalDamage = 1.5f;
    }

}

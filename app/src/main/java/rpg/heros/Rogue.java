package rpg.heros;

import rpg.Race;

public class Rogue extends Hero {

    private static final int MAIN_CARAC = 30;

    public Rogue(String name, Race race) {
        super(name, race, 12, MAIN_CARAC, 11);
        setAttributesFromMainCarac(MAIN_CARAC);
        this.criticalDamage = 1.75f;
        createAbility("Ambush", MAIN_CARAC * 2.1f, 160);
    }

    @Override
    public void levelUp() {
        setCaracLevelUp(2, 6, 1, 6);
    }

    @Override
    public void updateAbility() {
        this.ability.setDamage(2.1f * this.agility);
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        setCaracLevelUp(12 + 2 * level, MAIN_CARAC + 6 * level, 11 + level, MAIN_CARAC + 6 * level);
    }

}

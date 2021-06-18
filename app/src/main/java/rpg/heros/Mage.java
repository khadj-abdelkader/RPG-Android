package rpg.heros;

import rpg.Race;

public class Mage extends Hero {

    private static final int MAIN_CARAC = 36;

    public Mage(String name, Race race) {
        super(name, race, 13, 8, MAIN_CARAC);
        setAttributesFromMainCarac(MAIN_CARAC);
        createAbility("Fireball", MAIN_CARAC * 2f, 110);
    }

    @Override
    public void levelUp() {
        setCaracLevelUp(2, 1, 6, 6);
    }

    @Override
    public void updateAbility() {
        this.ability.setDamage(2 * this.intelligence);
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        setCaracLevelUp(13 + 2 * level, 8 + level, MAIN_CARAC + 6 * level, MAIN_CARAC + 6 * level);
    }

}

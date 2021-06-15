package rpg.heros;

import rpg.Race;

public class Warrior extends Hero {

    private static final int MAIN_CARAC = 26;

    public Warrior(String name, Race race) {
        super(name, race, MAIN_CARAC, 12, 14);
        setAttributesFromMainCarac(MAIN_CARAC);
        createAbility("Skullsplitter", MAIN_CARAC * 1.8f, 150);
    }

    @Override
    public void levelUp() {
        setCaracLevelUp(6, 2, 1, 6);
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        setCaracLevelUp(MAIN_CARAC + 6 * level, 12 + 2 * level, 14 + level, MAIN_CARAC + 6 * level);
    }

}

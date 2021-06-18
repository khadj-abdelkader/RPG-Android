package rpg.heros;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HeroStorage {

    @PrimaryKey
    private int uid;

    private static int globalUid = 1;

    private String name;

    @ColumnInfo(name = "type_hero")
    private String typeHero;
    private String race;
    private int level;

    public HeroStorage(String name, String typeHero, int level, String race) {
        this.name = name;
        this.typeHero = typeHero;
        this.level = level;
        this.race = race;
        this.uid = globalUid;
        globalUid++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeHero() {
        return typeHero;
    }

    public void setTypeHero(String typeHero) {
        this.typeHero = typeHero;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}

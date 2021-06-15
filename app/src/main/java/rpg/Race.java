package rpg;

public enum Race {

    ORC("Orc"),
    DWARF("Dwarf"),
    UNDEAD("Undead"),
    NIGHTELF("Night Elf");

    private final String name;

    Race(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package classes;

public enum Type {

    // Valeurs prises par l'enum
    FIRE("Fire"),
    FLYING("Flying");

    // Attribut de l'enum
    private final String name;

    // Constructeur de l'enum
    Type(String name) {
        this.name = name;
    }

    // Getter de l'enum
    public String getName() {
        return name;
    }
}

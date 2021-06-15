package classes;

public class Charizard extends Pokemon {

    // Dans un constructeur de classe fille, on utilise le mot clé "super" pour appeler le
    // constructeur parent
    public Charizard() {
        super("Charizard", 90.5, 1.7);
        getTypes().add(Type.FIRE);
        getTypes().add(Type.FLYING);
    }

    // Lors de la redéfinition d'une fonction abstraite de la classe mère, il faut bien utiliser
    // l'annotation @Override
    @Override
    public String attack() {
        return "I use flamethrower";
    }

}

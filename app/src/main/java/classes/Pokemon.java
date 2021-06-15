package classes;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon {

    protected String name;

    protected double weight;

    protected double height;

    protected List<Type> types;

    public Pokemon(String name, double weight, double height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.types = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public List<Type> getTypes() {
        return types;
    }

    public abstract String attack();

    @Override
    public String toString() {
        return this.name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Pokemon pokemon = (Pokemon) o;
//        return Objects.equals(name, pokemon.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
}

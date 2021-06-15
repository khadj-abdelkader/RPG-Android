package classes;

public class Counter {

    private double value;

    /**
     *
     * @param value a starting value to create the counter
     */
    public Counter(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void addValue(double value) {
        this.value += value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}

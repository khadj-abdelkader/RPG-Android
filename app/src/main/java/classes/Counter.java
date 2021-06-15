package classes;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Counter {

    private double value;

    private final Date createdAt;

    private Date updatedAt;

    public static final String COUNTER = "Compteur";

    /**
     *
     * @param value a starting value to create the counter
     */
    public Counter(double value) {
        this.value = value;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getUpdatedAtFormatted() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(this.updatedAt);
    }

    public void addValue(double value) {
        this.value += value;
        this.updatedAt = new Date();
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}

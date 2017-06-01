package domain;

public class Card {

    private int value;

    Card() {
    }

    Card(int value) {

        this.value = value;
    }

    void doubleValue() {
        this.value *= 2;
    }

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    void setEmpty() {
        value = 0;
    }

    boolean isEmpty() {
        return value == 0;
    }

    @Override
    public String toString() {
        return value == 0 ? " " : String.valueOf(value);
    }
}

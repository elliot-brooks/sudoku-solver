package structure;

public class Tile {

    private int value;
    private boolean empty;

    public Tile(int newVal) {
        value = newVal;
        if (value == 0) {
            empty = true;
        }
        else {
            empty = false;
        }
    }

    public int getVal() {
        return value;
    }

    public void setVal(int newVal) {
        value = newVal;
        if (value == 0) {
            empty = true;
        }
        else {
            empty = false;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public static Tile fromInt(int newVal) {
        return new Tile(newVal);
    }

    // a tile has an integer value which when it is 0 it should not be displayed and is considered an empty tiles

    
}

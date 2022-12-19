package structure;

public class Tile {

    protected static final int MIN_VALUE = 1;
    protected static final int MAX_VALUE = 9;

    public enum TileType {
        EMPTY,
        FILLED,
        UNCHANGEABLE;

        public static TileType fromString(String s) {
            if (s.equals("U")) return UNCHANGEABLE;
            if (s.equals("F")) return FILLED;
            else return EMPTY;
        }

    }

    private int value;
    private TileType tile_type;

    public Tile(int newVal) {
        this.value = newVal;
        // Tiles with values on instantiation should not be able to be changed
        tile_type = (this.value == 0) ? TileType.EMPTY : TileType.UNCHANGEABLE;
    }

    public int getVal() {
        return value;
    }

    public void setVal(int newVal, boolean bypass) {
        if (tile_type != TileType.UNCHANGEABLE || bypass) {
            this.value = newVal;
            this.tile_type = (this.value == 0) ? TileType.EMPTY : TileType.FILLED;
            return;
        }
        System.out.println("Cannot change unchangeable tile");
    }

    public boolean isEmpty() {
        if (tile_type == TileType.EMPTY) return true;
        else return false;
    }

    public static Tile fromInt(int newVal) {
        return new Tile(newVal);
    }    
}

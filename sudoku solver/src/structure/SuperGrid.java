package structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SuperGrid {
    private List<List<Tile>> tiles;

    public SuperGrid(List<List<Tile>> newTiles) {
        tiles = newTiles;
    } 
    
    public List<Integer> getRow(int index) {
        List<Tile> rowListTiles = tiles.get(index);
        List<Integer> rowList = new ArrayList<>();
        for (Tile tile : rowListTiles) {
            rowList.add(tile.getVal());
            
        }
        return rowList;
    }


    public static SuperGrid patternToGrid(Integer[][] pattern) {
        List<List<Tile>> tileArray = new ArrayList<>();
        List<Tile> row = new ArrayList<>();

        for (Integer[] ints : pattern) {
            row = new ArrayList<>();
            for (Integer integer : ints) {
                row.add(Tile.fromInt(integer));
            }
            tileArray.add(row);
        }

        return new SuperGrid(tileArray);
    }

    public List<Integer> getColumn(int index) {
        List<Integer> columnList = new ArrayList<Integer>();
        columnList.add(tiles.get(0).get(index).getVal());
        columnList.add(tiles.get(1).get(index).getVal());
        columnList.add(tiles.get(2).get(index).getVal());
        return columnList;
    }


    public Tile getTile(int x, int y) {
        return tiles.get(y).get(x);
    }

    public void setTile(int x, int y, int value){
        tiles.get(y).set(x, new Tile(value));
    }
/** NEEDS REAVALUATING FOR 9X9 has to check for grid duplicates
    public boolean check3x3Duplicates() {
        Set<Integer> checkSet = new HashSet<>();
        for (List<Tile> row : tiles) {
            for (Tile tile : row) {
                if (!tile.isEmpty()){
                    checkSet.add(tile.getVal());
                }
                
            }
            
        }
        System.out.println(checkSet.toString());
        if (checkSet.size() == 9) {
            return false;
        }
        else {
            return true;
        }

    }
    **/

    public String toString() {
        String stringBuilder = "-------------------------------------\n";
        for (int i = 0; i < 9; i++){
            stringBuilder += "| ";
            for (int j = 0; j < 9; j++){
                if (tiles.get(i).get(j).isEmpty()){
                    stringBuilder += " " + " | ";
                }
                else {
                    stringBuilder += tiles.get(i).get(j).getVal() + " | ";
                }
            }
            stringBuilder += ("\n-------------------------------------\n");
        }
        return stringBuilder;
    }

}

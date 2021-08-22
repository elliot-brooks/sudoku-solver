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

        
    public List<Integer> getRow(int index) {
        List<Tile> rowListTiles = tiles.get(index);
        List<Integer> rowList = new ArrayList<>();
        for (Tile tile : rowListTiles) {
            rowList.add(tile.getVal());
            
        }
        return rowList;
    }

    public List<Integer> getColumn(int index) {
        List<Integer> columnList = new ArrayList<Integer>();
        for (int i = 0; i < 9 ; i++) {
            columnList.add(tiles.get(i).get(index).getVal());

        }

        return columnList;
    }


    public Tile getTile(int x, int y) {
        return tiles.get(y).get(x);
    }

    public void setTile(int x, int y, int value){
        tiles.get(y).set(x, new Tile(value));
    }

    public boolean validSet(Set<Integer> uncheckedSet) {

        if (uncheckedSet.contains(1) && uncheckedSet.contains(2) && uncheckedSet.contains(3) && uncheckedSet.contains(4) && uncheckedSet.contains(5) && uncheckedSet.contains(6) && uncheckedSet.contains(7) && uncheckedSet.contains(8) && uncheckedSet.contains(9)) {
            if (uncheckedSet.size() == 9) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }

    }


    public boolean Check3x3Duplicates() {

        Set<Integer> gridSet;
        
        for (int GridStartY = 0; GridStartY < 9; GridStartY += 3) {
            for (int GridStartX = 0; GridStartX < 9; GridStartX += 3) {
                gridSet = new HashSet<>();
                // creates new set for each grid
                for (int y = 0; y < 3; y++) {
                    for (int x = 0; x < 3; x++) {

                        gridSet.add(tiles.get(GridStartY + y).get(GridStartX + x).getVal());
                        // adds all cells in the grid into a set to be checked for duplicates

                    }
                }
                System.out.print(gridSet);
                if (!validSet(gridSet)) {
                    return true;
                }
            
            }
        }
        return false;
        // no duplicates found
    }

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

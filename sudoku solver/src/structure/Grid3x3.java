package structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grid3x3 {
    
    private List<List<Tile>> tiles;
    
    public Grid3x3(List<List<Tile>> newTiles) {
        tiles = newTiles;
    } 

    public boolean generateGrid() {
        //SHOULD RETURN GRID
        return false;
        //Should generate a 2d list which acts as the grid then returns this as a new instance
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

    public boolean hasDuplicates() {
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


    public String toString() {
        String stringBuilder = "-------\n";
        for (int i = 0; i < 3; i++){
            stringBuilder += "|";
            for (int j = 0; j < 3; j++){
                if (tiles.get(i).get(j).isEmpty()){
                    stringBuilder += " " + "|";
                }
                else {
                    stringBuilder += tiles.get(i).get(j).getVal() + "|";
                }
            }
            stringBuilder += ("\n-------\n");
        }
        return stringBuilder;
    }
    //a grid (3x3) consists of 9 tiles and is combined with other grids created a 9x9 super grid containing 3 regular grids
    //
    
}

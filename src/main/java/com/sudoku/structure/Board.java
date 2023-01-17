package com.sudoku.structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Board {
    
    private List<List<Tile>> tiles;
    private List<List<Tile>> startingBoard;

    public Board(List<List<Tile>> newTiles) {
        tiles = newTiles;
        startingBoard = new ArrayList<>();

        for (List<Tile> row : tiles) {
            List<Tile> newRow = new ArrayList<>();
            for (Tile tile : row) {
                newRow.add(new Tile(tile.getVal()));
            }
            startingBoard.add(newRow);
        }

    }


    public List<List<Tile>> getTiles() {
        return tiles;
    }

    public void resetBoard() {
        tiles = startingBoard;
    }

    public void refreshStartingBoard() {
        startingBoard = new ArrayList<>();

        for (List<Tile> row : tiles) {
            List<Tile> newRow = new ArrayList<>();
            for (Tile tile : row) {
                newRow.add(new Tile(tile.getVal()));
            }
            startingBoard.add(newRow);
        }
    }

    /**
     * Takes a Integer array and turns it into a board
     * @param pattern
     * @return 
     */
    public static Board patternToGrid(Integer[][] pattern) {
        List<List<Tile>> tileArray = new ArrayList<>();
        List<Tile> row = new ArrayList<>();

        for (Integer[] ints : pattern) {
            row = new ArrayList<>();
            for (Integer integer : ints) {
                row.add(Tile.fromInt(integer));
            }
            tileArray.add(row);
        }

        return new Board(tileArray);
    }

    /**
     * Returns the board in Array format
     * @return
     */
    public Tile[][] getBoardArray() {
        Tile[][] array = new Tile[tiles.size()][];
        for (int i = 0; i < tiles.size(); i++) {
            List<Tile> row = tiles.get(i);
            array[i] = row.toArray(new Tile[row.size()]);
        }
        return array;
    }

    /**
     * Gets Row
     * @param index
     * @return
     */
    public List<Integer> getRow(int index) {
        List<Tile> rowListTiles = tiles.get(index);
        List<Integer> rowList = new ArrayList<>();
        for (Tile tile : rowListTiles) {
            rowList.add(tile.getVal());
            
        }
        return rowList;
    }

    /**
     * Gets Column
     * @param index
     * @return
     */
    public List<Integer> getColumn(int index) {
        List<Integer> columnList = new ArrayList<Integer>();
        for (int i = 0; i < 9 ; i++) {
            columnList.add(tiles.get(i).get(index).getVal());

        }

        return columnList;
    }


    /**
     * Gets tile
     * @param x
     * @param y
     * @return
     */
    public Tile getTile(int x, int y) {
        return tiles.get(y).get(x);
    }

    /**
     * Sets tile with bypass set to false (default)
     * @param x
     * @param y
     * @param value
     */
    public void setTile(int x, int y, int value){
        tiles.get(y).get(x).setVal(value, false);
    }

    /**
     * Sets tile with option to bypass tiles that cannot be changes
     * @param x
     * @param y
     * @param value
     * @param bypass
     */
    public void setTile(int x, int y, int value, boolean bypass) {
        tiles.get(y).get(x).setVal(value, bypass);
    }

    /**
     * Checks if a set is valid (contains 1-9) no duplicates
     * @param uncheckedSet
     * @return
     */
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

    /**
     * Checks if all rows are valid
     * @return
     */
    public boolean validRows(){
        Set<Integer> checkRow;
        for (int i = 0; i < 9; i++){
            checkRow = new HashSet<>();
            checkRow.addAll(this.getRow(i));
            if (!validSet(checkRow)) {
                return false;
            }
        }
        return true;

    }

    /**
     * Checks if all columns are valid
     * @return
     */
    public boolean validColumns() {
        Set<Integer> checkColumn;
        for (int i = 0; i < 9; i++){
            checkColumn = new HashSet<>();
            checkColumn.addAll(this.getColumn(i));
            if (!validSet(checkColumn)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if all 3x3 grids in the board are valid
     * @return
     */
    public boolean validSubGrids() {

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
                if (!validSet(gridSet)) {
                    return false;
                }
            
            }
        }
        return true;
        // no duplicates found
    }


    /**
     * Returns true if the sudoku is solved
     * @return
     */
    public boolean isSolved() {
        if (validColumns() && validRows() & validSubGrids()) {
            return true;
            
        }
        else {
            return false;

        }
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

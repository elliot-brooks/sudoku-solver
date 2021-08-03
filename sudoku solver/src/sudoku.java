import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import structure.Grid3x3;
import structure.SuperGrid;
import structure.Tile;

public class sudoku {
    public static void main(String[] args) {

        Integer[][] pattern = new Integer[][]{
            { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
            { 9, 1, 2, 3, 4, 5, 6, 7, 8 },
            { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
            { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
            { 6, 7, 8, 9, 1, 2, 3, 4, 5 },
            { 5, 6, 7, 8, 9, 1, 2, 3, 4 },
            { 4, 5, 6, 7, 8, 9, 1, 2, 3 },
            { 3, 4, 5, 6, 7, 8, 9, 1, 2 },
            { 2, 3, 4, 5, 6, 7, 8, 9, 1 }

        };



        // add these rows to create a test grid to check the toString function
        SuperGrid testGrid = SuperGrid.patternToGrid(pattern);


        System.out.println(testGrid.toString());
    }
    

}

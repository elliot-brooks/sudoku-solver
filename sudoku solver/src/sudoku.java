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


        Integer[][] solvedSudoku = new Integer[][]{
            { 1, 2, 3, 6, 7, 8, 9, 4, 5 },
            { 5, 8, 4, 2, 3, 9, 7, 6, 1 },
            { 9, 6, 7, 1, 4, 5, 3, 2, 8 },
            { 3, 7, 2, 4, 6, 1, 5, 8, 9 },
            { 6, 9, 1, 5, 8, 3, 2, 7, 4 },
            { 4, 5, 8, 7, 9, 2, 6, 1, 3 },
            { 8, 3, 6, 9, 2, 4, 1, 5, 7 },
            { 2, 1, 9, 8, 5, 7, 4, 3, 6 },
            { 7, 4, 5, 3, 1, 6, 8, 9, 2 }

        };



        // add these rows to create a test grid to check the toString function
        SuperGrid testGrid = SuperGrid.patternToGrid(solvedSudoku);


        System.out.println(testGrid.toString());
        System.out.println(testGrid.Check3x3Duplicates());
    }
    

}

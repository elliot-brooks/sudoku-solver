import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import structure.Board;
import structure.Tile;

public class Generator {

    private static final int BOARD_SIZE = 9;
    private static final int CLUES = 17;

    public static Board generateBoard() {
        Integer[][] boardArray = new Integer[BOARD_SIZE][BOARD_SIZE];
        Board board;
        
        do {
            int clues_added = 0;
            boardArray = new Integer[BOARD_SIZE][BOARD_SIZE];
            while (clues_added <= CLUES) {
                for (int row = 0; row < BOARD_SIZE; row++) {
                    for (int column = 0; column < BOARD_SIZE; column++) {
                        if (boardArray[row][column] == null) {
                            boardArray[row][column] = 0;
                        }
                        int placeClue = ThreadLocalRandom.current().nextInt(0, 2);
                        if (placeClue == 0 && boardArray[row][column] == 0) {
                            int numberToPlace = ThreadLocalRandom.current().nextInt(1, 10);
                            clues_added++;
                            boardArray[row][column] = numberToPlace;
                        }
                    }
                }
            }

            board = Board.patternToGrid(boardArray);
        } while (!Solver.solveBoard(board.getBoardArray()));

        
        // while not valid, shuffle and check.

        
    
        return board;

        // once we have a valid board, punch holes in it

    }


    private static void punchHoles() {

    }
}
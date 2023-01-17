package com.sudoku;

import com.sudoku.structure.Board;
public class Generator {

    private static final int HOLES_TO_PUNCH = 81 - 17;
    private static final int EMPTY_TILE = 0;

    public static Board generateBoard() {
        Board board = Board.patternToGrid(Consts.EMPTY_BOARD);                    
        Solver.solveBoard(board, true);
        punchHoles(board);
        lockFilledInTiles(board);
        board.refreshStartingBoard();
        return board;
    }

    private static void lockFilledInTiles(Board board) {
        for (int row = 0 ; row < Consts.BOARD_SIZE; row++) {
            for (int column = 0; column < Consts.BOARD_SIZE; column++) {
                if (board.getTile(row, column).getVal() != 0) {
                    board.getTile(row, column).setInStone();
                }
            }
        }
    }

    private static void punchHoles(Board board) {
        int count = 0;
        while (count < HOLES_TO_PUNCH) {
            for (int row = 0 ; row < Consts.BOARD_SIZE; row++) {
                for (int column = 0; column < Consts.BOARD_SIZE; column++) {
                    if (!board.getTile(row, column).isEmpty()) {
                        if (Math.random() < 0.5) {
                            board.setTile(row, column, EMPTY_TILE);
                            count++;
                            if (count == HOLES_TO_PUNCH) return;
                        }
                    }
                }
            }
        }


    }
}
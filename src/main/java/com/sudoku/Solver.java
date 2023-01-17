package com.sudoku;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import com.sudoku.structure.Board;

public class Solver {

  public static boolean isNumberInRow(Board board, int number, int row) {
    for (int i = 0; i < Consts.BOARD_SIZE; i++) {
      if (board.getTile(row, i).getVal() == number) {
        return true;
      }
    }
    return false;
  }

  public static boolean isNumberInColumn(Board board, int number, int column) {
    for (int i = 0; i < Consts.BOARD_SIZE; i++) {
      if (board.getTile(i, column).getVal() == number) {
        return true;
      }
    }
    return false;
  }

  public static boolean isNumberInBox(Board board, int number, int row, int column) {
    int localBoxRow = row - row % 3;
    int localBoxColumn = column - column % 3;

    for (int i = localBoxRow; i < localBoxRow + 3; i++) {
      for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
        if (board.getTile(i, j).getVal() == number) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isValidPlacement(Board board, int number, int row, int column) {
    return !isNumberInRow(board, number, row) &&
        !isNumberInColumn(board, number, column) &&
        !isNumberInBox(board, number, row, column);
  }

  private static void shuffleArray(int[] ar) {
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--) {
      int index = rnd.nextInt(i + 1);
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }

  public static boolean solveBoard(Board board, boolean shuffle) {
    board.resetBoard();
    int[] trial_array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    for (int row = 0; row < Consts.BOARD_SIZE; row++) {
      for (int column = 0; column < Consts.BOARD_SIZE; column++) {
        if (board.getTile(row, column).getVal() == 0) {
          if (shuffle) {
            shuffleArray(trial_array);
          }
          for (int trialNum : trial_array) {
            if (isValidPlacement(board, trialNum, row, column)) {
              board.getTile(row, column).setVal(trialNum, true);

              if (solveBoard(board, shuffle)) {
                return true;
              } else {
                //System.out.println(board.toString());
                board.getTile(row, column).setVal(0, true);
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }
}

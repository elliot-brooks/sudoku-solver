import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import structure.Tile;

public class Solver {

  private static final int GRID_SIZE = 9;
  public static boolean isNumberInRow(Tile[][] board, int number, int row) {
    for (int i = 0; i < GRID_SIZE; i++) {
      if (board[row][i].getVal() == number) {
        return true;
      }
    }
    return false;
  }

  public static boolean isNumberInColumn(Tile[][] board, int number, int column) {
    for (int i = 0; i < GRID_SIZE; i++) {
      if (board[i][column].getVal() == number) {
        return true;
      }
    }
    return false;
  }

  public static boolean isNumberInBox(Tile[][] board, int number, int row, int column) {
    int localBoxRow = row - row % 3;
    int localBoxColumn = column - column % 3;

    for (int i = localBoxRow; i < localBoxRow + 3; i++) {
      for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
        if (board[i][j].getVal() == number) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isValidPlacement(Tile[][] board, int number, int row, int column) {
    return !isNumberInRow(board, number, row) &&
        !isNumberInColumn(board, number, column) &&
        !isNumberInBox(board, number, row, column);
  }

  private static void shuffleArray(int[] ar)
  {
    // If running on Java 6 or older, use `new Random()` on RHS here
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }

  public static boolean solveBoard(Tile[][] board) {
    int[] trial_array = {1,2,3,4,5,6,7,8,9};
    for (int row = 0; row < GRID_SIZE; row++) {
      for (int column = 0; column < GRID_SIZE; column++) {
        if (board[row][column].getVal() == 0) {
          shuffleArray(trial_array);
          for (int trialNum : trial_array) {
            if (isValidPlacement(board, trialNum, row, column)) {
              board[row][column].setVal(trialNum, true);

              if (solveBoard(board)) {
                return true;
              } else {
                board[row][column].setVal(0, true);
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

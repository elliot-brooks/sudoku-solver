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

  public static boolean solveBoard(Tile[][] board) {
    for (int row = 0; row < GRID_SIZE; row++) {
      for (int column = 0; column < GRID_SIZE; column++) {
        if (board[row][column].getVal() == 0) {
          for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
            if (isValidPlacement(board, numberToTry, row, column)) {
              board[row][column].setVal(numberToTry, true);

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

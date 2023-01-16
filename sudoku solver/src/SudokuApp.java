import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import structure.Board;
import visualisation.BoardVisualizer;

public class SudokuApp extends Application {

    VBox root = new VBox(4);
    BoardVisualizer bv = new BoardVisualizer();
    Board board;
    private Integer selectedRow, selectedColumn;

    public static void main(String[] args) {
        launch(args);
    }

    public void clickGrid(javafx.scene.input.MouseEvent event) {
        Node clickedNode = event.getPickResult().getIntersectedNode();
        Node stack_pane = clickedNode.getParent();
        selectedColumn = GridPane.getColumnIndex(stack_pane);
        selectedRow = GridPane.getRowIndex(stack_pane);

        resetGrid(board);

    }

    public void resetGrid(Board board) {
        root.getChildren().remove(bv.getBoardGraphic());
        GridPane gp = bv.createBoardGraphic(board, selectedColumn, selectedRow);
        gp.setOnMouseClicked(ActionEvent -> {
            clickGrid(ActionEvent);
        });
        bv.setBoardGraphic(gp);
        root.getChildren().add(bv.getBoardGraphic());
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sudoku!");

        board = Generator.generateBoard();

        GridPane boardGraphic = bv.createBoardGraphic(board, selectedRow, selectedRow);
        boardGraphic.setOnMouseClicked(ActionEvent -> {
            clickGrid(ActionEvent);
        });

        boardGraphic.setAlignment(Pos.CENTER);
        Button generate_button = new Button();
        generate_button.setText("Generate Puzzle");
        generate_button.setAlignment(Pos.CENTER);

        Button check_button = new Button();
        check_button.setText("Check Solution");
        check_button.setAlignment(Pos.CENTER);

        Button solve_button = new Button();
        solve_button.setText("Solve Puzzle");
        solve_button.setAlignment(Pos.CENTER);

        generate_button.setOnAction(ActionEvent -> {
            board = Generator.generateBoard();
            resetGrid(board);

        });

        
        check_button.setOnAction(ActionEvent -> {
            boolean solved = board.isSolved();
            if (solved) {
                System.out.println("You solved the puzzle!");
            }
            else {
                System.out.println("The puzzle is incorrect!");
            }
            resetGrid(board);


        });

        solve_button.setOnAction(ActionEvent -> {
            Solver.solveBoard(board, false);
            resetGrid(board);
        });

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(generate_button, check_button, solve_button, boardGraphic);
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (selectedColumn == null && selectedRow == null) {
                return;
            }
            if (key.getCode() == KeyCode.DIGIT1) {
                board.setTile(selectedRow, selectedColumn, 1);
            }
            if (key.getCode() == KeyCode.DIGIT2) {
                board.setTile(selectedRow, selectedColumn, 2);
            }
            if (key.getCode() == KeyCode.DIGIT3) {
                board.setTile(selectedRow, selectedColumn, 3);
            }
            if (key.getCode() == KeyCode.DIGIT4) {
                board.setTile(selectedRow, selectedColumn, 4);
            }
            if (key.getCode() == KeyCode.DIGIT5) {
                board.setTile(selectedRow, selectedColumn, 5);
            }
            if (key.getCode() == KeyCode.DIGIT6) {
                board.setTile(selectedRow, selectedColumn, 6);
            }
            if (key.getCode() == KeyCode.DIGIT7) {
                board.setTile(selectedRow, selectedColumn, 7);
            }
            if (key.getCode() == KeyCode.DIGIT8) {
                board.setTile(selectedRow, selectedColumn, 8);
            }
            if (key.getCode() == KeyCode.DIGIT9) {
                board.setTile(selectedRow, selectedColumn, 9);
            }
            if (key.getCode() == KeyCode.DIGIT0) {
                board.setTile(selectedRow, selectedColumn, 0);
            }
            resetGrid(board);

        });
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}

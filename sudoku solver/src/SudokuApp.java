import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
            root.getChildren().remove(bv.getBoardGraphic());
            bv.setBoardGraphic(bv.createBoardGraphic(board, selectedRow, selectedColumn));
            root.getChildren().add(bv.getBoardGraphic());
            stage.sizeToScene();

        });

        solve_button.setOnAction(ActionEvent -> {
            Solver.solveBoard(board.getBoardArray());
            root.getChildren().remove(bv.getBoardGraphic());
            bv.setBoardGraphic(bv.createBoardGraphic(board, selectedRow, selectedColumn));
            root.getChildren().add(bv.getBoardGraphic());
            stage.sizeToScene();

        });

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(generate_button, check_button, solve_button, boardGraphic);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}


import java.beans.EventHandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import structure.Board;
import visualisation.BoardVisualizer;

public class SudokuApp extends Application {

    VBox root = new VBox(4);
    BoardVisualizer bv = new BoardVisualizer();
    Board board;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sudoku!");

        board = Generator.generateBoard();

        GridPane boardGraphic = bv.createBoardGraphic(board);
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
            // gets file chosen from file chooser

            // gets path from file
            board = Generator.generateBoard();
            // removes maze board from scene
            root.getChildren().remove(bv.getBoardGraphic());
            // makes new maze board with new maze
            bv.setBoardGraphic(bv.createBoardGraphic(board));

            // adds new maze board back to scene
            root.getChildren().add(bv.getBoardGraphic());
            // update size of screen
            stage.sizeToScene();

        });


        solve_button.setOnAction(ActionEvent -> {
            Solver.solveBoard(board.getBoardArray());


            root.getChildren().remove(bv.getBoardGraphic());
            // makes new maze board with new maze
            bv.setBoardGraphic(bv.createBoardGraphic(board));

            // adds new maze board back to scene
            root.getChildren().add(bv.getBoardGraphic());
            // update size of screen
            stage.sizeToScene();

        });

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(generate_button, check_button, solve_button, boardGraphic);
        stage.setScene(new Scene(root));
        stage.sizeToScene();
        stage.show();
    }
}

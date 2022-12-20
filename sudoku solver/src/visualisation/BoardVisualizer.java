
package visualisation;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import structure.Board;



public class BoardVisualizer {

    private GridPane board;


    public GridPane getBoardGraphic() {
        return board;
    }


    public void setBoardGraphic(GridPane boardIn) {
        board = boardIn;
    }


    public GridPane createBoardGraphic(Board boardObj) {
        this.board = new GridPane();

        for (int i = 0; i < boardObj.getTiles().size(); i++) {
            for (int j = 0; j < boardObj.getTiles().get(i).size(); j++) {
                Text text = new Text(boardObj.getTile(i, j).toString());

                Rectangle tile = new Rectangle(50, 50);
                tile.setStroke(Color.BLACK);
                tile.setFill(Color.WHITE);
                StackPane sp = new StackPane();
                sp.getChildren().addAll(tile,text);


                board.add(sp,j, i);
            }
        }
        return board;

    }
}

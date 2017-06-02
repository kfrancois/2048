package gui;

import domain.Board;
import domain.Move;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;

import java.io.IOException;

public class GameScreen extends TilePane {

    private final Board board;

    public GameScreen(Board board) {
        this.board = board;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();

            updateCardViews();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCardViews() {
        CardView[] cards = new CardView[16];
        int i = 0;
        for (int[] row : board.getBoard()) {
            for (int elem : row) {
                cards[i++] = new CardView(elem);
            }
        }
        this.getChildren().clear();
        this.getChildren().addAll(cards);
    }

    public void move(KeyEvent event) {
        Move move;
        switch (event.getCode()) {
            case UP:
                move = Move.Up;
                break;
            case RIGHT:
                move = Move.Right;
                break;
            case DOWN:
                move = Move.Down;
                break;
            case LEFT:
                move = Move.Left;
                break;
            default:
                return;
        }
        try {
            board.move(move);
        } catch (IllegalArgumentException ignored) {
        }
        updateCardViews();
    }
}

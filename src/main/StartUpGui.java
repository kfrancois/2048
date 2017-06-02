package main;

import domain.Board;
import gui.GameScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUpGui extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        int[][] cards = new int[][]{
                new int[]{2, 4, 2, 4},
                new int[]{0, 2, 4, 2},
                new int[]{0, 0, 2, 4},
                new int[]{0, 0, 0, 2}
        };

        Board board = new Board(cards);

        GameScreen gameScreen = new GameScreen(board);
        Scene scene = new Scene(gameScreen);

        scene.setOnKeyPressed(gameScreen::move);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}

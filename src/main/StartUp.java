package main;

import cui.ConsoleGame;
import domain.Board;

public class StartUp {
    public static void main(String[] args) {
        int[][] cards = new int[][]{
                new int[]{2, 4, 2, 4},
                new int[]{0, 2, 4, 2},
                new int[]{0, 0, 2, 4},
                new int[]{0, 0, 0, 2}
        };

        Board board = new Board(cards);

        new ConsoleGame().run(board);
    }
}

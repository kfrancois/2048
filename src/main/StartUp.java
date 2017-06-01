package main;

import domain.Board;
import domain.Card;
import domain.Move;
import domain.Mover;

import java.util.Arrays;

public class StartUp {
    public static void main(String[] args) {
        int[][] cards = new int[][]{
                new int[]{2, 2, 4, 0},
                new int[]{0, 2, 2, 2},
                new int[]{0, 4, 4, 2},
                new int[]{2, 0, 2, 2}
        };

        Board board = new Board(cards);

        System.out.println(board);
        board.move(Move.Right);
        System.out.println(board);
        board.undo();
        System.out.println(board);
    }
}

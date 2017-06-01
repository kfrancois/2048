package cui;

import domain.Board;
import domain.Move;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleGame {

    private Board board;
    private Scanner input;

    public void run() {
        run(new Board(4));
    }

    public void run(Board board) {
        this.board = board;
        input = new Scanner(System.in);

        System.out.print("The board is as follows:");
        System.out.println(board);
        while (!board.isGameOver()) {
            System.out.printf("Possible moves: %s%n", String.join(",", Arrays.stream(board.getPossibleMoves()).map(Enum::toString).collect(Collectors.toList())));

            System.out.print("Enter your next move: ");
            board.move(Move.getMove(input.next()));

            System.out.println(board);
        }
    }
}

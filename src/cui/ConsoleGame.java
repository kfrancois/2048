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

        while (!board.isGameOver()) {
            singleMove();
        }
    }

    private void singleMove() {
        System.out.println(board);
        System.out.printf("Possible moves: %s%n", String.join(",", Arrays.stream(board.getPossibleMoves()).map(Enum::toString).collect(Collectors.toList())));

        boolean isValidChoice = false;
        String choice;

        do {
            try {
                System.out.print("Enter your next move: ");
                choice = input.next();
                board.move(Move.getMove(choice));
                isValidChoice = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid move.");
            }
        } while (!isValidChoice);

    }
}

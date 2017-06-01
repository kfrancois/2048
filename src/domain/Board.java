package domain;

import java.util.Arrays;
import java.util.stream.Collectors;

import static util.ArrayMapper.mapToCardArray;
import static util.ArrayMapper.mapToIntArray;

public class Board {

    static int size;

    private boolean canUndo;
    private int[][] lastCards;
    private Card[][] cards;
    private Mover mover = new Mover();

    public Board(int size) {
        Board.size = size;
        cards = new Card[size][size];
        lastCards = new int[size][size];
        Arrays.stream(cards).forEach(cardArray -> Arrays.fill(cardArray, new Card()));
    }

    public Board(int[][] cards) {
        this(mapToCardArray(cards));
    }

    public Board(Card[][] cards) {
        size = cards.length;
        lastCards = new int[size][size];
        this.cards = cards;
    }

    public void move(Move move) {
        lastCards = mapToIntArray(cards);
        cards = mover.move(move, cards);
        canUndo = true;
    }

    public void undo() {
        if (canUndo) {
            cards = mapToCardArray(lastCards);
            canUndo = false;
        } else {
            throw new IllegalStateException("Can't undo twice in a row");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Card[] row : cards) {
            builder.append("\n--- --- --- ---\n|");
            builder.append(String.join("| |", Arrays.stream(row).map(Card::toString).collect(Collectors.toList()))).append("|");
        }
        builder.append("\n--- --- --- ---\n");
        return builder.toString();
    }

    private boolean moveChangesBoard(Move move) {
        return mover.moveChangesBoard(move, cards);
    }

    public Move[] getPossibleMoves() {
        return Arrays.stream(Move.values()).filter(this::moveChangesBoard).toArray(Move[]::new);
    }

    public boolean isGameOver() {
        for (Move move : Move.values()) {
            if (moveChangesBoard(move)) return false;
        }
        return true;
    }
}

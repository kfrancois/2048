package domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Board {

    private Mover mover = new Mover();

    private boolean canUndo;
    private Card[][] lastCards = new Card[4][4];
    private Card[][] cards;

    public Board() {
        this.cards = new Card[4][4];
        Arrays.stream(cards).forEach(cardArray -> Arrays.fill(cardArray, new Card()));
    }

    public Board(Card[][] cards) {
        this.cards = cards;
    }

    public Board(int[][] cards) {
        this.cards = new Card[4][4];
        int i = 0;
        for (int[] row : cards) {
            int j = 0;
            for (int el : row) {
                this.cards[i][j] = new Card(el);
                j++;
            }
            i++;
        }
    }


    public void move(Move move) {
        for (int i = 0; i < 4; i++) {
            System.arraycopy(cards[i], 0, lastCards[i], 0, 4);
        }
        cards = mover.move(move, cards);
        canUndo = true;
    }

    public void undo() {
        if (canUndo) {
            for (int i = 0; i < 4; i++) {
                System.arraycopy(lastCards[i], 0, cards[i], 0, 4);
            }
            canUndo = false;
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
}

package domain;

import util.ArrayHelper;

import java.util.Arrays;
import java.util.Random;

import static util.ArrayHelper.mapToIntArray;

/**
 * This class is responsible for the movement algorithm in the game.
 */
class Mover {

    private Random random;

    private Card[][] cards;

    Mover() {
        this.random = new Random();
    }

    /**
     * @param move  the move to be executed
     * @param cards the 2d card-array that has to be moved
     * @return the 2d-array upon which the move has been executed
     */
    Card[][] move(Move move, Card[][] cards) {
        this.cards = cards;
        switch (move) {
            case Up:
                up();
                break;
            case Right:
                right();
                break;
            case Down:
                down();
                break;
            case Left:
                left();
                break;
        }
        spawnCard();
        return cards;
    }

    /**
     * Chooses a random card with value '0' and changes it to 2 or 4
     */
    private void spawnCard() {
        int i, j;
        do {
            i = random.nextInt(Board.size);
            j = random.nextInt(Board.size);
        } while (!cards[i][j].isEmpty());

        cards[i][j].setValue(random.nextInt(10) > 2 ? 2 : 4);
    }

    /**
     * Moves the cards up according to 2048-rules
     */
    private void up() {
        rotateCCW();
        left();
        rotateCW();
    }

    /**
     * Moves the cards right according to 2048-rules
     */
    private void right() {
        rotateCW();
        rotateCW();
        left();
        rotateCW();
        rotateCW();
    }

    /**
     * Moves the cards down according to 2048-rules
     */
    private void down() {
        rotateCW();
        left();
        rotateCCW();
    }

    /**
     * Moves the cards left according to 2048-rules
     */
    private void left() {
        for (Card[] row : cards) {
            boolean[] hasMoved = new boolean[Board.size];
            for (int i = 1; i < row.length; i++) {
                int k = i;
                for (int j = k - 1; j >= 0; j--) {
                    if (row[j].isEmpty()) {
                        row[j].setValue(row[k].getValue());
                        row[k].setEmpty();
                        k--;
                    } else if (row[j].getValue() == row[k].getValue() && !hasMoved[j]) {
                        row[j].doubleValue();
                        row[k].setEmpty();
                        hasMoved[j] = true;
                    } else break;
                }
            }
        }
    }

    /**
     * Rotates the array clockwise
     */
    private void rotateCW() {
        int size = Board.size;
        Card[][] tmp = new Card[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                tmp[c][size - 1 - r] = cards[r][c];
            }
        }
        System.arraycopy(tmp, 0, cards, 0, size);
    }

    /**
     * Rotates the array counter-clockwise
     */
    private void rotateCCW() {
        int size = Board.size;
        Card[][] tmp = new Card[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                tmp[i][j] = cards[j][size - i - 1];
            }
        }
        System.arraycopy(tmp, 0, cards, 0, size);
    }

    /**
     * Determines if the given move changes the cards
     *
     * @param move  This is the direction that is tested
     * @param cards This is the 2d card-array that will be moved
     * @return Returns whether the given move actually moved any of the cards
     */
    boolean moveChangesBoard(Move move, Card[][] cards) {

        int[][] array = mapToIntArray(cards);

        for (int a = move.ordinal(); a < 3; a++) {
            array = ArrayHelper.rotateCW(array);
        }
        return Arrays.stream(array).anyMatch(this::moveChangesRow);
    }

    /**
     * Determines if the row changes when slide to left is applied
     *
     * @param row This is the given row
     * @return Returns whether the row will change
     */
    private boolean moveChangesRow(int[] row) {
        for (int i = 1; i < row.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (row[i] == 0 || row[j] != 0 && row[j] != row[i]) break;
                if (row[j] == 0 || row[j] == row[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
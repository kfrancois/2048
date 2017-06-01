package domain;

import java.util.Random;

public class Mover {
    private Random random;

    private Card[][] cards;

    Mover() {
        this.random = new Random();
    }

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
        spawnCard(cards);
        return cards;
    }

    private void spawnCard(Card[][] cards) {
        int i, j;
        do {
            i = random.nextInt(Vars.size);
            j = random.nextInt(Vars.size);
        } while (!cards[i][j].isEmpty());

        cards[i][j].setValue(random.nextInt(10) > 2 ? 2 : 4);
    }

    private void up() {
        rotateCCW();
        left();
        rotateCW();
    }

    private void right() {
        rotateCW();
        rotateCW();
        left();
        rotateCW();
        rotateCW();
    }

    private void down() {
        rotateCW();
        left();
        rotateCCW();
    }

    private void left() {
        for (Card[] row : cards) {
            boolean[] hasMoved = new boolean[Vars.size];
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

    private void rotateCW() {
        int size = Vars.size;
        Card[][] tmp = new Card[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                tmp[c][size - 1 - r] = cards[r][c];
            }
        }
        System.arraycopy(tmp, 0, cards, 0, size);
    }

    private void rotateCCW() {
        int size = Vars.size;
        Card[][] tmp = new Card[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                tmp[i][j] = cards[j][size - i - 1];
            }
        }
        System.arraycopy(tmp, 0, cards, 0, size);
    }
}
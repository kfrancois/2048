package util;

import domain.Card;

import java.util.stream.IntStream;

public class ArrayHelper {
    public static Card[][] mapToCardArray(int[][] array) {
        int size = array.length;
        Card[][] cards = new Card[size][size];
        IntStream.range(0, size).forEach(i -> IntStream.range(0, size).forEach(j -> cards[i][j] = new Card(array[i][j])));
        return cards;
    }

    public static int[][] mapToIntArray(Card[][] cards) {
        int size = cards.length;
        int[][] array = new int[size][size];
        IntStream.range(0, size).forEach(i -> IntStream.range(0, size).forEach(j -> array[i][j] = cards[i][j].getValue()));
        return array;
    }

    public static int[][] rotateCW(int[][] array) {
        int size = array.length;
        int[][] tmp = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                tmp[col][size - 1 - row] = array[row][col];
            }
        }
        return tmp;
    }
}

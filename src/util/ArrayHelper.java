package util;

import domain.Card;

import java.util.stream.IntStream;

/**
 * Helper class used for array operations
 */
public class ArrayHelper {
    /**
     * Maps given 2d integer array to 2d card array
     *
     * @param array 2d integer array
     * @return 2d card array
     */
    public static Card[][] mapToCardArray(int[][] array) {
        int size = array.length;
        Card[][] cards = new Card[size][size];
        IntStream.range(0, size).forEach(i -> IntStream.range(0, size).forEach(j -> cards[i][j] = new Card(array[i][j])));
        return cards;
    }

    /**
     * Maps given 2d card array to 2d integer array
     *
     * @param cards 2d card array
     * @return 2d int array
     */
    public static int[][] mapToIntArray(Card[][] cards) {
        int size = cards.length;
        int[][] array = new int[size][size];
        IntStream.range(0, size).forEach(i -> IntStream.range(0, size).forEach(j -> array[i][j] = cards[i][j].getValue()));
        return array;
    }

    /**
     * Rotates given 2d int array clockwise
     *
     * @param array 2d int array
     * @return 2d int array - rotated by 90 degrees clockwise
     */
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

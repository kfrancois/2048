package util;

import domain.Card;

import java.util.stream.IntStream;

public class ArrayMapper {
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
}

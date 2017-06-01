package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoverTest {
    @Test
    public void gameOverTest() {
        Board board = new Board(new int[][]{
                new int[]{2, 4, 2, 4},
                new int[]{4, 2, 4, 2},
                new int[]{2, 4, 2, 4},
                new int[]{4, 2, 4, 2}
        });
        assertTrue(board.isGameOver());
    }
}

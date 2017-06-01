package domain;

public enum Move {
    Up, Right, Down, Left;

    public static Move getMove(String string) {
        switch (string.toLowerCase()) {
            case "up":
                return Up;
            case "right":
                return Right;
            case "down":
                return Down;
            case "left":
                return Left;
        }
        return null;
    }
}

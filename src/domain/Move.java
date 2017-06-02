package domain;

/**
 * This enum lists the moves possible in 2048
 */
public enum Move {
    Up, Right, Down, Left;

    /**
     * Given a String, returns the corresponding Move enumvalue
     *
     * @param string A String
     * @return If string can be mapped to a Move, returns the Move. Otherwise returns null
     */
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

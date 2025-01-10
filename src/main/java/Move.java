public enum Move {
    ROCK, PAPER, SCISSORS;

    public boolean beats(Move other) {
        if (this == ROCK) {
            return other == SCISSORS;
        }
        if (this == PAPER) {
            return other == ROCK;
        }
        if (this == SCISSORS) {
            return other == PAPER;
        }
        return false;
    }
}
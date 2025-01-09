public class Move {

    public static final int ROCK = 0;
    public static final int PAPER = 1;
    public static final int SCISSORS = 2;
    static String[] moves = {"Rock","Paper","Scissors"};

    public static String convertMove(int move){
        return moves[move];
    }

    public static boolean beats(int moveA, int moveB) {
        if (moveA == ROCK) {
            return moveB == SCISSORS;
        }
        if (moveA == PAPER) {
            return moveB == ROCK;
        }
        if (moveA == SCISSORS) {
            return moveB == PAPER;
        }
        return false;
    }

}

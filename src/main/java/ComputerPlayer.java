import java.util.Random;

public class ComputerPlayer implements Player {

    private final Random random;

    public ComputerPlayer(Random random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "Computer";
    }

    @Override
    public Move chooseMove() {
        return Move.values()[random.nextInt(3)];
    }
}

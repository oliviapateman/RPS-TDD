import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

    @Test
    void randomMove0ShouldReturnRock() {
        int move = getComputerMove(0);

        assertEquals(Move.ROCK, move);
    }

    @Test
    void randomMove1ShouldReturnPaper() {
        int move = getComputerMove(1);

        assertEquals(Move.PAPER, move);
    }

    @Test
    void randomMove2ShouldReturnScissors() {
        int move = getComputerMove(2);

        assertEquals(Move.SCISSORS, move);
    }

    private static class FakeRandom extends Random {
        private final int playerMove;

        public FakeRandom(int playerMove) {
            this.playerMove = playerMove;
        }

        @Override
        public int nextInt(int bound) {
            return playerMove;
        }
    }

    private static int getComputerMove(int playerMove) {
        var player = new ComputerPlayer(new FakeRandom(playerMove));

        return player.chooseMove();
    }

}

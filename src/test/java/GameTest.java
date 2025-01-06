import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private final Player playsRock = new ConstantMovePlayer(Move.ROCK);
    private final Player playsScissors = new ConstantMovePlayer(Move.SCISSORS);

    @Test
    void player1ShouldWin() {
        //Arrange
        Game game = new Game(playsRock, playsScissors);
        //Act
        game.play();
        //Assert
        assertEquals(playsRock, game.getWinner());
    }

    @Test
    void player2ShouldWin() {
        //Arrange
        Game game = new Game(playsScissors, playsRock);
        //Act
        game.play();
        //Assert
        assertEquals(playsRock, game.getWinner());
    }

    private static class ConstantMovePlayer extends Player {

        private final int move;

        public ConstantMovePlayer(int move) {
            this.move = move;
        }

        @Override
        public int chooseMove() {
            return move;
        }

        @Override
        public String toString() {
            if (move == Move.ROCK) return "PlaysRock";
            if (move == Move.PAPER) return "PlaysPaper";
            if (move == Move.SCISSORS) return "PlaysScissors";
            return super.toString();
        }
    }
}

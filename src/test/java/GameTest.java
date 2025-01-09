import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    private final Player playsRock = new ConstantMovePlayer(Move.ROCK);
    private final Player playsScissors = new ConstantMovePlayer(Move.SCISSORS);
    private final Player playsRockThenScissors = new TwoMovePlayer(-1);
    SpyEventListener eventListener = new SpyEventListener();

    @Test
    void drawShouldReplay(){
        Game game = new Game(playsRockThenScissors, playsRock, eventListener);

        game.play();

        eventListener.assertReportedReplay();
    }

    @Test
    void shouldReportADraw(){
        Game game = new Game(playsRockThenScissors, playsRock, eventListener);

        game.play();

        eventListener.assertReportedDraw();
    }

    @Test
    void player2MoveShouldReportScissors() {
        Game game = new Game(playsRock, playsScissors, eventListener);

        game.play();

        eventListener.assertReportedPlayerMove(playsScissors, Move.SCISSORS);
    }

    @Test
    void player1MoveShouldReportRock() {
        Game game = new Game(playsRock, playsScissors, eventListener);

        game.play();

        eventListener.assertReportedPlayerMove(playsRock, Move.ROCK);
    }

    @Test
    void player1ShouldWin() {
        //Arrange
        Game game = new Game(playsRock, playsScissors, eventListener);
        //Act
        game.play();
        //Assert
        eventListener.assertReportedWinner(playsRock);
    }

    @Test
    void player2ShouldWin() {
        //Arrange
        Game game = new Game(playsScissors, playsRock, eventListener);
        //Act
        game.play();
        //Assert
        eventListener.assertReportedWinner(playsRock);
    }

    private static class SpyEventListener implements Game.EventListener {
        private final Map<Player, Integer> reportedPlayerAndMove = new HashMap<>();
        private Player reportedWinner;
        private Boolean isADraw;
        private Boolean endOfRound;

        @Override
        public void playerChoseMove(Player player, int move) {
            reportedPlayerAndMove.put(player, move);
        }

        @Override
        public void playerWins(Player winner) {
            reportedWinner=winner;
        }

        @Override
        public void draw(Boolean isADraw) {
            this.isADraw = isADraw;
        }

        @Override
        public void endOfRound(Boolean endOfRound) {
            this.endOfRound=endOfRound;
        }

        private void assertReportedPlayerMove(Player expectedPlayer, int expectedMove) {
            assertTrue(reportedPlayerAndMove.containsKey(expectedPlayer));
            assertEquals(expectedMove, reportedPlayerAndMove.get(expectedPlayer));
        }

        private void assertReportedWinner(Player expectedPlayer){
            assertEquals(expectedPlayer, reportedWinner);
        }

        private void assertReportedDraw(){
            assertTrue(isADraw);
        }

        private void assertReportedReplay(){
            assertTrue(isADraw);
            assertTrue(endOfRound);
        }
    }

    private static class ConstantMovePlayer implements Player {
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

    private static class TwoMovePlayer implements Player {

        private int move;

        public TwoMovePlayer(int move) {
            this.move = move;
        }

        @Override
        public int chooseMove() {
            return move+=1;
        }
    }
}

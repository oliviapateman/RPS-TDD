import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GameTest {

    private final Player playsRock = mock(ComputerPlayer.class);
    private final Player playsScissors = mock(ComputerPlayer.class);
    private final Player playsRockThenScissors = mock(ComputerPlayer.class);
    Game.EventListener eventListener = mock(Game.EventListener.class);

    @BeforeEach
    void initialiseMocks(){
        when(playsRock.chooseMove()).thenReturn(Move.ROCK);
        when(playsScissors.chooseMove()).thenReturn(Move.SCISSORS);
        when(playsRockThenScissors.chooseMove()).thenReturn(Move.ROCK).thenReturn(Move.SCISSORS);
    }

    @Test
    void drawShouldReplay() {
        Game game = new Game(playsRockThenScissors, playsRock, eventListener);

        game.play();

        verify(eventListener).draw();
        verify(eventListener).playerWins(playsRock);
    }

    @Test
    void player2MoveShouldReportScissors() {
        Game game = new Game(playsRock, playsScissors, eventListener);

        game.play();

        verify(eventListener).playerChoseMove(playsScissors, Move.SCISSORS);
    }

    @Test
    void player1MoveShouldReportRock() {
        Game game = new Game(playsRock, playsScissors, eventListener);

        game.play();

        verify(eventListener).playerChoseMove(playsRock, Move.ROCK);
    }

    @Test
    void player1ShouldWin() {
        //Arrange
        Game game = new Game(playsRock, playsScissors, eventListener);
        //Act
        game.play();
        //Assert
        verify(eventListener).playerWins(playsRock);
    }

    @Test
    void player2ShouldWin() {
        //Arrange
        Game game = new Game(playsScissors, playsRock, eventListener);
        //Act
        game.play();
        //Assert
        verify(eventListener).playerWins(playsRock);
    }

}

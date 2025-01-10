import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

class PrintingEventListenerTest {

    PrintStream printStream = mock(PrintStream.class);
    PrintingEventListener printingEventListener = new PrintingEventListener(printStream);
    Player humanPlayer = new HumanPlayer(null, null);
    Player computerPlayer = new ComputerPlayer(null);

    @Test
    void computerPlayerChoseMove() {
        printingEventListener.playerChoseMove(computerPlayer, Move.ROCK);
        verify(printStream).println("Computer chose rock");
    }

    @Test
    void humanPlayerChoseMove() {
        printingEventListener.playerChoseMove(humanPlayer, Move.SCISSORS);
        verify(printStream).println("Human player chose scissors");
    }

    @Test
    void computerPlayerWins() {
        printingEventListener.playerWins(computerPlayer);
        verify(printStream).println("Computer wins!");
    }

    @Test
    void humanPlayerWins() {
        printingEventListener.playerWins(humanPlayer);
        verify(printStream).println("Human player wins!");
    }

    @Test
    void draw() {
        printingEventListener.draw();
        verify(printStream).println("It's a draw!");
    }
}
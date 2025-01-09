import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HumanPlayerTest {

    private final PrintStream printStream = mock(PrintStream.class);

    @Test
    void chooseMoveShouldPrintMessage() {
        //arrange
        var player = new HumanPlayer(printStream, new Scanner("1"));
        //act
        player.chooseMove();
        //assert
        verify(printStream).println("Enter (1) Rock or (2) Paper or (3) Scissors: ");
    }

    @Test
    void whenUserEnters1ShouldReturnRock() {
        doReturnValueTest(Move.ROCK, "1");
    }

    @Test
    void whenUserEnters2ShouldReturnPaper() {
        doReturnValueTest(Move.PAPER, "2");
    }

    @Test
    void whenUserEnters3ShouldReturnScissors() {
        doReturnValueTest(Move.SCISSORS, "3");
    }

    private void doReturnValueTest(int expected, String input) {
        //arrange
        var player = new HumanPlayer(printStream, new Scanner(input));
        //act
        int move = player.chooseMove();
        //assert
        assertEquals(expected, move);
    }

}

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HumanPlayerTest {

    private final PrintStream printStream = mock(PrintStream.class);
    Scanner scanner = mock(Scanner.class);
    Player player = new HumanPlayer(printStream, scanner);

    @Test
    void chooseMoveShouldPrintMessage() {
        when(scanner.nextInt()).thenReturn(1);
        player.chooseMove();
        verify(printStream).println("Enter (1) Rock or (2) Paper or (3) Scissors: ");
    }

    @Test
    void whenUserEnters1ShouldReturnRock() {
        when(scanner.nextInt()).thenReturn(1);
        assertEquals(Move.ROCK, player.chooseMove());
    }

    @Test
    void whenUserEnters2ShouldReturnPaper() {
        when(scanner.nextInt()).thenReturn(2);
        assertEquals(Move.PAPER, player.chooseMove());
    }

    @Test
    void whenUserEnters3ShouldReturnScissors() {
        when(scanner.nextInt()).thenReturn(3);
        assertEquals(Move.SCISSORS, player.chooseMove());
    }

}

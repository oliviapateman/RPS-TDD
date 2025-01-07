import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest {

    //to counteract the \r\n (carriage return and line feed) due to ASCII
    public static final String EXPECTED_MESSAGE = "Enter (1) Rock or (2) Paper or (3) Scissors: " + System.lineSeparator();

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Test
    void chooseMoveShouldPrintMessage() {
        //arrange
        var player = new HumanPlayer(new PrintStream(outputStream), new Scanner("1"));
        //act
        player.chooseMove();
        //assert
        assertEquals(EXPECTED_MESSAGE, outputStream.toString());
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
        var player = new HumanPlayer(new PrintStream(outputStream), new Scanner(input));
        //act
        int move = player.chooseMove();
        //assert
        assertEquals(expected, move);
    }

}

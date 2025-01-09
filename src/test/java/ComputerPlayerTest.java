import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ComputerPlayerTest {

    Random random = mock(Random.class);
    Player computerPlayer = new ComputerPlayer(random);

    @Test
    void randomMove0ShouldReturnRock() {
        when(random.nextInt(3)).thenReturn(0);
        int move = computerPlayer.chooseMove();

        assertEquals(Move.ROCK, move);
    }

    @Test
    void randomMove1ShouldReturnPaper() {
        when(random.nextInt(3)).thenReturn(1);
        int move = computerPlayer.chooseMove();

        assertEquals(Move.PAPER, move);
    }

    @Test
    void randomMove2ShouldReturnScissors() {
        when(random.nextInt(3)).thenReturn(2);
        int move = computerPlayer.chooseMove();

        assertEquals(Move.SCISSORS, move);
    }

}

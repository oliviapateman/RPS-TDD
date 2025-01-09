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

        assertEquals(Move.ROCK, computerPlayer.chooseMove());
    }

    @Test
    void randomMove1ShouldReturnPaper() {
        when(random.nextInt(3)).thenReturn(1);

        assertEquals(Move.PAPER, computerPlayer.chooseMove());
    }

    @Test
    void randomMove2ShouldReturnScissors() {
        when(random.nextInt(3)).thenReturn(2);

        assertEquals(Move.SCISSORS, computerPlayer.chooseMove());
    }

}

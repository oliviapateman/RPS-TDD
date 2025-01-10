import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveTest {

    @Test
    void rockShouldBeatScissors() {
        assertTrue(Move.ROCK.beats(Move.SCISSORS));
    }

    @Test
    void paperShouldBeatRock() {
        assertTrue(Move.PAPER.beats(Move.ROCK));
    }

    @Test
    void scissorsShouldBeatPaper() {
        assertTrue(Move.SCISSORS.beats(Move.PAPER));
    }

    @Test
    void paperShouldNotBeatScissors() {
        assertFalse(Move.PAPER.beats(Move.SCISSORS));
    }

}

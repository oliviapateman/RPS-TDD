import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Player humanPlayer = new HumanPlayer(printStream, new Scanner(System.in));
        Player computerPlayer = new ComputerPlayer(new Random());
        //Game game = new Game(humanPlayer, computerPlayer, new PrintingEventListener(printStream));
        Tournament tournament = new Tournament(humanPlayer, computerPlayer, new PrintingEventListener(printStream));
        tournament.doThreeRounds();

        //page 81
    }
}

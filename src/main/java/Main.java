import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Player humanPlayer = new HumanPlayer(printStream, new Scanner(System.in));
        Player computerPlayer = new ComputerPlayer(new Random());
        new Game(humanPlayer, computerPlayer, new PrintingEventListener(printStream)).play();
    }
}

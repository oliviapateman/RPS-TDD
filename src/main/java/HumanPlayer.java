import java.io.PrintStream;
import java.util.Scanner;

public class HumanPlayer implements Player {

    private final PrintStream printStream;
    private final Scanner scanner;

    public HumanPlayer(PrintStream printStream, Scanner scanner) {
        this.printStream = printStream;
        this.scanner = scanner;
    }

    @Override
    public String toString() {
        return "Human player";
    }

    @Override
    public Move chooseMove() {
        printStream.println("Enter (1) Rock or (2) Paper or (3) Scissors: ");
        return Move.values()[scanner.nextInt() - 1];
    }
}

import java.io.PrintStream;
import java.util.Scanner;

public class HumanPlayer implements Player {

    private final PrintStream printStream;
    private Scanner scanner;

    public HumanPlayer(PrintStream printStream, Scanner scanner) {
        this.printStream = printStream;
        this.scanner = scanner;
    }

    @Override
    public int chooseMove() {
        printStream.println("Enter (1) Rock or (2) Paper or (3) Scissors: ");
        return scanner.nextInt() - 1;
    }
}

import java.io.PrintStream;

public class PrintingEventListener implements Game.EventListener {

    private final PrintStream printStream;

    public PrintingEventListener(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void playerChoseMove(Player player, int move) {
        printStream.println(player + " chose " + Move.convertMove(move));
    }

    @Override
    public void playerWins(Player winner) {
        printStream.println(winner+" wins!");
    }

    @Override
    public void draw() {
        printStream.println("It's a draw!");
    }

}

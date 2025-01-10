public class Game {

    public interface EventListener{
        void playerChoseMove(Player player, Move move);
        void playerWins(Player winner);
        void draw();
    }

    private final Player player1;
    private final Player player2;
    private final EventListener eventListener;
    private Player winner;

    public Game(Player player1, Player player2, EventListener eventListener) {
        this.player1 = player1;
        this.player2 = player2;
        this.eventListener = eventListener;
    }

    public void play() {
        while (winner == null) {
            Move player1Move = player1.chooseMove();
            Move player2Move = player2.chooseMove();

            eventListener.playerChoseMove(player1, player1Move);
            eventListener.playerChoseMove(player2, player2Move);

            if (player1Move.beats(player2Move)) {
                winner = player1;
            } else if (player2Move.beats(player1Move)) {
                winner = player2;
            } else {
                eventListener.draw();
            }
        }
        eventListener.playerWins(winner);
    }

}

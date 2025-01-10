public class Tournament implements Game.EventListener {

    public Tournament(Player player1, Player player2, Game.EventListener eventListener) {
        this.player1 = player1;
        this.player2 = player2;
        this.eventListener = eventListener;
        game = new Game(player1, player2, this);
    }

    private final Player player1;
    private final Player player2;
    private final Game.EventListener eventListener;
    private final Game game;

    int player1Score = 0, player2Score = 0;

    public void doThreeRounds() {
        int roundCounter = 0;
        while (roundCounter < 3) {
            game.play();
            roundCounter += 1;
        }
        winnerOfTournament();
    }

    public void increasePlayerWinScore(Player winner) {
        if (winner == player1) {
            player1Score += 1;
        } else if (winner == player2) {
            player2Score += 1;
        }
    }

    public void winnerOfTournament() {
        if (player1Score > player2Score) {
            System.out.println(player1 + " wins the tournament! They win by " + (player1Score - player2Score) + " point(s)!");
        } else {
            System.out.println(player2 + " wins the tournament! They win by " + (player2Score - player1Score) + " point(s)!");
        }
    }

    @Override
    public void playerChoseMove(Player player, Move move) {
        this.eventListener.playerChoseMove(player, move);
    }

    @Override
    public void playerWins(Player winner) {
        increasePlayerWinScore(winner);
        this.eventListener.playerWins(winner);
    }

    @Override
    public void draw() {
        this.eventListener.draw();
    }
}

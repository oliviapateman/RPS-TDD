public class Tournament extends Game{

    private final Player player1;
    private final Player player2;

    public Tournament(Player player1, Player player2, EventListener eventListener) {
        super(player1, player2, eventListener);
        this.player1 = player1;
        this.player2 = player2;
    }

    int player1Score = 0, player2Score = 0;

    public void doThreeRounds(){
        int roundCounter = 0;
        while (roundCounter < 3){
            play();
            increasePlayerWinScore();
            roundCounter+=1;
            winner=null;
        }
        winnerOfTournament();
    }

    public void increasePlayerWinScore(){
        if (winner == player1){
            player1Score+=1;
        }else if (winner == player2){
            player2Score+=1;
        }
    }

    public void winnerOfTournament(){
        if (player1Score>player2Score){
            System.out.println(player1 + " wins the tournament! They win by " + (player1Score-player2Score) + " point(s)!");
        } else {
            System.out.println(player2 + " wins the tournament! They win by " + (player2Score-player1Score) + " point(s)!");
        }
    }
}

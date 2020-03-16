import java.util.Scanner;

public class Game {

    private Board board;
    private boolean running;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(){
        this.running = true;
        board = new Board();
        this.player1 = new Player(1);
        this.player2 = new Player(2);
        this.currentPlayer = player1;
        this.board.printBoard();
    }

    public void switchPlayer(){
        if(currentPlayer.getPlayerNo() == 1){
            currentPlayer = player2;
        }else{
            currentPlayer = player1;
        }
    }

    private void gameLoop(){
        while(this.running){

            System.out.println(currentPlayer.getName() + "'s turn!\n");

            while(!currentPlayer.makeMove(this.board));
            this.board.printBoard();

            if(this.board.checkWin(currentPlayer.getSymbol())){
                displayResult("win");
            }else if(this.board.checkDraw()){
                displayResult("draw");
            }else{
                switchPlayer();
            }

        }
    }



    private void displayResult(String result) {

        if(result == "win") {
            System.out.println(currentPlayer.getName() + " has won!");
        }else{
            System.out.println("It's A Draw!!\n");
        }
        System.out.println("Would you like to play again? (y/n):");

        Scanner sc = new Scanner(System.in);

        char answer = sc.next().charAt(0);

        while(answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N'){
            System.out.println("Invalid input!\n");
            System.out.println("Would you like to play again? (y/n):");
            answer = sc.next().charAt(0);
        }

        if(answer == 'y' || answer == 'Y'){
            reset();
        }else{
            this.running = false;
            System.out.println("GAME OVER!!");
        }

    }

    private void reset(){
        this.board.clearBoard();
        this.board.printBoard();
    }

    public void run(){
        gameLoop();
    }


}

import java.util.Scanner;

public class Player {

    private char symbol;
    private String name;
    private Scanner sc;
    private int playerNo;

    public Player(int playerNo){
        this.playerNo = playerNo;
        sc = new Scanner(System.in);
        System.out.println("Please enter the name of Player " + playerNo+ ": ");
        this.name = sc.nextLine();

        System.out.println("Please enter the symbol of Player " + playerNo + ": ");
        this.symbol = sc.next().charAt(0);
    }

    public int[] getMove(int boardSize){
        System.out.println("Please enter the x-coordinate: ");
        int x = sc.nextInt() - 1;

        while(x < 0 || x > boardSize-1){
            System.out.println("Invalid Coordinate! \n");
            System.out.println("Please enter the x-coordinate: ");
            x = sc.nextInt() - 1;
        }

        System.out.println("Please enter the y-coordinate: ");
        int y = sc.nextInt() -1;

        while(y < 0 || y > boardSize-1){
            System.out.println("Invalid Coordinate! \n");
            System.out.println("Please enter the y-coordinate: ");
            y = sc.nextInt() - 1;
        }


        return new int[]{x, y};
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean makeMove(Board board){
        int[] playersMove = getMove(board.getSIZE());
        return board.updateBoard(playersMove[0], playersMove[1], this.symbol);
    }

    public int getPlayerNo() {
        return playerNo;
    }
}

import java.lang.reflect.Array;

public class Board {

    private char board[][];
    private final int SIZE;

    public Board(){
        this.SIZE = 3;
        this.board = new char[SIZE][SIZE];
        this.initializeBoard();
    }

    private void initializeBoard(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                board[i][j] = '.';
            }
        }
    }

    public void clearBoard(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                board[i][j] = '.';
            }
        }
    }


    public void printBoard(){

        System.out.print("    ");

        for(int i = 1; i <= SIZE; i++){
            System.out.print(i + "   ");
        }

        System.out.println("\n --------------");


        for(int i = 0; i < SIZE; i++){
            System.out.print( (i+1) + " | ");
            for(int j = 0; j < SIZE; j++){
                System.out.print( board[i][j] + " | ");

            }
            System.out.println("\n --------------");
        }

    }

    public int getSIZE() {
        return SIZE;
    }

    public boolean updateBoard(int x, int y, char symbol){
        if(board[y][x] == '.'){
            board[y][x] = symbol;
            return true;
        }else{
            System.out.println("Invalid Coordinates!\n");
            return false;
        }
    }

    public boolean checkDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkHorizontal(char symbol){

        int counter = 0;

        for(int i = 0; i < SIZE; i++){
            counter = 0;
            for(int j = 0; j < SIZE; j++){
                if(board[i][j] == symbol){
                    counter++;
                }
                if(counter == 3) return true;
            }
        }

        return false;
    }

    public boolean checkVertical(char symbol){
        int counter = 0;

        for(int i = 0; i < SIZE; i++){
            counter = 0;
            for(int j = 0; j < SIZE; j++){
                if(board[j][i] == symbol){
                    counter++;
                    if(counter == 3) return true;
                }
            }
        }

        return false;
    }

    public boolean checkDiagonal(char symbol){

        int counter = 0;

        //bottomleft to top right
        for(int i = SIZE -1; i >= 0; i--){
            counter = 0;

            for(int j = 0; j < SIZE; j++){
                if(board[i][j] == symbol){
                    counter++;
                    if(counter == 3) return true;
                }
            }
        }

        counter = 0;

        //top left to bottom right
        for(int i = 0; i < SIZE; i++){
            if(board[i][i] == symbol){
                counter++;
                if(counter == 3) return true;
            }
        }

        return false;
    }

    public boolean checkWin(char symbol){
        if(checkDiagonal(symbol) || checkHorizontal(symbol) || checkVertical(symbol)){
            return true;
        }
        return false;
    }
}

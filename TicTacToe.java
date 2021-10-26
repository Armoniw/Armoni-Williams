import java.util.*;

import javax.security.auth.x500.X500Principal;
public class TicTacToe {
    
    public static void main(String[] args) {
        String[][] gameBoard = {{" ", " ", " "},{" ", " ", " "},{" ", " ", " "}};
        int turn = 0;
        int position;
        String player;
        while (gameIsOn(turn, gameBoard)){
            player = whoseTurn(turn);
            position = getUserSelc();
            gameBoard[posRow(position)][posCol(position)] = player;
            printGameBoard(gameBoard);
            turn++;
            //won?
        }
    }
    public static boolean findDiaRightWins(String[][] gameBoard){
        for(int i=0; i<3; i++){
            if(!gameBoard[i][0].equals(" ")){
                if (gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0])){
                    return true;
                } 
            }
        
        }
        return false;
    }
    public static boolean findDiaLeftWins(String[][] gameBoard){
        for(int i=0; i<3; i++){
            if(!gameBoard[i][0].equals(" ")){
                if (gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2])){
                    return true;
                } 
            }
        
        }
        return false;
    }
    public static boolean findColWins(String[][] gameBoard){
        for(int i=0; i<3; i++){
            if(!gameBoard[0][i].equals(" ")){
                if (gameBoard[0][i].equals(gameBoard[0][i]) && gameBoard[0][i].equals(gameBoard[2][i])){
                    return true;
                } 
            }
        
        }
        return false; 
    }
    
        public static boolean findRowWins(String[][] gameBoard){
        for(int i=0; i<3; i++){
            if(!gameBoard[i][0].equals(" ")){
                if (gameBoard[i][0].equals(gameBoard[i][0]) && gameBoard[i][0].equals(gameBoard[i][2])){
                    return true;
                } 
            }
        
        }
        return false; 
    }
        public static boolean gameIsOn(int turn, String[][]gameBoard){
            if (somebodyWon(gameBoard)){
                return false;
            }else{
                if (turn >= 9) {
                    return false;
                }else{
                    return true;
                }
            }
        }
        public static boolean somebodyWon(String[][] gameBoard) {
           if (findRowWins(gameBoard) || findColWins(gameBoard) || findDiaLeftWins(gameBoard)|| findDiaRightWins(gameBoard)){  
               return true;
               }  else {
                   return false;
               }
            
        }
        public static String whoseTurn(int turn) {
            String player;
            if (turn % 2 == 0){
                player = "X";
                
           }else{
                player = "O";
           }
           return player;
        
        }
        public static int posCol(int position){
            int col;
            if (position == 1 || position == 4 || position == 7) {
                col = 0; 
            } else if (position == 2 || position == 5 || position == 8){
                col = 1;
            } else { 
                    col = 2;
                }
                return col;
        }
        
        public static int posRow(int position){
            int row;
            if (position == 1 || position == 2 || position == 3) {
                row = 0; 
            } else if (position == 4 || position == 5 || position == 6){
                row = 1;
            } else { 
                    row = 2;
                }
                return row;
        }
        public static int getUserSelc(){
            Scanner k = new Scanner(System.in);
            printNumpad();
            print("\nPick the number of where you would like to go? ");
            int usernum = 0;
            do {
                usernum = k.nextInt();
                if (usernum > 9 || usernum < 1){
                    println("That isn't an option try again");
                } 
                                
                 
            } while (usernum > 9 || usernum <1);
            return usernum;
        }
        public static void printGameBoard(String[][] gameBoard){
            for (String[]row : gameBoard){
                for (String num: row){
                    print(num + " ");
                }
                println("");
            }
        } 
        public static void printNumpad(){
            int[][] numpad = {{1,2,3},{4,5,6},{7,8,9}};
            for (int[] row : numpad){
                for (int num: row){
                    print(num + " ");
                }
                println("");
            }
        }

    public static void println(String s) {
        System.out.println(s);
      }
    
    public static void print(String s) {
        System.out.print(s);
      }
     
}

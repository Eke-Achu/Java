package game;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        ticTacToe();
    }
    
    static void ticTacToe() {
        char[][] plays = initializeBoard();
        
        char last = 'O';
        boolean win = true;
        
        while (win) {
            if (last == 'O') {
                last = playX(plays);
            }
            else {
                last = playO(plays);
            }
            
            if (win(plays) || isFilled(plays))
                win = false;
        } 
        
        grid(plays);
        if (win(plays))
            System.out.println(last + " player won");
        else
            System.out.println("It is a draw");
    }
    
    static void grid(char[][] plays) {
        System.out.println("-------------");
        
        for (int i = 0; i < plays.length; i++) {
            for (int j = 0; j < plays[i].length; j++) {
                System.out.printf("|%2c ", plays[i][j]);
            }
            System.out.print("|\n-------------\n");
        }
    }
    
    static char[][] initializeBoard() {
        char[][] board = new char[3][3];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ' ';
                
            }
        }
        
        return board;
    }
    
    static char playX(char[][] board) {
        Scanner input = new Scanner(System.in);
        
        grid(board);
        
        System.out.print("Enter a row (0, 1, or 2) for player X: ");
        int row = input.nextInt();
        
        System.out.print("Enter a column (0, 1, or 2) for player X: ");
        int column = input.nextInt();
        
        if (fillable(board, row, column))
            board[row][column] = 'X';
        else {
            System.out.println("Space is occupied. Try again.");
            playX(board);
        }
        
        return 'X';
    }
    
    static char playO(char[][] board) {
        Scanner input = new Scanner(System.in);
        
        grid(board);
        
        System.out.print("Enter a row (0, 1, or 2) for player O: ");
        int row = input.nextInt();
        
        System.out.print("Enter a column (0, 1, or 2) for player O: ");
        int column = input.nextInt();
        
        if (fillable(board, row, column))
            board[row][column] = 'O';
        else {
            System.out.println("Space is occupied. Try again.");
            playO(board);
        }
        
        return 'O';
    }
    
    static boolean fillable(char[][] board, int row, int column) {
        return board[row][column] == ' ';
    }
    
    static boolean verticalWin(char[][] plays) {
        boolean win = false;
        
        for (int i = 0; i < plays.length; i++) {
            if (plays[0][i] != ' ' && plays[0][i] == plays[1][i] 
                && plays[0][i] == plays[2][i])
                return true;
        }
        
        return win;
    }
    
    
    static boolean horizontalWin(char[][] plays) {
        for (int i = 0; i < plays.length; i++) {
            if (plays[i][0] != ' ' && plays[i][0] == plays[i][1] 
                && plays[i][0] == plays[i][2])
                return true;
        }
        
        return false;
    }
    
    static boolean diagonalWin(char[][] plays) {
        return leftDiagonalWin(plays) || rightDiagonalWin(plays);
    }
    
    static boolean leftDiagonalWin(char[][] plays) {
        return plays[0][0] != ' ' && plays[0][0] == plays[1][1] 
                && plays[0][0] == plays[2][2];
    }
    
    static boolean rightDiagonalWin(char[][] plays) {
        return plays[0][2] != ' ' && plays[0][2] == plays[1][1] 
                && plays[0][2] == plays[2][0];
    }
    
    static boolean isFilled(char[][] plays) {
        for (int i = 0; i < plays.length; i++) {
            for (int j = 0; j < plays.length; j++) {
                if (plays[i][j] == ' ')
                    return false;
                
            }
        }
        
        return true;
    }
    
    static boolean win(char[][] plays) {
        return verticalWin(plays) || horizontalWin(plays) || diagonalWin(plays);
    }
}

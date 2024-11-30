package game;

import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        connectFour();
    }
    
    static void connectFour() {
        char[][] plays = initializeGrid();
        
        char last = 'Y';
        
        boolean notFound = true;
        while (notFound) {
            if (last == 'Y') {
                last = playR(plays);
            }
            else {
                last = playY(plays);    
            }
            
            if (winFound(plays) || isFilled(plays))
                notFound = false;
        } 
        
        grid(plays);
        
        if (winFound(plays))
            System.out.println("The " + (last == 'R'? "red": "yellow") + " player won");
        else
            System.out.println("It is a draw. Good game!");
    }
    
    
    //Initializes the array to be used for the game with empty spaces
    static char[][] initializeGrid() {
        char[][] plays = new char[6][7];
        
        for (int i = 0; i < plays.length; i++) {
            for (int j = 0; j < plays[i].length; j++) {
                plays[i][j] = ' ';
                
            }
        }
        
        return plays;
    }
    
            
    /*
    Prints out the grid witht the current state of the game including all 
    plays made
    */
    static void grid(char[][] plays) {
        System.out.print("|");
        
        for (int i = 0; i < plays.length; i++) {
            for (int j = 0; j < plays[i].length; j++) {
                System.out.print(plays[i][j] + "|");
            }
            System.out.print("\n|");
        }
        System.out.println("\b---------------");
    }
    
    
    /*
    Prompts the red user to make the next play after printing the current 
    status of the game, and then returns 'R' signifying that they played last
    */
    static char playR(char[][] plays) {
        Scanner input = new Scanner(System.in);
        
        grid(plays);
        System.out.print("Drop a red disk at column (0–6): ");
        int column = input.nextInt();
        
        if (column < 0 || column > 6) {
            System.out.println("Invalid input. Try again.");
            playR(plays);
        }
        
        for (int i = plays.length - 1; i >= 0; i--) {
            if (isFillable(plays, i, column)) {
                plays[i][column] = 'R';
                break;
            }
        }
        return 'R';
    }
    
    
    /*
    Prompts the yellow user to make the next play after printing the current 
    status of the game, and then returns 'Y' signifying that they played last
    */
    static char playY(char[][] plays) {
        Scanner input = new Scanner(System.in);
        
        grid(plays);
        System.out.print("Drop a yellow disk at column (0–6): ");
        int column = input.nextInt();
        
        if (column < 0 || column > 6) {
            System.out.println("Invalid input. Try again.");
            playY(plays);
        }
        
        for (int i = plays.length - 1; i >= 0; i--) {
            if (isFillable(plays, i, column)) {
                plays[i][column] = 'Y';
                break;
            }
        }
        return 'Y';
    }
    
    
    /*
    Checks if the intended play is possible by checking if the given index 
    contains a space or not
    */
    static boolean isFillable(char[][] plays, int row, int column) {
        return plays[row][column] == ' ';
    }
    
    
    static boolean rowWin(char[][] plays) {
        char play, count;
        
        for (int i = plays.length - 1; i >= 0; i--) { //Traverses each row
            
            for (int j = 0; j < plays[i].length; j++) { //Traverses each element in the row
                play = plays[i][j];
                
                if (play == ' ')
                    continue;
                
                count = 1;
                
                for (int k = j + 1; k < plays[i].length; k++) { //Checks for a consecutive four
                    if (play == plays[i][k]) {
                        count++;
                        
                        if (count == 4) 
                            return true;
                        
                    }
                    else 
                        break;
                }
                
            }
        }
        
        return false;
    }
    
    static boolean columnWin(char[][] plays) {
        char play, count;
        
        for (int i = 0; i < plays[0].length; i++) { //Traverses each column
            
            for (int j = plays.length - 1; j >= 0; j--) { //Traverse each element in the column
                play = plays[j][i];
                
                if (play == ' ')
                    continue;
                
                count = 1;
                
                for (int k = j - 1; k >= 0; k--) { //Checks for a consecutive four
                    if (play == plays[k][i]) {
                        count++;
                        
                        if (count == 4) 
                            return true;
                        
                    }
                    else 
                        break;
                }
                
            }
        }
        
        return false;
    }
    
    
    static boolean mainDiagonalWin(char[][] plays) {
        char play, count;
        
        for (int i = 0; i < plays.length; i++) { //Traverses each row
            
            for (int j = 0; j < plays[i].length; j++) { //Traverses each column
                play = plays[i][j];
                
                if (play == ' ')
                    continue;
                
                count = 1;
                
                for (int row = i + 1, col = j + 1; row < plays.length && col < plays[i].length; 
                    row++, col++) { //Increments both the row and column after each iteration
                    if (play == plays[row][col]) {
                        count++;
                        
                        if (count == 4) 
                            return true;
                    }
                    else
                        break;
                }
               
            }
        }
        
        return false;
    }
    
    
    static boolean antiDiagonalWin(char[][] plays) {
        char play, count;
        
        for (int i = 0; i < plays.length; i++) { //Traverses each row
            
            for (int j = plays[i].length - 1; j >= 0; j--) { //Traverses each column
                play = plays[i][j];
                
                if (play == ' ')
                    continue;
                
                count = 1;
                
                for (int row = i + 1, col = j - 1; row < plays.length && col >= 0; 
                    row++, col--) { //Increments the row but decrements the column
                    if (play == plays[row][col]) {
                        count++;
                        
                        if (count == 4) 
                            return true;
                    }
                    else
                        break;
                }
               
            }
        }
        
        return false;
    }
    
    static boolean winFound(char[][] plays) { //Checks for a win in at least one of the directions
        return rowWin(plays) || columnWin(plays) || mainDiagonalWin(plays)
            || antiDiagonalWin(plays);
    }
    
    
    static boolean isFilled(char[][] plays) { //Checks that no more plays can be made
        for (int i = 0; i < plays.length; i++) {
            for (int j = 0; j < plays.length; j++) {
                if (plays[i][j] == ' ')
                    return false;
            }
        }
        
        return true;
    }
}

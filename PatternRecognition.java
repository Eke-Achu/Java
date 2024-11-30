import java.util.Scanner;

public class PatternRecognition {
    public static void main(String[] args) {
        patternRecognition();
    }
    
    static void patternRecognition() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt();
        
        System.out.print("Enter the number of columns: ");
        int columns = input.nextInt();
        
        int[][] array = new int[rows][columns];
        
        System.out.println("Enter the values in the array:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = input.nextInt();
                
            }
        }
        
        System.out.println("The array " + (hasConsecutiveFour(array)? "has": 
            "does not have") + " consecutive four");
    }
    
    
    static boolean hasConsecutiveFour(int[][] array) {
        return isConsecutiveFourColumn(array) || 
                isConsecutiveFourRow(array) || 
                isConsecutiveMainDiagonal(array) ||
                isConsecutiveAntiDiagonal(array);
    }
    
    static boolean isConsecutiveFourRow(int[][] values) {
        int num, count;
        
        for (int i = 0; i < values.length; i++) {
            
            for (int j = 0; j < values[i].length; j++) {
                num = values[i][j];
                count = 1;
                
                for (int k = j + 1; k < values[i].length; k++) {
                    if (num == values[i][k]) {
                        count++;
                        
                        if (count == 4) 
                            return true;
                        
                    }
                    else {
                        break;
                    }
                }
                
            }
        }
        
        return false;
    }
    
    static boolean isConsecutiveFourColumn(int[][] values) {
        int num, count;
        
        for (int i = 0; i < values[0].length; i++) {
            
            for (int j = 0; j < values.length; j++) {
                num = values[j][i];
                count = 1;
                
                for (int k = j + 1; k < values.length; k++) {
                    if (num == values[k][i]) {
                        count++;
                        
                        if (count == 4) 
                            return true;
                    }
                }
                
            }
        }
        
        return false;
    }
    
    
    static boolean isConsecutiveMainDiagonal(int[][] values) {
        int num, count;
        
        for (int i = 0; i < values.length; i++) {
            
            for (int j = 0; j < values[i].length; j++) {
                num = values[i][j];
                count = 1;
                
                for (int row = i + 1, col = j + 1; row < values.length && col < values[i].length; 
                    row++, col++) {
                    if (num == values[row][col]) {
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
    
    
    static boolean isConsecutiveAntiDiagonal(int[][] values) {
        int num, count;
        
        for (int i = 0; i < values.length; i++) {
            
            for (int j = values[i].length - 1; j >= 0; j--) {
                num = values[i][j];
                count = 1;
                
                for (int row = i + 1, col = j - 1; row < values.length && col >= 0; 
                    row++, col--) {
                    if (num == values[row][col]) {
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
}
